package com.zhump.blog.model.dto;

import lombok.Data;

import java.util.Date;


@Data
public class RoleInfoDTO {

    /**
     *主见
     */
    private Long id;

    /**
     *名称
     */
    private String name;

    /**
     *创建时间
     */
    private Date create_time;

    /**
     *修改时间
     */
    private Date update_time;
}
