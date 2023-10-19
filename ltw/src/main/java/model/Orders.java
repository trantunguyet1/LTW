package model;

import java.io.Serializable;

public class Orders implements Serializable {
    private Long id;
    private Double totalAmount;
    private String orderDate;
    private Long userID;
    private String userName;
    private Integer status;

    public Orders() {
    }

    public Orders(Long id, Double totalAmount, String orderDate, Long userID, String userName, Integer status) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.orderDate = orderDate;
        this.userID = userID;
        this.userName = userName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
