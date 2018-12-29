package com.itheima.service;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
public interface RoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    List<Role> findRolesByUserId(String id) throws Exception;
}
