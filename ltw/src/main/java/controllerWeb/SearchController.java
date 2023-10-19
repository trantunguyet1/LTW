package controllerWeb;

import DAO.CategoryDAO;
import model.Categories;
import model.Model;
import model.Product;
import DAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchController", value = "/search")
public class SearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String textSearch = request.getParameter("textSearch");

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Categories> categories = categoryDAO.getAllCategory();
        List<Model> models = categoryDAO.getAllModel();

        request.setAttribute("categories", categories);
        request.setAttribute("models", models);
        request.setAttribute("isShow", true);

        ProductDAO productService = new ProductDAO();
        List<Product> products = productService.searchByNameProducts(textSearch);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/web/productView.jsp").forward(request, response);
    }
}
