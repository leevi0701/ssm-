package com.itheima.service;

import com.itheima.domain.Orders;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-26
 */
public interface OrdersService {
    List<Orders> findAll(Integer pageNum,Integer PageSize,Orders orders) throws Exception;

    Orders findById(String id) throws Exception;
}
