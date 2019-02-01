package com.zhump.blog.service;

import com.zhump.blog.model.vo.RoleResourcesVO;

import java.util.List;

public interface RoleResourcesService {

    /**添加数据*/
    int add(Long roleId,List<Long> menuId);

    /**根据角色id去查询*/
    List<RoleResourcesVO> getId(Long role_id);

}
