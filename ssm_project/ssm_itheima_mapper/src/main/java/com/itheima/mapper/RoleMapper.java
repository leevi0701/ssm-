package com.itheima.mapper;

import com.itheima.domain.Role;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
public interface RoleMapper {

    List<Role> findByUserId() throws Exception;

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;
}
