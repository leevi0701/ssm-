package com.itheima.mapper;

import com.itheima.domain.UserInfo;


import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
public interface UserMapper {

    List<UserInfo> findAll(String keyWords) throws Exception;

    UserInfo findByUsername(String username) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;
}
