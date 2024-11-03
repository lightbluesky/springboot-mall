package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.constant.ProductCategoryEnum;

public class ProductQueryParams {

    private ProductCategoryEnum category;
    private String search;
    private String orderBy;
    private String sort;

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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
