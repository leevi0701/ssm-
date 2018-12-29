package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.mapper.UserMapper;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserInfo> findAll(Integer pageNum, Integer pageSize, String keyWords) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.findAll(keyWords);
    }

    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userMapper.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userMapper.findById(id);
    }

    @Override
    public void update(UserInfo userInfo, String oldPassword) throws Exception {
        if (!oldPassword.equals(userInfo.getPassword())) {
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        }
        userMapper.update(userInfo);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;
        try {
            userInfo = userMapper.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User(userInfo.getUsername(), /*"{noop}" +*/ userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,
                true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;

    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (Role role : roles) {
            SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_" + role.getRoleName());
            list.add(sga);
        }

        return list;
    }

}