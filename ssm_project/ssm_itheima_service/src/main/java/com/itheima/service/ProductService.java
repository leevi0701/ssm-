package com.itheima.service;

import com.itheima.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll(Integer pageNum,Integer pageSize,Product product) throws Exception;

    void save(Product product) throws Exception;

    void openById(String id) throws Exception;

    void closeById(String id) throws Exception;

    Product findById(String id) throws Exception;

    void update(Product product) throws Exception;

    void delete(String[] ids) throws Exception;
}
