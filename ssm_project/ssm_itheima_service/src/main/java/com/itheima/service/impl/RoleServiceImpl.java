package com.itheima.service.impl;

import com.itheima.domain.Role;
import com.itheima.mapper.RoleMapper;
import com.itheima.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() throws Exception {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleMapper.save(role);
    }

    @Override
    public List<Role> findRolesByUserId(String id) throws Exception{
        return roleMapper.findByUserId(id);
    }
}
