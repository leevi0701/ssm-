package com.itheima.service;

import com.itheima.domain.SysLog;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
public interface SysLogService {

    List<SysLog> findAll() throws Exception;
}
