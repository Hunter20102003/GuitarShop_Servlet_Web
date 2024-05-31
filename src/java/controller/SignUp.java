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
import model.UserDBO;

/**
 *
 * @author LEGION
 */
@WebServlet(name = "SignUp", urlPatterns = {"/signup"})
public class SignUp extends HttpServlet {

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
            out.println("<title>Servlet SignUp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignUp at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
    }

    public boolean validUserName(String name) {

        if (name.matches(".*[^a-z0-9].*")) {
            return false;
        }
        return true;
    }

    public boolean validPassword(String password) {
        if (password.matches("^(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validMail(String email) {

        if (email.matches("[a-z0-9.]+@gmail\\.com$")) {
            return true;
        }
        return false;

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username").toLowerCase();
        String email = request.getParameter("email").toLowerCase();
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("re_pass");
        String agree_term = request.getParameter("agree-term");
        DAO dao = new DAO();
        if (username.isBlank() && email.isBlank() && pass.isBlank() && re_pass.isBlank() && agree_term == null) {
            request.setAttribute("warning", "Vui lòng nhập đầy đủ các thông tin");
        } else {
            if (username.isBlank() || email.isBlank() || pass.isBlank() || re_pass.isBlank()) {
                request.setAttribute("warning", "Vui lòng nhập đầy đủ các thông tin");
            } else if (agree_term == null) {
                request.setAttribute("warning", "Vui lòng ấn xác nhận các điều khoản");

            } else {
                boolean check = false;
                if (!validUserName(username)) {
                    check = true;
                    request.setAttribute("warningUserName", "Tên tài khoản không được chứa kí tự đặc biệt");
                } else if (dao.checkUser(username) != null) {
                    check = true;
                    request.setAttribute("warningUserName", "Tài khoản này đã tồn tại");
                }
                if (!validMail(email)) {
                    check = true;
                    request.setAttribute("warningEmail", "Gmail không hợp lệ");

                }else if (dao.checkEmailExist(email)!=null){
                    check = true;
                    request.setAttribute("warningEmail", "Gmail đã đăng kí tài khoản khác");
                }
                if (!validPassword(pass)) {
                    check = true;
                    request.setAttribute("warningPass", "Mật khẩu phải từ tám kí tự trở lên và bao gồm chữ số và kí tự đặc biệt");
                } else if (!pass.equals(re_pass)) {
                    check = true;
                    request.setAttribute("warningRePass", "Mật khẩu xác nhận không chính xác");

                }
                if (check == false) {
                    int n = dao.signup(username, pass, email);
                    if (n == 1) {
                        request.setAttribute("signupSuccess", "Đăng kí tài khoản thành công!");
                    } else {
                        request.setAttribute("signupError", "Đăng kí tài khoản thất bại");

                    }
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }

            }

        }
         
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("pass", pass);
        request.setAttribute("re_pass", re_pass);
        request.setAttribute("agree_term", 1);
        
        request.getRequestDispatcher("signup.jsp").forward(request, response);

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
