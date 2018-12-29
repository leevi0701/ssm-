package com.itheima.mapper;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
public interface PermissionMapper {

    List<Permission> findByRoleId() throws Exception;

    List<Permission> findAll() throws Exception;
}
