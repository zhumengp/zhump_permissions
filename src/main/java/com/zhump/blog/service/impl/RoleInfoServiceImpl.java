package com.zhump.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.zhump.blog.mapper.RoleInfoMappper;
import com.zhump.blog.mapper.RoleResourcesMapper;
import com.zhump.blog.mapper.UserRoleMapper;
import com.zhump.blog.model.dto.RoleInfoDTO;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.model.vo.UserRoleVO;
import com.zhump.blog.service.RoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("roleInfoService")
public class RoleInfoServiceImpl implements RoleInfoService {

    private final Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

    @Autowired
    private RoleInfoMappper roleInfoMappper;

    @Autowired
    private RoleResourcesMapper roleResourcesMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public RoleInfoVO getId(Long id) {
        RoleInfoVO roleInfoVO = roleInfoMappper.getId(id);
        return roleInfoVO;
    }

    @Override
    public int count() {
        int count = roleInfoMappper.count();
        return count;
    }

    @Override
    public List<RoleInfoVO> selectAll(Integer offset, Integer limit) {
        PageHelper.offsetPage(offset,limit);
        List<RoleInfoVO> roleInfoVOS = roleInfoMappper.selectAll();
        return roleInfoVOS;
    }

    @Override
    public List<RoleInfoVO> getUserRole(Long userId) {
        List<RoleInfoVO> list = new ArrayList<>();
        List<UserRoleVO> userRoleVOS = userRoleMapper.getId(userId);
        for (UserRoleVO userRoleVO : userRoleVOS){
            RoleInfoVO roleInfoVO = roleInfoMappper.getId(userRoleVO.getRole_id());
            list.add(roleInfoVO);
        }
        return list;
    }

    @Override
    public int add(RoleInfoDTO roleInfoDTO) {
        int i = roleInfoMappper.add(roleInfoDTO);
        return i;
    }

    @Override
    public int update(RoleInfoDTO roleInfoDTO) {
        int i = roleInfoMappper.update(roleInfoDTO);
        return i;
    }
}
