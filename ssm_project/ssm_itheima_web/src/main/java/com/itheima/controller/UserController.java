package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    //查询所有用户
    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false,defaultValue = "3") Integer pageSize,
                          String keyWords,Model model) throws Exception {
        List<UserInfo> userList = userService.findAll(pageNum,pageSize,keyWords);
        PageInfo pageInfo = new PageInfo(userList);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("keyWords",keyWords);
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
    public String findUserById(String id,Model model) throws Exception {
        UserInfo userInfo = userService.findById(id);
        model.addAttribute("user",userInfo);
        return "user-show";
    }

}
