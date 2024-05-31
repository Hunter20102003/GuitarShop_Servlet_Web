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
@WebServlet(name = "Load_Products_By_Category", urlPatterns = {"/category"})
public class Load_Products_By_Category extends HttpServlet {

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
        
        String s = request.getParameter("id");
        String idPage = request.getParameter("idPage");
        ArrayList<ProductDBO> list = dao.getProductByCategory(Integer.parseInt(s));
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
            session.setAttribute("idPage", idPage);
            session.setAttribute("numberOfPage", numberOfPage);
            session.setAttribute("listProduct", dao.pageProduct(list, Integer.parseInt(idPage)));
            session.setAttribute("listPageProduct",list);
        } else {
            request.setAttribute("emptyProduct", "There are no any product");
        }
        session.setAttribute("cateActive", s);
        session.setAttribute("listCategories", list1);
        session.setAttribute("listSuppliers", list2);

        session.setAttribute("active", "shop");
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
