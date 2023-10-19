package model;

import java.io.Serializable;

public class Categories implements Serializable {
    private Long id;
    private String categoryName;

    public Categories() {

    }

    public Categories(Long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
