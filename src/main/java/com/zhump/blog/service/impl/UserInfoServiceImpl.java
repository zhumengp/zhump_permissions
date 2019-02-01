package com.zhump.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhump.blog.mapper.ResourcesMapper;
import com.zhump.blog.mapper.RoleResourcesMapper;
import com.zhump.blog.mapper.UserInfoMappper;
import com.zhump.blog.mapper.UserRoleMapper;
import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.model.vo.RoleResourcesVO;
import com.zhump.blog.model.vo.UserInfoVO;
import com.zhump.blog.model.vo.UserRoleVO;
import com.zhump.blog.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMappper userInfoMappper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;


    @Autowired
    private ResourcesMapper resourcesMapper;

    @Override
    public List<UserInfoVO> selectAll(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset,limit);
        List<UserInfoVO> list = userInfoMappper.selectAll();
        return list;
    }

    @Override
    public UserInfoVO loginAuth(UserInfoDTO userInfoDTO) {
        UserInfoVO userInfoVO = userInfoMappper.loginAuth(userInfoDTO);
        return userInfoVO;
    }

    @Override
    public UserInfoVO getId(Long id) {
        UserInfoVO userInfoVO = userInfoMappper.getId(id);
        return userInfoVO;
    }

    @Override
    public int count() {
        int count = userInfoMappper.count();
        return count;
    }

    @Override
    public List<ResourcesVO> getResources(Long userId) {
        List<ResourcesVO> menuList = new ArrayList<>();
        List<UserRoleVO> userRoleVOList = userRoleMapper.getId(userId);
        if (userRoleVOList.size() > 0 || userRoleVOList != null){
            for (UserRoleVO userRoleVO : userRoleVOList){
                List<RoleResourcesVO> roleResourcesVOList = roleResourcesMapper.getId(userRoleVO.getRole_id());
                if (roleResourcesVOList.size() > 0 || roleResourcesVOList != null){
                    for (RoleResourcesVO roleResourcesVO : roleResourcesVOList){
                        ResourcesVO resourcesVO = resourcesMapper.getId(roleResourcesVO.getResources_id());
                        menuList.add(resourcesVO);
                    }

                }
            }
        }
        return menuList;
    }

    @Override
    public int update(UserInfoDTO userInfoDTO) {
        int i = userInfoMappper.update(userInfoDTO);
        return i;
    }

    @Override
    public int add(UserInfoDTO userInfoDTO) {
        int i = userInfoMappper.add(userInfoDTO);
        return i;
    }

    @Override
    public int delete(Long user_id) {
        int i = userInfoMappper.delete(user_id);
        return i;
    }
}
