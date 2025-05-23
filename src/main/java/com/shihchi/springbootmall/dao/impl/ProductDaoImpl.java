package com.shihchi.springbootmall.dao.impl;

import com.shihchi.springbootmall.dao.ProductDao;
import com.shihchi.springbootmall.dao.ProductQueryParams;
import com.shihchi.springbootmall.dto.ProductRequest;
import com.shihchi.springbootmall.model.Product;
import com.shihchi.springbootmall.rowmapper.ProductRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> getProducts(ProductQueryParams params) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, created_date, " +
                "last_modified_date FROM product WHERE 1=1";
        Map<String,Object> map = new HashMap<>();

        sql = addFilterySql(sql, map, params);

        sql = sql + " ORDER BY " + params.getOrderBy() + " " + params.getSort() +
            " LIMIT :limit OFFSET :offset";
        map.put("limit", params.getLimit());
        map.put("offset", params.getOffset());

        return namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());
    }

    @Override
    public Product getProductById(Integer productId) {
        String sql = "SELECT product_id, product_name, category, image_url, price, stock, description, " +
                "created_date, last_modified_date " +
                "FROM product WHERE product_id = :productId";
        Map<String,Object> map = new HashMap<>();
        map.put("productId", productId);

        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductRowMapper());

        if(!productList.isEmpty())
            return productList.get(0);
        else
            return null;
    }

    @Override
    public Integer countProduct(ProductQueryParams params) {
        String sql = "SELECT COUNT(1) FROM product WHERE 1=1";
        Map<String,Object> map = new HashMap<>();

        sql = addFilterySql(sql, map, params);

        Integer total = namedParameterJdbcTemplate.queryForObject(sql, map, Integer.class);
        return total;
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {

        String sql = "INSERT INTO product (" +
                "product_name, category, image_url, price, stock, description, created_date, last_modified_date" +
                ") VALUES (" +
                ":productName, :category, :imgUrl, :price, :stock, :description" +
                ", :createDate, :lastModifiedDate)";

        Map<String, Object> map = new HashMap<>();
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imgUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());

        Date now = new Date();
        map.put("createDate", now);
        map.put("lastModifiedDate", now);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);
        int productId = keyHolder.getKey().intValue();

        return productId;
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        String sql = "UPDATE product SET product_name = :productName, category = :category, image_url = :imgUrl, price = :price, stock = :stock, " +
                "description=:description, last_modified_date = :lastModifiedDate WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);
        map.put("productName", productRequest.getProductName());
        map.put("category", productRequest.getCategory().toString());
        map.put("imgUrl", productRequest.getImageUrl());
        map.put("price", productRequest.getPrice());
        map.put("stock", productRequest.getStock());
        map.put("description", productRequest.getDescription());
        map.put("lastModifiedDate", new Date());

        namedParameterJdbcTemplate.update(sql, map);
    }

    @Override
    public void deleteProductById(Integer productId) {
        String sql = "DELETE FROM product WHERE product_id = :productId";

        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        namedParameterJdbcTemplate.update(sql, map);
    }

    private String addFilterySql(String sql, Map<String,Object> map, ProductQueryParams params) {
        if(params.getCategory() != null) {
            sql = sql + " AND category = :category";
            map.put("category", params.getCategory().name());
        }

        if(params.getSearch() != null && !params.getSearch().isEmpty()) {
            sql = sql + " AND product_name LIKE :search";
            map.put("search", "%" + params.getSearch() + "%");
        }
        return sql;
    }
}
