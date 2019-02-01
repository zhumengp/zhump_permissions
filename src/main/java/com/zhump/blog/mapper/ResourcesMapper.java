package com.zhump.blog.mapper;

import com.zhump.blog.model.Resources;
import com.zhump.blog.model.dto.ResourcesDTO;
import com.zhump.blog.model.vo.ResourcesVO;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ResourcesMapper {


    /**根据id去查询*/
    ResourcesVO getId(Long id);

    /**添加数据*/
    int add(ResourcesDTO resourcesDTO);

    /**分页查询所有数据*/
    List<ResourcesVO> selectAll(Map<String,Object> map);

    /**统计数量*/
    int count();

    /**修改数据*/
    int update(ResourcesDTO resourcesDTO);

    /**根据父级id去查询*/
    List<ResourcesVO> selectParentId(Long parent_id);


    List<ResourcesVO> selectChild(@Param("ids")List<Long> ids);
}
