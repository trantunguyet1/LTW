package controllerWeb;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Categories;
import model.Model;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SingleController", value = "/detail")
public class SingleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Categories> categories = categoryDAO.getAllCategory();
        List<Model> models = categoryDAO.getAllModel();

        request.setAttribute("categories", categories);
        request.setAttribute("models", models);
        request.setAttribute("isShow", true);

        ProductDAO productService = new ProductDAO();
        Product product = productService.findProductById(Long.parseLong(id));
        request.setAttribute("product", product);
        request.getRequestDispatcher("/web/productSingle.jsp").forward(request, response);
    }
}
