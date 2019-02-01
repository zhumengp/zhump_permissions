package com.zhump.blog.service.impl;

import com.zhump.blog.mapper.SystemLogMappper;
import com.zhump.blog.model.SystemLog;
import com.zhump.blog.model.dto.SystemLogDTO;
import com.zhump.blog.service.SystemLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("systemLogService")
public class SystemLogServiceImpl implements SystemLogService {

    private final Logger logger = LoggerFactory.getLogger(SystemLogServiceImpl.class);
    @Autowired
    private SystemLogMappper systemLogMappper;

    @Override
    public int add(SystemLogDTO systemLogDTO) {
        return systemLogMappper.add(systemLogDTO);
    }
}
