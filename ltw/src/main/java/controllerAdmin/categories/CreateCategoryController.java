package controllerAdmin.categories;

import DAO.CategoryDAO;
import model.Categories;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateCategoryController", value = "/categories/create")
public class CreateCategoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/category/categoriesCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDAO categoryDAO = new CategoryDAO();

        String name = request.getParameter("categoryName");

        Categories categories = new Categories(name);
        Categories res = categoryDAO.createCategory(categories);
        request.setAttribute("message", "Thêm mới thành công");
        request.setAttribute("model", categories);
        request.getRequestDispatcher("/admin/category/categoriesCreate.jsp").forward(request, response);
    }
}
