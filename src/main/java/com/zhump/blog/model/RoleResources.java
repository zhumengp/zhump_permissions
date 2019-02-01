package com.zhump.blog.model;


import lombok.Data;

import java.io.Serializable;

/**
 * 角色资源关系
 */
@Data
public class RoleResources implements Serializable {


    /**
     * 角色id
     */
    private Long role_id;

    /**
     * 资源id
     */
    private Long resources_id;
}
