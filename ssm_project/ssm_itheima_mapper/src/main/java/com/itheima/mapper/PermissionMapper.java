package com.itheima.mapper;

import com.itheima.domain.Permission;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
public interface PermissionMapper {

    List<Permission> findAll() throws Exception;
}
