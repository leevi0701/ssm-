package com.itheima.controller;

import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
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
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;
    //查询所有日志信息
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception{
        List<SysLog> sysLogList = sysLogService.findAll();
        model.addAttribute("sysLogs",sysLogList);
        return "syslog-list";
    }
}
