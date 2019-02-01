package com.zhump.blog.model.vo;

import lombok.Data;

import java.util.List;

/**
 * 权限树类
 */
@Data
public class ResourcesTreeVO {
    /**id*/
    private Long id;

    private Long pid;

    private String name;


    private String url;

    private boolean checked;


    private List<ResourcesTreeVO>  children;
}
