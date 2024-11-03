package com.shihchi.springbootmall.service.impl;

import com.shihchi.springbootmall.dao.ProductDao;
import com.shihchi.springbootmall.dao.ProductQueryParams;
import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;
import com.shihchi.springbootmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public List<Product> getProducts(ProductQueryParams params) {
        try {
            return productDao.getProducts(params);
        } catch (Exception e) {
            logger.error("Get Products error - {}", e.getMessage());
            throw e;
        }
    }

    @Override
    public Product getProductById(Integer productId) {
        try {
            return productDao.getProductById(productId);
        }
        catch (Exception e) {
            logger.error("Get Product By Id error - productId = {} - {}", productId, e.getMessage());
            throw e;
        }
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        try {
            return productDao.createProduct(productRequest);
        } catch (Exception e) {
            logger.error("Create product error - productName = {} - {}", productRequest.getProductName(), e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        try {
            productDao.updateProduct(productId, productRequest);
        } catch (Exception e) {
            logger.error("Update product error - productId = {}, productName = {} - {}", productId, productRequest.getProductName(), e.getMessage());
            throw e;
        }
    }

    @Override
    public void deleteProductById(Integer productId) {
        try {
            productDao.deleteProductById(productId);
        } catch (Exception e) {
            logger.error("Update product error - productId = {} - {}", productId, e.getMessage());
            throw e;
        }
    }
}
