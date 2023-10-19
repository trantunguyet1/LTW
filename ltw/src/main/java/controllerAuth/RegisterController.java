package controllerAuth;

import mode_utility.Encrypt;
import model.User;
import DAO.LoginDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isShow", false);
        request.getRequestDispatcher("login/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

//        check email có đăng ký hay chưa?
        LoginDAO loginService = new LoginDAO();
        if (loginService.checkEmailExits(email)) {
            request.setAttribute("message", "Email đã được đăng ký");
            request.getRequestDispatcher("login/register.jsp").forward(request, response);
        } else {
            User user = new User(email, Encrypt.MD5(password), name, phone);
            loginService.createUser(user);
            request.setAttribute("isShow", false);
            request.setAttribute("message", "Đăng ký tài khoản thành công! Vui lòng đăng nhập lại");
            response.sendRedirect("login");
        }
    }
}
