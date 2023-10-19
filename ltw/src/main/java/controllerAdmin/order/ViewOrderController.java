package controllerAdmin.order;

import DAO.OrderDAO;
import model.OrdersDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewOrderController", value = "/order/view")
public class ViewOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        List<OrdersDetail> orders = orderDAO.findOrdersDetailByUserID(id);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/admin/order/orderView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
