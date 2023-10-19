package model;

import java.io.Serializable;

public class Cart implements Serializable {
    private Long id;
    private Integer quantity;
    private Long userID;
    private String userName;
    private Long productID;
    private String productName;
    private Double amount;
    private String image;

    public Cart() {
    }

    public Cart(Long id, Integer quantity, Long userID, String userName, Long productID, String productName, Double amount) {
        this.id = id;
        this.quantity = quantity;
        this.userID = userID;
        this.userName = userName;
        this.productID = productID;
        this.productName = productName;
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
