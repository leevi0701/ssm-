package com.itheima.service.impl;

import com.itheima.domain.SysLog;
import com.itheima.mapper.SysLogMapper;
import com.itheima.service.SysLogService;
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
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogMapper.findAll();
    }
}
