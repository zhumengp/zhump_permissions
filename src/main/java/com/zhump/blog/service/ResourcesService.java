package com.zhump.blog.service;

import com.zhump.blog.model.dto.ResourcesDTO;
import com.zhump.blog.model.vo.ResultLevelVO;
import com.zhump.blog.model.vo.ResourcesTreeVO;
import com.zhump.blog.model.vo.ResourcesVO;

import java.util.List;

public interface ResourcesService {

    /**根据id去查询*/
    ResourcesVO getId(Long id);

    /**添加数据*/
    int add(ResourcesDTO resourcesDTO);

    /**根据角色id去查询权限*/
    List<ResourcesTreeVO> getRoleId(Long role_id);

    /**分页查询所有数据*/
    List<ResourcesVO> selectAll(Integer offset,Integer limit);

    /**统计数量*/
    int count();

    /**修改数据*/
    int update(ResourcesDTO resourcesDTO);

    /**查询父目录以及子菜单，只查到二级*/
    List<ResultLevelVO> selectLinkage();

}
