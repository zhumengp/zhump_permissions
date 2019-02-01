package com.zhump.blog.service;

import com.zhump.blog.model.dto.SystemLogDTO;

public interface SystemLogService {


    /**添加日志*/
    int add(SystemLogDTO systemLogDTO);
}
