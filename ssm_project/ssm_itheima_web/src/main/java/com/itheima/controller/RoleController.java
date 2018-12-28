package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //查询所有角色信息
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }

    //添加角色信息
    @RequestMapping("/save")
    public String saveRole(Role role) throws Exception {
        roleService.save(role);
        return "redirect:/role/findAll";
    }
}
