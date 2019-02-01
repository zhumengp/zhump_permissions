package com.zhump.blog.mapper;

import com.zhump.blog.model.dto.RoleInfoDTO;
import com.zhump.blog.model.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoMappper {

    /**根据id去查询*/
    RoleInfoVO getId(Long id);

    /**统计数量*/
    int count();

    /**分页查询所有数据*/
    List<RoleInfoVO> selectAll();

    /**添加数据*/
    int add(RoleInfoDTO roleInfoDTO);

    /**修改数据*/
    int update(RoleInfoDTO roleInfoDTO);


}
