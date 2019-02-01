package com.zhump.blog.model.dto;

import lombok.Data;

/**
 * 用户实体类
 * @author zhump
 */
@Data
public class UserRoleDTO{

    /**
     * 用户id
     */
    private Long user_id;

    /**
     * 角色id
     */
    private Long role_id;


}
