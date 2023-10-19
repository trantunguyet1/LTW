package controllerAdmin.order;

import DAO.OrderDAO;
import model.Orders;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditOrderController", value = "/order/edit")
public class EditOrderController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();

        Long id = Long.parseLong(request.getParameter("id"));
        Orders orders = orderDAO.findOrderByID(id);
        request.setAttribute("order", orders);
        request.getRequestDispatcher("/admin/order/orderUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO orderDAO = new OrderDAO();

        Long id = Long.parseLong(request.getParameter("userID"));

        Boolean check = orderDAO.paymentOrder(id);
        request.setAttribute("message", "Thanh toán thành công");
        response.sendRedirect("/admin/order/order.jsp");
    }
}
