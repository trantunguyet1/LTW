package controllerAuth;

import DAO.LoginDAO;
import mode_utility.Encrypt;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPassController", value = "/forgot-pass")
public class ForgotPassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isShow", false);
        request.getRequestDispatcher("login/lost-password.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

//        check email có đăng ký hay chưa?
        LoginDAO loginService = new LoginDAO();
        User user = loginService.checkLostPassword(email, phone);
        if (user != null) {
            user.setPassword(Encrypt.MD5(password));
            loginService.updateAccount(user);
            request.setAttribute("message", "Đăng ký tài khoản thành công! Vui lòng đăng nhập lại");
            response.sendRedirect("login");

        } else {
            request.setAttribute("message", "Email/Số điện thoại không đúng");
            request.setAttribute("isShow", false);
            request.getRequestDispatcher("login/lost-password.jsp").forward(request, response);
        }
    }
}
