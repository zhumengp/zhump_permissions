package com.zhump.blog.model;

import lombok.Data;

import java.util.Date;

/**
 * 日志表
 */
@Data
public class SystemLog {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 操作
     */
    private String operation;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 请求rul
     */
    private String url;

    /**
     * 平台
     */
    private String platform;

    /**
     * 执行操作
     */
    private String message;

    /**
     * 创建时间
     */
    private Date create_time;
}
