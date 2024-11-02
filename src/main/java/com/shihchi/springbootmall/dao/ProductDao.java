package com.shihchi.springbootmall.dao;

import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
