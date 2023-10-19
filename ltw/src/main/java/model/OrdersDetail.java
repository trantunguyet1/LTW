package model;

import java.io.Serializable;

public class OrdersDetail implements Serializable {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double amount;
    private Long orderID;
    ;

    public OrdersDetail() {
    }

    public OrdersDetail(Long id, String productName, Integer quantity, Double amount, Long orderID) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.amount = amount;
        this.orderID = orderID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
}
