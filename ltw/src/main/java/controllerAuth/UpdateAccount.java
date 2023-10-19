package controllerAuth;

import mode_utility.Encrypt;
import model.User;
import DAO.LoginDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAccount", value = "/update-account")
public class UpdateAccount extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String avatar = request.getParameter("avatar");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(Long.parseLong(id), name, address, phone, avatar, email, Encrypt.MD5(password), false);

        LoginDAO loginService = new LoginDAO();
        loginService.updateAccount(user);

        HttpSession session = request.getSession();
        User account = (User) session.getAttribute("account");
//      check xem có đang nhớ tài khoản
        if (account != null){
           session.setAttribute("account", user);
        }
        request.setAttribute("message", "Cập nhật tài khoản thành công");
        request.getRequestDispatcher("/customer/update-account.jsp").forward(request, response);
    }
}
