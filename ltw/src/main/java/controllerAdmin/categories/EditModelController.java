package controllerAdmin.categories;

import DAO.CategoryDAO;
import model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditModelController", value = "/model/edit")
public class EditModelController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        Model model = categoryDAO.getItemModel(id);
        request.setAttribute("model", model);
        request.getRequestDispatcher("/admin/category/modelUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CategoryDAO categoryDAO = new CategoryDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Long categoryID = Long.parseLong(request.getParameter("categoryID"));
        String categoryName = request.getParameter("categoryName");

        Model model = new Model(id, name, categoryID, categoryName);
        Model res = categoryDAO.updateModel(model);
        request.setAttribute("message", "Cập nhật thành công");
        request.setAttribute("model", model);
        request.getRequestDispatcher("/admin/category/modelUpdate.jsp").forward(request, response);
    }
}
