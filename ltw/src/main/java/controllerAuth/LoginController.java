package controllerAuth;

import mode_utility.Encrypt;
import model.User;
import DAO.LoginDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isShow", false);
        request.getRequestDispatcher("login/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        LoginDAO loginService = new LoginDAO();
        User user = loginService.login(email, Encrypt.MD5(password));
        if (user == null) {
            request.setAttribute("isShow", false);
            request.setAttribute("massage", "Tài khoản hoặc mật khảu sai không tồn tại");
            request.getRequestDispatcher("/account/login.jsp").forward(request, response);
        } else {
            if (remember != null) {
                Cookie cookie = new Cookie("email", email);
                Cookie cookie1 = new Cookie("password", password);
                response.addCookie(cookie);
                response.addCookie(cookie1);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.setAttribute("massage", "Đăng nhập thành công");
            if (user.getRole() == true) {
                response.sendRedirect("admin");
            } else {
                response.sendRedirect("home");
            }
        }
    }
}
