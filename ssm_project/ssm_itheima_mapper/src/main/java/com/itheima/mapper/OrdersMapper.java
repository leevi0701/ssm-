package com.itheima.mapper;

import com.itheima.domain.Orders;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-26
 */
public interface OrdersMapper {

    List<Orders> findAll(Orders orders) throws Exception;

    Orders findById(String id) throws Exception;
}
