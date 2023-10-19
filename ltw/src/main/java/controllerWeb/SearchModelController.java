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

@WebServlet(name = "SearchModelController", value = "/search-model")
public class SearchModelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("id");

        CategoryDAO categoryDAO = new CategoryDAO();
        Model model = categoryDAO.getItemModel(Long.parseLong(id));
        Categories category = categoryDAO.getItemCategory(model.getCategoryID());
        List<Model> model1 = categoryDAO.getAllModelByCategoryID(model.getCategoryID());

        List<Categories> categories = categoryDAO.getAllCategory();
        List<Model> models = categoryDAO.getAllModel();

        request.setAttribute("categories", categories);
        request.setAttribute("models", models);

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.findAllProductByModelID(model.getId());

        request.setAttribute("isShow", true);
        request.setAttribute("category", category);
        request.setAttribute("model", model1);
        request.setAttribute("products", products);
        request.getRequestDispatcher("/web/productView.jsp").forward(request, response);
    }
}
