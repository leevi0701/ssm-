package com.itheima.mapper;

import com.itheima.domain.Traveller;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
public interface TravellerMapper {

    List<Traveller> findByOrdersId(String ordersId);
}
