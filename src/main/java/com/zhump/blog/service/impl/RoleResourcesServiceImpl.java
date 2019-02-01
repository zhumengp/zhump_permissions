package com.zhump.blog.service.impl;

import com.zhump.blog.mapper.ResourcesMapper;
import com.zhump.blog.mapper.RoleResourcesMapper;
import com.zhump.blog.model.dto.RoleInfoDTO;
import com.zhump.blog.model.dto.RoleResourcesDTO;
import com.zhump.blog.model.vo.RoleResourcesVO;
import com.zhump.blog.service.RoleResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("roleResourcesService")
public class RoleResourcesServiceImpl implements RoleResourcesService {


    private final Logger logger = LoggerFactory.getLogger(RoleResourcesServiceImpl.class);

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;


    @Override
    public int add(Long roleId,List<Long> menuIds) {
        //先删除已有的
        roleResourcesMapper.delete(roleId);
        int i = 0;
        for (Long menuId : menuIds){
            RoleResourcesDTO roleResourcesDTO = new RoleResourcesDTO();
            roleResourcesDTO.setRole_id(roleId);
            roleResourcesDTO.setResources_id(menuId);
            i = roleResourcesMapper.add(roleResourcesDTO);
        }
        return i;
    }

    @Override
    public List<RoleResourcesVO> getId(Long role_id) {
        List<RoleResourcesVO> list = roleResourcesMapper.getId(role_id);
        return list;
    }
}
