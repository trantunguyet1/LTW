package model;

import java.io.Serializable;

public class Model implements Serializable {
    private Long id;
    private String name;
    private Long categoryID;
    private String categoryName;

    public Model() {
    }

    public Model(Long id, String name, Long categoryID, String categoryName) {
        this.id = id;
        this.name = name;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Model(String name, Long categoryID) {
        this.name = name;
        this.categoryID = categoryID;
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

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
