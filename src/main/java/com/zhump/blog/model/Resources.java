package com.zhump.blog.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Resources implements Serializable {

    /**
     *主键
     */
    private Long id;

    /**
     *名称
     */
    private String name;

    /**
     *父级id
     */
    private Long parent_id;

    /**
     *图标
     */
    private String  icon;

    /**
     *访问URL
     */
    private String permissions_url;

    /**
     *权限值
     */
    private String permissions_value;

    /**
     *类型 1 2 3
     */
    private Integer  type;

    /**
     *状态
     */
    private Integer  status;

    /**
     *创建时间
     */
    private Date create_time;

    /**
     *修改时间
     */
    private Date update_time;
}
