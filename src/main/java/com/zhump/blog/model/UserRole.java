package com.zhump.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * @author zhump
 */
@Data
public class UserRole implements Serializable {

    /**
     * 用户ID
     */
    private Long user_id;


    /**
     *角色id
     */
    private Long role_id;




}
