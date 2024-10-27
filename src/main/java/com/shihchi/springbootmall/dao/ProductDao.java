package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
