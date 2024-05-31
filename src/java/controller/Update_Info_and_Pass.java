/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.util.UUID;
import model.UserDBO;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 12
)
/**
 *
 * @author LEGION
 */
public class Update_Info_and_Pass extends HttpServlet {

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
            out.println("<title>Servlet Update_Info</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Update_Info att " + request.getContextPath() + "</h1>");
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

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public String validateName(String name) {
        name = name.toLowerCase();
        String s[] = name.split("\\s+");
        StringBuilder st = new StringBuilder();
        for (String a : s) {
            st.append(Character.toUpperCase(a.charAt(0))).append(a.substring(1)).append(" ");

        }

        return st.toString().trim();
    }

    public boolean validUserName(String name) {
        if (!name.matches("[a-zA-ZÀ-Ỹà-ỹ\\s]+")) {
            return false; // Tên chứa ký tự không phải là chữ cái tiếng Anh hoặc tiếng Việt có dấu hoặc dấu cách
        }
        return true; // Tên hợp lệ
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

    public boolean validPhone(String phone) {

        return phone.matches("\\d{10}");

    }
    private static final String UPLOAD_DIRECTORY = "E:\\PRJ301\\GuitarShop\\web\\img_user";

    private void updateUserInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        if (session != null) {

            UserDBO user = (UserDBO) session.getAttribute("user");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String date = request.getParameter("dob");
            String phone = request.getParameter("phone");
            boolean check = false;
            if (!name.isBlank()) {
                if (validUserName(name) == false) {
                    request.setAttribute("invalidName", "Tên người dùng không hợp lệ");
                    check = true;

                } else {
                    name = validateName(name);

                }
            }
            if (!email.isBlank()) {
                if (validMail(email) == false) {
                    request.setAttribute("invalidEmail", "Email không hợp lệ");
                    check = true;
                } else if (email.equalsIgnoreCase(user.getEmail()) == false) {
                    if (dao.checkEmailExist(email) != null) {
                        request.setAttribute("invalidEmail", "Email đã tồn tại");
                        check = true;
                    }
                }
            } else {
                request.setAttribute("invalidEmail", "Email không được trống");
                check = true;
            }
            if (!phone.isBlank()) {
                if (!validPhone(phone)) {
                    request.setAttribute("invalidPhone", "Số điện thoại không hợp lệ");
                    check = true;
                }
            }
            if (!check) {
                int n = dao.updateInfoUser(user.getId(), name, email, date, phone);
                if (n > 0) {
                    request.setAttribute("updateInfoSuccess", "Cập nhật thông tin thành công");
                }

            }

            request.setAttribute("img", user.getAvatar());
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("dob", date);
            request.getRequestDispatcher("account.jsp").forward(request, response);

        }
    }

    private void updatePassword(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        boolean check = false;
        if (session != null) {

            UserDBO user = (UserDBO) session.getAttribute("user");
            String oldPass = request.getParameter("oldPass");
            String newPass = request.getParameter("newPass");
            String reNewPass = request.getParameter("reNewPass");
            if (oldPass.isBlank() || newPass.isBlank() || reNewPass.isBlank()) {
                request.setAttribute("error", "Vui lòng nhập đầy đủ mật khẩu");
            } else {
                if (!oldPass.equals(user.getPassword())) {
                    request.setAttribute("wrongPass", "Mật khẩu cũ không chính xác");
                    check = true;
                } else {
                    if (!validPassword(newPass)) {
                        request.setAttribute("invalidPass", "Mật khẩu phải từ tám kí tự trở lên và bao gồm chữ số và kí tự đặc biệt");
                        check = true;

                    } else {
                        if (newPass.equals(oldPass)) {
                            request.setAttribute("invalidNewPass", "Mật khẩu mới không được trùng với mật khẩu cũ");
                            check = true;

                        } else {
                            if (!newPass.equals(reNewPass)) {
                                request.setAttribute("invalidReNewPass", "Mật khẩu xác nhận không trùng nhau");
                                check = true;

                            }
                        }
                    }
                }
                if (!check) {
                    int n = dao.updatePasswordUser(user.getId(), newPass);
                    if (n > 0) {
                        request.setAttribute("updatePassSuccess", "Thay đổi mật khẩu thành công");
                    }

                }
            }
            request.getRequestDispatcher("update_password.jsp").forward(request, response);

        }
    }

    private void updateImage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        if (session != null) {

            UserDBO user = (UserDBO) session.getAttribute("user");
            Part part = request.getPart("fileInput");
            String fileName = getFileName(part);
            String uniqueFileName = UUID.randomUUID().toString() + "-" + fileName;
            int a = dao.updateImgUser(user.getId(), "img_user" + File.separator + uniqueFileName);
            if (a > 0) {
                String uploadFilePath = UPLOAD_DIRECTORY + File.separator + uniqueFileName;

                part.write(uploadFilePath);
//                request.setAttribute("img","img_user" + File.separator + uniqueFileName );
//            request.getRequestDispatcher("account.jsp").forward(request, response);

                response.sendRedirect("info");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        String update = request.getParameter("update");
        if (update.equals("info")) {
            updateUserInfo(request, response);

        } else if (update.equals("password")) {
            updatePassword(request, response);

        } else {
            updateImage(request, response);
        }

    }

    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : partHeader.split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
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
