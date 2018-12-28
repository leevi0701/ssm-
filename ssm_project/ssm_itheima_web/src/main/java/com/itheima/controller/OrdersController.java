package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Orders;
import com.itheima.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-26
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false,defaultValue = "4") Integer pageSize,
                          Orders ordes,Model model) throws Exception {

        List<Orders> ordersList = ordersService.findAll(pageNum,pageSize,ordes);
        PageInfo pageInfo = new PageInfo(ordersList);
        model.addAttribute("pageInfo",pageInfo);
        return "orders-list";
    }

    @RequestMapping("/findById")
    public String findById(String id,Model model) throws Exception{

        Orders orders = ordersService.findById(id);
        model.addAttribute("orders",orders);
        return "orders-show";
    }
}
