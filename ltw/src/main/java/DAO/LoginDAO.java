package DAO;

import mode_utility.DBConnect;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDAO {
    public List<User> findAllUser() {
        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM User WHERE Role = 0";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setUserName(rs.getString("UserName"));
                user.setAddress(rs.getString("Address"));
                user.setPhone(rs.getString("Phone"));
                user.setAvatar(rs.getString("Avatar"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getBoolean("Role"));
                users.add(user);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return users;
    }

    public User login(String email, String password) {
        String sql = "SELECT * FROM User WHERE Email = ? AND Password = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setUserName(rs.getString("UserName"));
                user.setAddress(rs.getString("Address"));
                user.setPhone(rs.getString("Phone"));
                user.setAvatar(rs.getString("Avatar"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getBoolean("Role"));
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    public User checkLostPassword(String email, String phone) {
        String sql = "select * from User where Email = ? and Phone = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, phone);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setUserName(rs.getString("UserName"));
                user.setAddress(rs.getString("Address"));
                user.setPhone(rs.getString("Phone"));
                user.setAvatar(rs.getString("Avatar"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setRole(rs.getBoolean("Role"));
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return null;
    }

    public Boolean checkEmailExits(String email) {
        String sql = "select * from User where Email = ?";
        try {
            PreparedStatement statement = DBConnect.connect().getConnection().prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
        return false;
    }

    public void createUser(User user) {
        String sql = "insert into User(UserName, Address, Phone, Avatar, Email, Password, Role) values (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement prepareStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getAddress());
            prepareStatement.setString(3, user.getPhone());
            prepareStatement.setString(4, user.getAvatar());
            prepareStatement.setString(5, user.getEmail());
            prepareStatement.setString(6, user.getPassword());
            prepareStatement.setBoolean(7, false);
            prepareStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }

    }

    public void updateAccount(User user) {
        String sql = "update User set UserName = ?, Address = ?, Phone = ?, Avatar = ?, Email = ?, Password = ?, Role = ? where ID = ?";
        try {
            PreparedStatement prepareStatement = DBConnect.connect().getConnection().prepareStatement(sql);
            prepareStatement.setString(1, user.getUserName());
            prepareStatement.setString(2, user.getAddress());
            prepareStatement.setString(3, user.getPhone());
            prepareStatement.setString(4, user.getAvatar());
            prepareStatement.setString(5, user.getEmail());
            prepareStatement.setString(6, user.getPassword());
            prepareStatement.setBoolean(7, user.getRole());
            prepareStatement.setLong(8, user.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
}
