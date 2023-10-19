package controllerAdmin.categories;

import DAO.CategoryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCategoryController", value = "/categories/delete")
public class DeleteModelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        Boolean delete = categoryDAO.deleteModel(id);
        request.setAttribute("message", delete ? "Xóa thành công" : "Xóa thất bại");
        response.sendRedirect("/category");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
