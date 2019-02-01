package com.zhump.blog.model.vo;

import com.zhump.blog.model.RoleInfo;
import lombok.Data;

import javax.naming.ldap.PagedResultsControl;

@Data
public class RoleInfoVO extends RoleInfo {

    private String description;

    private boolean state;
}
