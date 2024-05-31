/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import model.CategoryDBO;
import model.ProductDBO;

/**
 *
 * @author LEGION
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12
)
@WebServlet(name = "Edit_Product", urlPatterns = {"/editProduct"})
public class Edit_Product extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Edit_Product</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Edit_Product at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        String idProduct = request.getParameter("idProduct");
        ProductDBO product = dao.getProductById(Integer.parseInt(idProduct));
        HttpSession session = request.getSession();
        session.setAttribute("nameProduct", product.getName());
        session.setAttribute("imgProduct", product.getImg());
        String formatPrice = String.format("%.0f", product.getPrice());

        request.setAttribute("id", idProduct);
        request.setAttribute("name", product.getName());
        request.setAttribute("price", formatPrice);
        request.setAttribute("des", product.getDescription());
        request.setAttribute("idCate", product.getCategory().getId());
        request.setAttribute("idSup", product.getSupplier().getId());
        request.setAttribute("dis", product.getDiscount());
        request.setAttribute("quantity", product.getQuantity());
        request.setAttribute("status", product.getStatus());
        request.setAttribute("img", product.getImg());

        request.setAttribute("listCate", dao.getAllCategories());
        request.setAttribute("listSup", dao.getAllSuppliers());
        request.getRequestDispatcher("admin/edit_product.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private boolean checkNumValid(String id) {
        try {
            Double.parseDouble(id);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean checkDiscount(String discount) {

        if (!checkNumValid(discount)) {
            return false;
        }
        if (Double.parseDouble(discount) < 0 || Double.parseDouble(discount) > 1) {
            return false;
        }
        return true;
    }
    private static final String UPLOAD_DIRECTORY = "E:\\PRJ301\\GuitarShop\\web\\img_product";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String price = request.getParameter("price");
        String name = request.getParameter("name");
        String des = request.getParameter("des");
        String idCate = request.getParameter("idCate");
        String idSup = request.getParameter("idSup");
        String discount = request.getParameter("discount");
        String quantity = request.getParameter("quantity");
        String status = request.getParameter("status");
        Part part = request.getPart("file");
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        double dis = 0;
        double pricee = 0;
        boolean check = false;
        String imgProduct = "";
        String nameSession = (String) session.getAttribute("nameProduct");
        if (!nameSession.equalsIgnoreCase(name)) {
            if (dao.productExist(name) == true) {
                request.setAttribute("pExist", "Sản phẩm đã tồn tại");
                check = true;
            }
        }

        if (!checkNumValid(price)) {
            request.setAttribute("numError", "Vui lòng nhập giá sản phẩm là một số");
            check = true;
        } else {
            pricee = Integer.parseInt(price);

        }
        if (!checkDiscount(discount)) {
            request.setAttribute("numError1", "Vui lòng nhập giảm giá tương ứng với tỷ lệ phần trăm");
            check = true;
        } else {
            dis = Double.parseDouble(discount);
        }
        if (part.getSize() == 0) {
            imgProduct = (String) session.getAttribute("imgProduct");
          
        }

        if (check == false) {

            if (part.getSize() > 0) {
                String fileName = getFileName(part);
                String uniqueFileName = UUID.randomUUID().toString() + "-" + fileName;
                String uploadFilePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;
                part.write(uploadFilePath);
                imgProduct = "img_product" + File.separator + uniqueFileName;
            }
            int a = dao.updateProduct(Integer.parseInt(id), name, des, pricee, Integer.parseInt(quantity), imgProduct, dis, Integer.parseInt(idCate), Integer.parseInt(idSup), Integer.parseInt(status));

            response.sendRedirect("products");
            return;

        }
        request.setAttribute("id", id);
        request.setAttribute("price", price);
        request.setAttribute("name", name);
        request.setAttribute("des", des);
        request.setAttribute("idCate", idCate);
        request.setAttribute("idSup", idSup);
        request.setAttribute("quantity", quantity);
        request.setAttribute("discount", discount);
        request.setAttribute("status", status);
        request.setAttribute("img", imgProduct);
        request.setAttribute("dis", discount);

        request.setAttribute("listCate", dao.getAllCategories());
        request.setAttribute("listSup", dao.getAllSuppliers());
        request.getRequestDispatcher("admin/edit_product.jsp").forward(request, response);

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
