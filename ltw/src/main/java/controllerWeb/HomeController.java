package controllerWeb;

import DAO.CategoryDAO;
import model.Categories;
import model.Model;
import model.Product;
import DAO.HomeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeController", value = "/home")
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeDAO homeService = new HomeDAO();
        List<Product> listPromotions = homeService.getProductPromotion();
        List<Product> listTopSeller = homeService.getProductTopSeller();
        List<Product> listBestNew = homeService.getProductBestNew();

        CategoryDAO categoryDAO = new CategoryDAO();
        List<Categories> categories = categoryDAO.getAllCategory();
        List<Model> models = categoryDAO.getAllModel();

        request.setAttribute("categories", categories);
        request.setAttribute("models", models);
        request.setAttribute("isShow", true);

        request.setAttribute("isDiscount", listPromotions.size() > 0 ? true : false);
        request.setAttribute("listPromotions", listPromotions);
        request.setAttribute("isSeller", listTopSeller.size() > 0 ? true : false);
        request.setAttribute("listTopSeller", listTopSeller);
        request.setAttribute("isNew", listBestNew.size() > 0 ? true : false);
        request.setAttribute("listBestNew", listBestNew);
        String registerSuccess = (String) request.getAttribute("messageSuccess");
        request.setAttribute("messageSuccess", registerSuccess);
        request.getRequestDispatcher("/web/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
