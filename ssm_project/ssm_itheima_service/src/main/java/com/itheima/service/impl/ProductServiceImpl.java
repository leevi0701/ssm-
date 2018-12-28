package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Product;
import com.itheima.mapper.ProductMapper;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll(Integer pageNum,Integer pageSize,Product product) throws Exception {
        PageHelper.startPage(pageNum,pageSize);
        return productMapper.findAll(product);
    }

    @Override
    public void save(Product product) throws Exception {

        productMapper.save(product);
    }

    @Override
    public void openById(String id) throws Exception {
        productMapper.openById(id);
    }

    @Override
    public void closeById(String id) throws Exception {
        productMapper.closeById(id);
    }

    @Override
    public Product findById(String id) throws Exception {
        return productMapper.findById(id);
    }

    @Override
    public void update(Product product) throws Exception {
        productMapper.update(product);
    }

    @Override
    public void delete(String[] ids) throws Exception {
        productMapper.delete(ids);
    }
}
