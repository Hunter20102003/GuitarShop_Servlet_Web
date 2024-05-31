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
@WebServlet(name = "Search_Product_By_Name", urlPatterns = {"/search"})
public class Search_Product_By_Name extends HttpServlet {

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
            out.println("<title>Servlet Search_Product_By_Name</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Search_Product_By_Name at " + request.getContextPath() + "</h1>");
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
        String s = request.getParameter("search");
        HttpSession session = request.getSession();
        String idPage = request.getParameter("idPage");

        DAO dao = new DAO();
        ArrayList<ProductDBO> list = dao.findProductByName(s);
        ArrayList<CategoryDBO> list1 = dao.getAllCategories();
        ArrayList<SupplierDBO> list2 = dao.getAllSuppliers();
        if (!list.isEmpty()) {

            if (idPage == null) {
                idPage = "1";
            }
            int numberOfPage = list.size() / 12;
            if (list.size() % 12 != 0) {
                numberOfPage++;
            }
            session.setAttribute("numberOfPage", numberOfPage);
            session.setAttribute("listPageProduct", list);
            request.setAttribute("idPage", idPage);
            request.setAttribute("listProduct", dao.pageProduct(list, Integer.parseInt(idPage)));
        } else {
            request.setAttribute("emptyProduct", "There are no any product");
        }

        
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
