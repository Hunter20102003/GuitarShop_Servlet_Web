/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.CategoryDBO;
import model.ProductDBO;
import model.SupplierDBO;

/**
 *
 * @author LEGION
 */
@WebServlet(name = "Load_Product_By_Filter", urlPatterns = {"/filter"})
public class Load_Product_By_Filter extends HttpServlet {

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
            out.println("<title>Servlet Load_Product_By_Filter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Load_Product_By_Filter at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String idPage = request.getParameter("idPage");

//        ArrayList<CategoryDBO> list1 = dao.getAllCategories();
//        ArrayList<SupplierDBO> list2 = dao.getAllSuppliers();
        String listCateId[] = request.getParameterValues("idCate");
        String listSupId[] = request.getParameterValues("idSup");
        String listPriceId[] = request.getParameterValues("idPrice");
        ArrayList<Integer> listCateId1 = new ArrayList<>();
        ArrayList<Integer> listSupId1 = new ArrayList<>();
        ArrayList<Integer> listPriceId1 = new ArrayList<>();

        if (listCateId == null) {
            listCateId1.add(0);
        } else {
            for (String n : listCateId) {
                listCateId1.add(Integer.parseInt(n));
            }
        }

        if (listSupId == null) {
            listSupId1.add(0);
        } else {
            for (String n : listSupId) {
                listSupId1.add(Integer.parseInt(n));
            }
        }
        if (listPriceId == null) {
            listPriceId1.add(0);
        } else {
            for (String n : listPriceId) {
                listPriceId1.add(Integer.parseInt(n));
            }
        }
        if (idPage == null) {
            idPage = "1";
        }
        ArrayList<ProductDBO> list = dao.getListFilter(listCateId1, listSupId1, listPriceId1);
        if (list.isEmpty()) {
            request.setAttribute("emptyProduct", "There are no any product");
        } else {
            int numberOfPage = list.size() / 12;
            if (list.size() % 12 != 0) {
                numberOfPage++;
            }
            session.setAttribute("numberOfPage", numberOfPage);
            session.setAttribute("idPage", Integer.parseInt(idPage));
            session.setAttribute("listProduct", dao.pageProduct(list, Integer.parseInt(idPage)));
            session.setAttribute("listPageProduct", list);

        }

        session.setAttribute("listCateId", listCateId1.toString());
        session.setAttribute("listSupId", listSupId1.toString());
        session.setAttribute("listPriceId", listPriceId1.toString());

//        request.setAttribute("listCategories", list1);
//        request.setAttribute("listSuppliers", list2);
        request.setAttribute("active", "shop");

        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
        processRequest(request, response);
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
