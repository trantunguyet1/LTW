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

@WebServlet(name = "EditProductController", value = "/product/edit")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class EditProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        CategoryDAO categoryDAO = new CategoryDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        Product product = productDAO.findProductById(id);
        request.setAttribute("product", product);

        List<Model> models = categoryDAO.getAllModel();
        request.setAttribute("models", models);

        request.getRequestDispatcher("/admin/product/productUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ProductDAO productDAO = new ProductDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String discount = request.getParameter("discount");
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String modelID = request.getParameter("modelID");

        Part filePart = request.getPart("file");
        String fileName = "";
        if (filePart != null) {
            fileName = filePart.getSubmittedFileName();
            for (Part part : request.getParts()) {
                part.write("C:\\Users\\DELL\\Documents\\TMDT\\src\\main\\webapp\\img\\product\\" + fileName);
            }
        } else {
            Product product = productDAO.findProductById(id);
            fileName = product.getImage();
        }

        Product product = new Product(id, name, fileName, Double.parseDouble(price), Double.parseDouble(discount), Boolean.parseBoolean(status), description, Long.parseLong(modelID));
        Boolean res = productDAO.updateProduct(product);
        request.setAttribute("message", "Cập nhật thành công");
        request.setAttribute("product", product);
        request.getRequestDispatcher("/admin/product/productUpdate.jsp").forward(request, response);
    }
}
