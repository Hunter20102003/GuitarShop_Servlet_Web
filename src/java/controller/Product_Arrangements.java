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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import model.ProductDBO;

/**
 *
 * @author LEGION
 */
public class Product_Arrangements extends HttpServlet {

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
            out.println("<title>Servlet Product_Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Product_Order at " + request.getContextPath() + "</h1>");
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
    private void orderNewProduct(ArrayList<ProductDBO> list) {
        Collections.sort(list, new Comparator<ProductDBO>() {
            @Override
            public int compare(ProductDBO o1, ProductDBO o2) {
                return Integer.compare(o2.getId(), o1.getId());
            }

        });

    }

    private void orderDecreaseProduct(ArrayList<ProductDBO> list) {
        Collections.sort(list, new Comparator<ProductDBO>() {
            @Override
            public int compare(ProductDBO o1, ProductDBO o2) {
                return Double.compare(o2.getPrice()-(o2.getPrice()*o2.getDiscount()), o1.getPrice()-(o1.getPrice()*o1.getDiscount()));
            }

        });

    }

    private void orderAccreaseProduct(ArrayList<ProductDBO> list) {
        Collections.sort(list, new Comparator<ProductDBO>() {
            @Override
            public int compare(ProductDBO o1, ProductDBO o2) {
                return Double.compare( o1.getPrice()-(o1.getPrice()*o1.getDiscount()), o2.getPrice()-(o2.getPrice()*o2.getDiscount()));
            }

        });

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String s = request.getParameter("option");
        HttpSession session = request.getSession();
        ArrayList<ProductDBO> list = (ArrayList<ProductDBO>) session.getAttribute("listPageProduct");
        if (list != null) {
            if (s.equals("1")) {
                orderNewProduct(list);
            } else if (s.equals("2")) {
                orderDecreaseProduct(list);
            } else {
                orderAccreaseProduct(list);
            }
        }
        DAO dao=new DAO();
        request.setAttribute("listProduct", dao.pageProduct(list, 1));
        session.setAttribute("listPageProduct", list);

        session.setAttribute("option", s);
        
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
