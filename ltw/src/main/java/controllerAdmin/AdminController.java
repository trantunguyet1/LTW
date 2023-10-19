package controllerAdmin;

import DAO.HomeDAO;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminController", value = "/admin")
public class AdminController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeDAO homeService = new HomeDAO();

        List<Product> listPromotions = homeService.getProductPromotion();
        List<Product> listTopSeller = homeService.getProductTopSeller();
        List<Product> listBestNew = homeService.getProductBestNew();

        request.setAttribute("listPromotions", listPromotions);
        request.setAttribute("listTopSeller", listTopSeller);
        request.setAttribute("listBestNew", listBestNew);
        String registerSuccess = (String) request.getAttribute("messageSuccess");
        request.setAttribute("messageSuccess", registerSuccess);
        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
