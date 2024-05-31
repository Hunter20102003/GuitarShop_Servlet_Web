/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author LEGION
 */
public class Add_To_Cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quantity = request.getParameter("quantity");
        String idProduct = request.getParameter("idProduct");
        //DAO dao = new DAO();

        String txt = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cart")) {

                    txt += c.getValue();

                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;

                }
            }
        }

        if (txt.isBlank()) {
            txt = idProduct + ":" + quantity;

        } else {
            String a = "@";

            txt = txt + a + idProduct + ":" + quantity;

        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60 * 60 * 24 * 2);
        response.addCookie(c);
        request.getRequestDispatcher("shop.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String quantity = request.getParameter("quantity");
        String idProduct = request.getParameter("idProduct");
        //DAO dao = new DAO();

        String txt = "";
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("cart")) {

                    txt += c.getValue();

                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;

                }
            }
        }

        if (txt.isBlank()) {
            txt = idProduct + ":" + quantity;

        } else {
            String a = "@";

            txt = txt + a + idProduct + ":" + quantity;

        }
        Cookie c = new Cookie("cart", txt);
        c.setMaxAge(60 * 60 * 24 * 2);
        response.addCookie(c);
        response.sendRedirect("detail?id=" + idProduct);
    }

}
