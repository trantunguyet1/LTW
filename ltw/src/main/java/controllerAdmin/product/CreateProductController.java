package controllerAdmin.product;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Model;
import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateProductController", value = "/product/create")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class CreateProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();

        List<Model> models = categoryDAO.getAllModel();
        request.setAttribute("models", models);
        request.getRequestDispatcher("/admin/product/productCreate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String modelID = request.getParameter("modelID");

        String fileName = "";
        try {
            Part filePart = request.getPart("file");
            fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                part.write("C:\\Users\\DELL\\Documents\\TMDT\\src\\main\\webapp\\img\\product\\" + fileName);
            }
        } catch (Exception e) {
            e.getMessage();
        }

        Product product = new Product(name, fileName, Double.parseDouble(price), Double.parseDouble(discount), status.equals("1") ? true : false, description, Long.parseLong(modelID));
        Boolean res = productDAO.createProduct(product);
        request.setAttribute("message", "Thêm mới thành công");
        request.setAttribute("product", product);
        doGet(request, response);
    }
}
