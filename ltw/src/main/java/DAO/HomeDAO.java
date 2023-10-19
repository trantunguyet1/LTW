package DAO;

import mode_utility.DBConnect;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeDAO {

    public List<Product> getProductPromotion() {
        List<Product> res = new ArrayList<>();
        try {
            String sql = "select * from product where Status = 1 and Discount > 0 order by CreateDate DESC limit 8";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("Name"));
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setDiscount(rs.getDouble("Discount"));
                product.setStatus(rs.getBoolean("Status"));
                product.setDescription(rs.getString("Description"));
                product.setItemCategoryID(rs.getLong("ItemCategoryID"));
                product.setSaQuantity(rs.getInt("SAQuantity"));
                res.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return res;
    }

    public List<Product> getProductTopSeller() {
        List<Product> res = new ArrayList<>();
        try {
            String sql = "select * from product where Status = 1  order by SAQuantity DESC limit 8";
            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("Name"));
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setDiscount(rs.getDouble("Discount"));
                product.setStatus(rs.getBoolean("Status"));
                product.setDescription(rs.getString("Description"));
                product.setItemCategoryID(rs.getLong("ItemCategoryID"));
                product.setSaQuantity(rs.getInt("SAQuantity"));
                res.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return res;
    }

    public List<Product> getProductBestNew() {
        List<Product> res = new ArrayList<>();
        try {
            String sql = "select * from product where Status = 1  order by CreateDate DESC limit 8";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("Name"));
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setDiscount(rs.getDouble("Discount"));
                product.setStatus(rs.getBoolean("Status"));
                product.setDescription(rs.getString("Description"));
                product.setItemCategoryID(rs.getLong("ItemCategoryID"));
                product.setSaQuantity(rs.getInt("SAQuantity"));
                res.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return res;
    }
}
