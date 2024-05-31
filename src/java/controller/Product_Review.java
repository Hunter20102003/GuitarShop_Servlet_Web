/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ProductDBO;
import model.UserDBO;

/**
 *
 * @author LEGION
 */
public class Product_Review extends HttpServlet {

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
            out.println("<title>Servlet Product_Review</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Product_Review at " + request.getContextPath() + "</h1>");
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
        String idProduct = request.getParameter("idPro");
        DAO dao = new DAO();
        ProductDBO product = dao.getProductById(Integer.parseInt(idProduct));
        request.setAttribute("product", product);
        request.getRequestDispatcher("review_product.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter o = response.getWriter();
        HttpSession session = request.getSession();
        UserDBO user = (UserDBO) session.getAttribute("user");
        if (user != null) {
            String mess = request.getParameter("mess");
            if (mess == null) {
                mess = "";
            }
            String[] star = request.getParameterValues("star");
            String id = request.getParameter("idProduct");
            if (star == null) {
                request.setAttribute("starEmpty", "Vui lòng đánh giá số sao cho sản phẩm");

            } else {
                DAO dao = new DAO();
                int n = dao.addReviewProduct(user.getId(), Integer.parseInt(id), star.length, mess);
                if (n > 0) {
                    request.setAttribute("success", "Đánh giá sản phẩm thành công");
                }

                // o.print(n);
            }
            //o.print(star.length);
        }
        // o.print(user);
        request.getRequestDispatcher("review_product.jsp").forward(request, response);
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
