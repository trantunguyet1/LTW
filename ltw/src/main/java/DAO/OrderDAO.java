package DAO;

import mode_utility.DBConnect;
import model.Orders;
import model.OrdersDetail;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public List<Orders> findAllOrder() {
        String sql = "select * from Orders where Status = 1 order by OrderDate desc";
        List<Orders> orders = new ArrayList<>();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Orders item = new Orders();
                item.setId(rs.getLong("ID"));
                item.setTotalAmount(rs.getDouble("TotalAmount"));
                item.setUserID(rs.getLong("UserID"));
                item.setUserName(rs.getString("UserName"));
                item.setOrderDate(rs.getDate("OrderDate").toString());
                item.setStatus(rs.getInt("Status"));
                orders.add(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return orders;
    }

    public List<OrdersDetail> findOrdersDetailByUserID(Long userID) {
        String sql = "select * from Orders O left join OrdersDetail OD on O.ID = OD.OrderID where O.UserID = ? and O.Status = 1";
        List<OrdersDetail> ordersDetails = new ArrayList<>();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                OrdersDetail item = new OrdersDetail();
                item.setId(rs.getLong("ID"));
                item.setProductName(rs.getString("ProductName"));
                item.setQuantity(rs.getInt("Quantity"));
                item.setAmount(rs.getDouble("Amount"));
                ordersDetails.add(item);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return ordersDetails;
    }

    public Orders findOrderByID(Long id) {
        String sql = "select * from Orders where ID = ? and Status = 1";
        Orders item = new Orders();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                item.setId(rs.getLong("ID"));
                item.setTotalAmount(rs.getDouble("TotalAmount"));
                item.setUserID(rs.getLong("UserID"));
                item.setUserName(rs.getString("UserName"));
                item.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return item;
    }

    public Orders findOrderByUserID(Long userID) {
        String sql = "select * from Orders where UserID = ? and Status = 1";
        Orders item = new Orders();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, userID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                item.setId(rs.getLong("ID"));
                item.setTotalAmount(rs.getDouble("TotalAmount"));
                item.setUserID(rs.getLong("UserID"));
                item.setUserName(rs.getString("UserName"));
                item.setStatus(rs.getInt("Status"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return item;
    }


    public boolean paymentOrder(Long userId) {

        String sql = "update Orders set Status = 2 where UserID = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, userId);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }
}
