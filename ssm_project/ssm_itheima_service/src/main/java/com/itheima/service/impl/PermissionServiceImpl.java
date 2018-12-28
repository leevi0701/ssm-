package com.itheima.service.impl;

import com.itheima.domain.Permission;
import com.itheima.mapper.PermissionMapper;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionMapper.findAll();
    }
}
