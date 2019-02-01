package com.zhump.blog.mapper;

import com.zhump.blog.model.dto.RoleResourcesDTO;
import com.zhump.blog.model.vo.RoleResourcesVO;

import java.util.List;

public interface RoleResourcesMapper {



    /**添加数据*/
    int add(RoleResourcesDTO roleResourcesDTO);

    /**根据角色id去查询*/
    List<RoleResourcesVO> getId(Long role_id);

    /**根据角色id去删除*/
    int delete(Long role_id);
}
