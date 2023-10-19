package DAO;

import mode_utility.DBConnect;
import model.Categories;
import model.Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<Model> getAllModel() {
        List<Model> res = new ArrayList<>();
        try {
            String sql = "select * from Model";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getLong("ID"));
                model.setName(rs.getString("Name"));
                model.setCategoryID(rs.getLong("CategoryID"));
                model.setCategoryName(rs.getString("CategoryName"));
                res.add(model);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return res;
    }

    public Model getItemModel(Long id) {
        Model model = new Model();
        try {
            String sql = "select * from Model where ID = ?";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                model.setId(rs.getLong("ID"));
                model.setName(rs.getString("Name"));
                model.setCategoryID(rs.getLong("CategoryID"));
                model.setCategoryName(rs.getString("CategoryName"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return model;
    }

    public Categories getItemCategory(Long id) {
        Categories categories = new Categories();
        try {
            String sql = "select * from Categories where ID = ?";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                categories.setId(rs.getLong("ID"));
                categories.setCategoryName(rs.getString("CategoryName"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return categories;
    }

    public List<Categories> getAllCategory() {
        List<Categories> categories = new ArrayList<>();
        try {
            String sql = "select * from Categories";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Categories categories1 = new Categories();
                categories1.setId(rs.getLong("ID"));
                categories1.setCategoryName(rs.getString("CategoryName"));
                categories.add(categories1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return categories;
    }

    public Categories createCategory(Categories categories) {
        try {
            String sql = "insert into Categories (categoryname) values (?)";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, categories.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return categories;
    }

    public Model createModel(Model model) {
        Categories categories = getItemCategory(model.getCategoryID());
        try {
            String sql = "insert into Model (Name, categoryid, categoryname) values (?,?,?)";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setLong(2, model.getCategoryID());
            preparedStatement.setString(3, categories.getCategoryName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return model;
    }

    public Model updateModel(Model model) {
        try {
            String sql = "update Model set Name = ?, categoryid = ?, categoryname = ? where id = ?";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setString(1, model.getName());
            preparedStatement.setLong(2, model.getCategoryID());
            preparedStatement.setString(3, model.getCategoryName());
            preparedStatement.setLong(4, model.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return model;
    }

    public Boolean deleteModel(Long id) {
        try {
            String sql = "delete from Model where ID = ?";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

//    public Categories findCategoryByName(String textSearch) {
//        Categories categories = new Categories();
//        try {
//            String sql = "select * from Categories where categoryName = ?";
//
//            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
//            preparedStatement.setString(1, textSearch);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                categories.setId(rs.getLong("ID"));
//                categories.setCategoryName(rs.getString("CategoryName"));
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.getMessage();
//        }
//        return categories;
//    }

//    public Model getModelByName(String categoryName) {
//        Model model = new Model();
//        try {
//            String sql = "select * from Model where name = ?";
//
//            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
//            preparedStatement.setString(1, categoryName);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//
//                model.setId(rs.getLong("ID"));
//                model.setName(rs.getString("Name"));
//                model.setCategoryID(rs.getLong("CategoryID"));
//                model.setCategoryName(rs.getString("CategoryName"));
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            e.getMessage();
//        }
//        return model;
//    }

    public List<Model> getAllModelByCategoryID(Long id) {
        List<Model> res = new ArrayList<>();
        try {
            String sql = "select * from Model where categoryID = ?";

            PreparedStatement preparedStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Model model = new Model();
                model.setId(rs.getLong("ID"));
                model.setName(rs.getString("Name"));
                model.setCategoryID(rs.getLong("CategoryID"));
                model.setCategoryName(rs.getString("CategoryName"));
                res.add(model);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return res;
    }
}
