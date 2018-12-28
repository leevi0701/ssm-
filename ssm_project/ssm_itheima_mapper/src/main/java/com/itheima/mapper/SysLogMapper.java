package com.itheima.mapper;

import com.itheima.domain.SysLog;

import java.util.List;

/**
 * @author: liwei
 * @Date: 2018-12-28
 */
public interface SysLogMapper {

    List<SysLog> findAll() throws Exception;
}
