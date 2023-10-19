package model;

import java.io.Serializable;

public class ItemCategories implements Serializable {
    private Long id;
    private String itemCategoryName;
    private Long categoryID;

    public ItemCategories() {
    }

    public ItemCategories(Long id, String itemCategoryName, Long categoryID) {
        this.id = id;
        this.itemCategoryName = itemCategoryName;
        this.categoryID = categoryID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public Long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }
}
