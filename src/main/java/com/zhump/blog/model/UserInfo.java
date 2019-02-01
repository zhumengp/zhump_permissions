package com.zhump.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author zhump
 */
@Data
public class UserInfo implements Serializable {

    /**
     *主键
     */
    private Long id;
    /**
     *名称
     */
    private String name;
    /**
     *密码
     */
    private String password;
    /**
     *盐
     */
    private String salt;
    /**
     *地址
     */
    private String address;
    /**
     *头像
     */
    private String head_img;
    /**
     *登录次数
     */
    private Integer login_num;
    /**
     *创建时间
     */
    private Date create_time;
    /**
     *修改时间
     */
    private Date update_time;
    /**
     *登录时间
     */
    private Date login_time;
    /**
     *邮箱
     */
    private String email;
    /**
     *手机号
     */
    private String phone;

    /**
     * 用户锁 0 异常 1 正常
     */
    private Integer locked;



}
