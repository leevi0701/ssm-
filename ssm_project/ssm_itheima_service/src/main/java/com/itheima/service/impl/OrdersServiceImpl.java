package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Orders;
import com.itheima.mapper.OrdersMapper;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-26
 */
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(Integer pageNum,Integer PageSize,Orders orders) throws Exception {
        PageHelper.startPage(pageNum,PageSize);
        return ordersMapper.findAll(orders);
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersMapper.findById(id);
    }
}
