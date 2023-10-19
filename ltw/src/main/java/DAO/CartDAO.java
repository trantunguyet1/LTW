package DAO;

import mode_utility.DBConnect;
import model.Cart;
import model.Orders;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {

    public Cart findProductIDByUserIDAndProductID(Long userId, Long productID) {
        Cart cart = new Cart();

        String sql = "select * from Cart where UserID = ? and ProductID = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, productID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                cart.setId(rs.getLong("ID"));
                cart.setQuantity(rs.getInt("Quantity"));
                cart.setUserID(rs.getLong("UserID"));
                cart.setUserName(rs.getString("UserName"));
                cart.setProductID(rs.getLong("ProductID"));
                cart.setProductName(rs.getString("ProductName"));
                cart.setAmount(rs.getDouble("Amount"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return cart;
    }

    public List<Cart> findProductIDByUserID(Long userId) {
        List<Cart> cart = new ArrayList<>();

        String sql = "select Distinct * from Cart C left join Product P on C.ProductID = P.ID where UserID = ?";
        try {
            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Cart cart1 = new Cart();
                cart1.setId(rs.getLong("ID"));
                cart1.setQuantity(rs.getInt("Quantity"));
                cart1.setUserID(rs.getLong("UserID"));
                cart1.setUserName(rs.getString("UserName"));
                cart1.setProductID(rs.getLong("ProductID"));
                cart1.setProductName(rs.getString("ProductName"));
                cart1.setImage(rs.getString("Image"));
                Double discount = rs.getDouble("Discount");
                cart1.setAmount(discount != null ? discount : rs.getDouble("Price"));
                cart.add(cart1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return cart;
    }

    public boolean deleteAllProductFromCart(Long userId) {
        String sql = "delete from Cart where UserID = ?";
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

    public boolean deleteProductFromCart(Long id) {
        String sql = "delete from Cart where ProductID = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean addProductToCart(Long userId, Long productId, String userName, String productName, Double amount) {
        Cart cart = findProductIDByUserIDAndProductID(userId, productId);
        //  Tìm giỏ hàng, nếu null thì thêm mới, có rồi thì update
        String sql = "";
        if (cart.getId() != null) {
            sql = "update Cart set Quantity = ?, Amount = ? where UserID = ? and ProductID = ?";
        } else {
            sql = "insert into Cart (Quantity, Amount, UserID, ProductID, UserName, ProductName) values (?, ?, ?, ?, ?, ?)";
        }
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setInt(1, (cart.getQuantity() == null ? 0 : cart.getQuantity()) + 1);
            statement.setDouble(2, (cart.getAmount() == null ? 0 : cart.getAmount()) + amount);
            statement.setLong(3, userId);
            statement.setLong(4, productId);
            if (cart.getId() == null) {
                statement.setString(5, userName);
                statement.setString(6, productName);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean subProductFromCart(Long userId, Long productId, String userName, String productName, Double amount) {
        Cart cart = findProductIDByUserIDAndProductID(userId, productId);
        //  Tìm giỏ hàng, nếu null thì thêm mới, có rồi thì update
        String sql = "";
        if (cart.getId() != null) {
            sql = "update Cart set Quantity = ?, Amount = ? where UserID = ? and ProductID = ?";
        } else {
            sql = "insert into Cart (Quantity, Amount, UserID, ProductID, UserName, ProductName) values (?, ?, ?, ?, ?, ?)";
        }
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setInt(1, (cart.getQuantity() == null ? 0 : cart.getQuantity()) - 1);
            statement.setDouble(2, (cart.getAmount() == null ? 0 : cart.getAmount()) - amount);
            statement.setLong(3, userId);
            statement.setLong(4, productId);
            if (cart.getId() == null) {
                statement.setString(5, userName);
                statement.setString(6, productName);
            }
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }


    public boolean paymentCart(Long userId) {
        try {
            CartDAO cartDAO = new CartDAO();
            List<Cart> carts = cartDAO.findProductIDByUserID(userId);
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = new ArrayList<>();
            Double total = 0d;
            for (int i = 0; i < carts.size(); i++) {
                Product product = productDAO.findProductById(carts.get(i).getProductID());
                total = +(product.getDiscount() != null ? product.getDiscount() : product.getPrice());
                products.add(product);
            }
            // insert order
            String sqlOrder = "insert into Orders (TotalAmount, UserID, UserName, Status) VALUES (?,?,?,?)";
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sqlOrder);
            statement.setDouble(1, total);
            statement.setLong(2, carts.get(0).getUserID());
            statement.setString(3, carts.get(0).getUserName());
            statement.setInt(4, 1);
            statement.executeUpdate();

            OrderDAO orderDAO = new OrderDAO();
            Orders orders = orderDAO.findOrderByUserID(userId);

            for (int i = 0; i < carts.size(); i++) {
                // insert orderDetail
                String sqlOrderDetail = "insert into OrdersDetail(productname, quantity, amount, orderid) values (?,?,?,?)";
                PreparedStatement statement2 = DBConnect.connect().getConnection().prepareStatement(sqlOrderDetail);
                statement2.setString(1, carts.get(i).getProductName());
                statement2.setInt(2, carts.get(i).getQuantity());
                statement2.setDouble(3, carts.get(i).getAmount());
                statement2.setLong(4, orders.getId());
                statement2.executeUpdate();
            }

            // delete cart
            String sql = "delete from Cart where UserID = ?";

            PreparedStatement statement1 = DBConnect.connect().getConnection().prepareStatement(sql);
            statement1.setLong(1, userId);
            statement1.executeUpdate();

            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }
}
