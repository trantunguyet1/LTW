package model;

import java.io.Serializable;

public class Product implements Serializable {
    private Long id;
    private String name;
    private String image;
    private Double price;
    private Double discount;
    private Boolean status;
    private String description;
    private Long itemCategoryID;
    private Integer saQuantity;

    public Product() {
    }

    public Product(Long id, String name, String image, Double price, Double discount, Boolean status, String description, Long itemCategoryID, Integer saQuantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.status = status;
        this.description = description;
        this.itemCategoryID = itemCategoryID;
        this.saQuantity = saQuantity;
    }

    public Product(String name, String image, Double price, Double discount, Boolean status, String description, Long itemCategoryID) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.status = status;
        this.description = description;
        this.itemCategoryID = itemCategoryID;
    }

    public Product(Long id, String name, String image, Double price, Double discount, Boolean status, String description, Long itemCategoryID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.discount = discount;
        this.status = status;
        this.description = description;
        this.itemCategoryID = itemCategoryID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getItemCategoryID() {
        return itemCategoryID;
    }

    public void setItemCategoryID(Long itemCategoryID) {
        this.itemCategoryID = itemCategoryID;
    }

    public Integer getSaQuantity() {
        return saQuantity;
    }

    public void setSaQuantity(Integer saQuantity) {
        this.saQuantity = saQuantity;
    }
}
