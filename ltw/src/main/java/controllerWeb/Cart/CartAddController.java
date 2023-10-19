package controllerWeb.Cart;

import DAO.CartDAO;
import DAO.ProductDAO;
import model.Cart;
import model.Product;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartAddController", value = "/cart-add")
public class CartAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        User user = (User) httpSession.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login");
        } else {

            String id = request.getParameter("id");

            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.findProductById(Long.parseLong(id));

            CartDAO cartDAO = new CartDAO();
            Boolean add = cartDAO.addProductToCart(user.getId(), product.getId(), user.getUserName(), product.getName(), product.getDiscount() != null ? product.getDiscount() : product.getPrice());


            request.setAttribute("isShow", true);
            String registerSuccess = (String) request.getAttribute("messageSuccess");
            request.setAttribute("messageSuccess", registerSuccess);
            request.getRequestDispatcher("/home").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
