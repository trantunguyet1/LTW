package controllerAdmin.categories;

import DAO.CategoryDAO;
import model.Categories;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateModelController", value = "/model/create")
public class CreateModelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Categories> categories = categoryDAO.getAllCategory();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/admin/category/modelCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDAO categoryDAO = new CategoryDAO();

        String name = request.getParameter("name");
        Long categoryID = Long.parseLong(request.getParameter("categoryID"));

        Model model = new Model(name, categoryID);
        Model res = categoryDAO.createModel(model);
        request.setAttribute("message", "Thêm mới thành công");
        request.setAttribute("model", model);
        doGet(request, response);
    }
}
