package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.constant.ProductCategoryEnum;

public class ProductQueryParams {

    private ProductCategoryEnum category;
    private String search;

    public ProductCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ProductCategoryEnum category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
