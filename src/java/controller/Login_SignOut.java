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
import jakarta.servlet.http.HttpSession;
import model.UserDBO;

/**
 *
 * @author LEGION
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login_SignOut extends HttpServlet {

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
            out.println("<title>Servlet Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
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
        String signout = request.getParameter("signout");
        HttpSession session = request.getSession();
        if (signout != null) {
            session.invalidate();
            response.sendRedirect("index.jsp");
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

        String username = request.getParameter("username");
        username = username.toLowerCase();
        String password = request.getParameter("password");
        String rem = request.getParameter("rem");

        DAO dao = new DAO();
        UserDBO user = dao.checkLogin(username, password);

        if (user == null) {
            request.setAttribute("error", "Tài khoản người dùng không tồn tại hoặc mật khẩu không đúng");
            request.setAttribute("username", username);
            for (Cookie a : request.getCookies()) {
                if (a.getName().equals("user") || a.getName().equals("pass") || a.getName().equals("rem")) {
                    a.setMaxAge(0);
                    response.addCookie(a);
                }
            }

            request.getRequestDispatcher("login.jsp").forward(request, response);

        } else {
            if (user.getStatus() == 0) {
                  request.setAttribute("error", "Tài khoản người dùng đã bị khóa");
                     request.getRequestDispatcher("login.jsp").forward(request, response); return;

            } else {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user);
                if (user.getIsAdmin() == 1) {
                    session.setAttribute("admin", user);
                }
                Cookie name = new Cookie("user", username);
                Cookie pass = new Cookie("pass", password);
                Cookie remember = new Cookie("rem", "selected");
                if (rem == null) {
                    name.setMaxAge(0);
                    pass.setMaxAge(0);
                    remember.setMaxAge(0);

                } else {
                    int n = 24 * 60 * 60;
                    name.setMaxAge(n);
                    pass.setMaxAge(n);
                    remember.setMaxAge(n);
                }
                response.addCookie(name);
                response.addCookie(pass);
                response.addCookie(remember);
            }

            response.sendRedirect("index.jsp");

        }
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
