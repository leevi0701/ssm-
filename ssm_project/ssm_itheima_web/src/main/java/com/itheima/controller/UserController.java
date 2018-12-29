package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Role;
import com.itheima.domain.UserInfo;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-27
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //查询所有用户
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false, defaultValue = "3") Integer pageSize,
                          String keyWords, Model model) throws Exception {
        List<UserInfo> userList = userService.findAll(pageNum, pageSize, keyWords);
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("keyWords", keyWords);
        return "user-list";
    }

    //添加用户
    @RequestMapping("/save")
    public String saveUser(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:/user/findAll";
    }

    //根据用户id查询用户详情
    @RequestMapping("/findById")
    public String findUserById(String id, Model model) throws Exception {
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user", userInfo);
        return "user-show";
    }

    //根据用户id查询需要修改的用户信息
    @RequestMapping("/findUpdateUserById")
    public String updateUserById(String id, Model model) throws Exception {
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user", userInfo);
        return "user-update";
    }

    //修改用户信息
    @RequestMapping("/update")
    public String updateUser(UserInfo userInfo,String oldPassword) throws Exception {
        userService.update(userInfo,oldPassword);
        return "redirect:/user/findAll";
    }
    //根据用户id查询用户角色
    @RequestMapping("/findRolesByUserId")
    public String findRolesByUserId(String id,Model model) throws Exception {
        //所有的角色集合
        List<Role> roleList = roleService.findAll();
        //当前用户拥有的角色集合
        List<Role> u_roleList = roleService.findRolesByUserId(id);
        List listName = new ArrayList();
        //添加当前用户角色名称到listName集合
        for (Role role : u_roleList) {
            listName.add(role.getRoleName());
        }
        model.addAttribute("roleList",roleList);
        //返回listName到前台页面,进行比较
        model.addAttribute("listName",listName);
        return "user-role-add";
    }

}
