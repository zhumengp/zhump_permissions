package com.zhump.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhump.blog.mapper.ResourcesMapper;
import com.zhump.blog.mapper.RoleResourcesMapper;
import com.zhump.blog.model.dto.ResourcesDTO;
import com.zhump.blog.model.vo.ResultLevelVO;
import com.zhump.blog.model.vo.ResourcesTreeVO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.model.vo.RoleResourcesVO;
import com.zhump.blog.service.ResourcesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zhump.blog.model.vo.ResultLevelVO.SecLink;

@SuppressWarnings("all")
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {

    private final Logger logger = LoggerFactory.getLogger(ResourcesServiceImpl.class);

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;

    @Override
    public ResourcesVO getId(Long id) {
        ResourcesVO resourcesVO = resourcesMapper.getId(id);
        return resourcesVO;
    }

    @Override
    public int add(ResourcesDTO resourcesDTO) {
        int i = resourcesMapper.add(resourcesDTO);
        return i;
    }

    @Override
    public List<ResourcesTreeVO> getRoleId(Long role_id) {
        List<RoleResourcesVO> roleResourcesVOS = roleResourcesMapper.getId(role_id);
        Map<String,Object> map = new HashMap<>();
        map.put("status",1);
        List<ResourcesVO> resourcesVOS = resourcesMapper.selectAll(map);
        List<ResourcesTreeVO> menuTreeVOs = new ArrayList<>();
        for (ResourcesVO resourcesVO : resourcesVOS) {
            if (resourcesVO.getParent_id() == 0) {
                ResourcesTreeVO resourcesTreeVO = new ResourcesTreeVO();
                resourcesTreeVO.setId(resourcesVO.getId());
                resourcesTreeVO.setName(resourcesVO.getName());
                resourcesTreeVO.setUrl(resourcesVO.getPermissions_url());
                resourcesTreeVO.setPid(resourcesVO.getParent_id());
                for (RoleResourcesVO roleResourcesVO : roleResourcesVOS){
                    if (resourcesVO.getId() == roleResourcesVO.getResources_id()){
                        resourcesTreeVO.setChecked(true);
                    }
                }
                menuTreeVOs.add(resourcesTreeVO);
            }
        }
        for (ResourcesTreeVO menu : menuTreeVOs) {
            menu.setChildren(getChildren(menu.getId(), resourcesVOS,role_id));
        }
        return menuTreeVOs;
    }

    private List<ResourcesTreeVO> getChildren(Long id, List<ResourcesVO> rootMenu,Long role_id) {
        List<RoleResourcesVO> roleResourcesVOS = roleResourcesMapper.getId(role_id);
        List<ResourcesTreeVO> childList = new ArrayList<>();
        for (ResourcesVO menu : rootMenu) {
            if (menu.getParent_id() != null) {
                if (menu.getParent_id().equals(id)) {
                    ResourcesTreeVO resourcesTreeVO = new ResourcesTreeVO();
                    resourcesTreeVO.setId(menu.getId());
                    resourcesTreeVO.setName(menu.getName());
                    resourcesTreeVO.setUrl(menu.getPermissions_url());
                    resourcesTreeVO.setPid(menu.getParent_id());
                    for (RoleResourcesVO roleResourcesVO : roleResourcesVOS){
                        if (menu.getId() == roleResourcesVO.getResources_id()){
                            resourcesTreeVO.setChecked(true);
                        }
                    }
                    childList.add(resourcesTreeVO);
                }
            }
        }
        for (ResourcesTreeVO menu : childList) {
            menu.setChildren(getChildren(menu.getId(), rootMenu,role_id));
        }
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    @Override
    public List<ResourcesVO> selectAll(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset,limit);
        Map<String,Object> map = new HashMap<>();
        List<ResourcesVO> resourcesVOS = resourcesMapper.selectAll(map);
        return resourcesVOS;
    }

    @Override
    public int count() {
        int count = resourcesMapper.count();
        return count;
    }

    @Override
    public int update(ResourcesDTO resourcesDTO) {
        int i = resourcesMapper.update(resourcesDTO);
        return i;
    }

    @Override
    public List<ResultLevelVO> selectLinkage() {
        List<ResourcesVO> resourcesVOS = resourcesMapper.selectParentId(0l);
        List<ResultLevelVO> resultLevelVO = new ArrayList<ResultLevelVO>();

        ResultLevelVO resultLevelVO1 = null;
        for (ResourcesVO resourcesVO : resourcesVOS){
            resultLevelVO1 = new ResultLevelVO();
            resultLevelVO1.setParent_id(resourcesVO.getId());
            resultLevelVO1.setP_name(resourcesVO.getName());
            List<ResourcesVO> list = resourcesMapper.selectParentId(resourcesVO.getId());
            for (ResourcesVO resourcesVO1 : list){
                SecLink secLink = new SecLink();
                secLink.setC_id(resourcesVO1.getId());
                secLink.setC_name(resourcesVO1.getName());
                resultLevelVO1.getSecLinks().add(secLink);
            }
            resultLevelVO.add(resultLevelVO1);

        }
        return resultLevelVO;
    }

}
