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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.Item;
import model.ProductDBO;

/**
 *
 * @author LEGION
 */
@WebServlet(name = "Cart_Process", urlPatterns = {"/cartProcess"})
public class Cart_Process extends HttpServlet {

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
            out.println("<title>Servlet Cart_Process</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Cart_Process at " + request.getContextPath() + "</h1>");
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
    private void removeProductFromCart(HttpServletRequest request, HttpServletResponse response, String txt) throws ServletException, IOException {
        if (!txt.isBlank()) {
            String idProduct = request.getParameter("id");

            Cart cart = new Cart(txt);
            DAO dao = new DAO();
            ProductDBO p = dao.getProductById(Integer.parseInt(idProduct));
            cart.removeItem(p.getId());
            txt = "";
            for (int i = 0; i < cart.getItems().size(); i++) {
                txt += cart.getItems().get(i).getProduct().getId() + ":" + cart.getItems().get(i).getQuantity() + "@";

            }
            txt = txt.substring(0, txt.length());
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(60 * 60 * 24 * 2);
            response.addCookie(c);
            Cart ca = new Cart(txt);
            request.setAttribute("cart", ca);

        }
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);

    }

    private void add_removeQuantityFromCart(HttpServletRequest request, HttpServletResponse response, String txt) throws ServletException, IOException {
        if (!txt.isBlank()) {
            String quantity = request.getParameter("quantity");
            String idProduct = request.getParameter("id");
            String number = request.getParameter("number");

            Cart cart = new Cart(txt);
            if (number.equals("-1")) {
                if (Integer.parseInt(quantity) <= 1) {
                    cart.removeItem(Integer.parseInt(idProduct));

                } else {
                    Item i = cart.getItemById(Integer.parseInt(idProduct));
                    i.setQuantity(i.getQuantity() - 1);
                    i.setPrice(i.getPrice() - i.getProduct().getPrice());
                }
            } else {
                Item i = cart.getItemById(Integer.parseInt(idProduct));
                if (Integer.parseInt(quantity) < i.getProduct().getQuantity()) {
                    i.setQuantity(i.getQuantity() + 1);
                    i.setPrice(i.getPrice() + i.getProduct().getPrice());
                }
            }
            txt = "";
            for (int i = 0; i < cart.getItems().size(); i++) {
                txt += cart.getItems().get(i).getProduct().getId() + ":" + cart.getItems().get(i).getQuantity() + "@";

            }
            txt = txt.substring(0, txt.length());
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(60 * 60 * 24 * 2);
            response.addCookie(c);
            Cart ca = new Cart(txt);
            request.setAttribute("cart", ca);
        }
        request.getRequestDispatcher("shopping-cart.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookie = request.getCookies();
        DAO dao = new DAO();
        String txt = "";
        if (cookie != null) {
            for (Cookie c : cookie) {
                if (c.getName().equals("cart")) {
                    txt = c.getValue();
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
            }
            String type = request.getParameter("type");
            if (!type.isBlank()) {
                if (type.equals("0")) {
                    add_removeQuantityFromCart(request, response, txt);
                } else {
                    removeProductFromCart(request, response, txt);
                }

            }
        }

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
