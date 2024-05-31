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
import java.util.ArrayList;
import model.CategoryDBO;
import model.ProductDBO;
import model.SupplierDBO;

/**
 *
 * @author LEGION
 */
@WebServlet(name = "Load_All_Products_Admin", urlPatterns = {"/products"})
public class Manage_Product extends HttpServlet {

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
        DAO dao = new DAO();
        ArrayList<ProductDBO> list = dao.getAllProducts();
        ArrayList<CategoryDBO> list1 = dao.getAllCategories();
          ArrayList<SupplierDBO> list2 = dao.getAllSuppliers();
        if (list.isEmpty()) {
            request.setAttribute("listProEmpty", "Không có sản phẩm nào.");
        }
        if (list1.isEmpty()) {
            request.setAttribute("listCateEmpty", "Không có loại sản phẩm nào.");
        }
        if (list2.isEmpty()) {
            request.setAttribute("listSupEmpty", "Không có nhà cung cấp nào.");
        }

        request.setAttribute("listPro", list);
        request.setAttribute("listCate", list1);
        request.setAttribute("listSup", list2);
        
request.setAttribute("active", "product");
        request.getRequestDispatcher("/admin/product.jsp").forward(request, response);
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
        processRequest(request, response);
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
