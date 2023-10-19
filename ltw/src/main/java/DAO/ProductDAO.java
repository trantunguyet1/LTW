package DAO;

import mode_utility.DBConnect;
import model.Model;
import model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public Product findProductById(Long id) {
        String sql = "select * from Product where ID = ? and Status = 1";
        Product product = new Product();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("Name"));
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setDiscount(rs.getDouble("Discount"));
                product.setStatus(rs.getBoolean("Status"));
                product.setDescription(rs.getString("Description"));
                product.setItemCategoryID(rs.getLong("ItemCategoryID"));
                product.setSaQuantity(rs.getInt("SAQuantity"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return product;
    }

    public List<Product> findAllProduct() {
        String sql = "select * from Product where Status = 1";
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
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
                products.add(product);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return products;
    }

    public List<Product> searchByNameProducts(String textSearch) {
        String sql = "select * from Product where Name like ?";
        List<Product> res = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "%" + textSearch + "%");
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
            e.printStackTrace();
        }
        return res;
    }

    public boolean createProduct(Product product) {
        String sql = "insert into Product(Name, Image, Price, Discount, Status, Description, ItemCategoryID) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getImage());
            statement.setDouble(3, product.getPrice());
            statement.setDouble(4, product.getDiscount());
            statement.setBoolean(5, product.getStatus());
            statement.setString(6, product.getDescription());
            statement.setLong(7, product.getItemCategoryID());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        String sql = "update Product set Name = ?, Image = ?, Price = ?, Discount = ?, Status = ?, Description = ?, ItemCategoryID = ? where ID = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getImage());
            statement.setDouble(3, product.getPrice());
            statement.setDouble(4, product.getDiscount());
            statement.setBoolean(5, product.getStatus());
            statement.setString(6, product.getDescription());
            statement.setLong(7, product.getItemCategoryID());
            statement.setLong(8, product.getId());
            statement.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
    }

    public boolean deleteProduct(Long id) {
        String sql = "delete from Product where ID = ?";
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

    public List<Product> findAllProductByModelID(Long id) {

        List<Product> res = new ArrayList<>();
        try {
            String sql = "select * from Product where itemCategoryID = ?";
            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
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
            e.printStackTrace();
        }
        return res;
    }
}
