package com.itheima.service;

import com.itheima.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
public interface UserService extends UserDetailsService{

    List<UserInfo> findAll(Integer pageNum,Integer pageSize,String keyWords) throws Exception;

    void save(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;
}
