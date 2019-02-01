package com.zhump.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.zhump.blog.mapper.UserRoleMapper;
import com.zhump.blog.model.RoleInfo;
import com.zhump.blog.model.UserRole;
import com.zhump.blog.model.dto.UserRoleDTO;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.model.vo.UserInfoVO;
import com.zhump.blog.model.vo.UserRoleVO;
import com.zhump.blog.service.RoleInfoService;
import com.zhump.blog.service.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    private final Logger logger = LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleInfoService roleInfoService;

    @Transactional
    @Override
    public JSONObject save(Long user_id, List<Long> roleIds) {
        //先删除
        userRoleMapper.delete(user_id);
        int i = 0;
        //再增加
        for (Long roleId : roleIds){
            UserRoleDTO userRoleDTO = new UserRoleDTO();
            userRoleDTO.setUser_id(user_id);
            userRoleDTO.setRole_id(roleId);
            i = userRoleMapper.add(userRoleDTO);
        }
        JSONObject json = new JSONObject();
        if(i > 0 && i !=0) {
            json.put("state", "OK");
            json.put("msg", "修改成功");
        }
        return json;
    }

    @Override
    public List<RoleInfoVO> getId(Long user_id,Integer offset, Integer limit) {

        RoleInfoVO userRoleVO = null;
        PageHelper.offsetPage(offset, limit, false);
        List<RoleInfoVO> roleList = new ArrayList<RoleInfoVO>();
        List<RoleInfoVO> roleAll = roleInfoService.selectAll(offset,limit);
        List<UserRoleVO> list = userRoleMapper.getId(user_id);
        for(RoleInfoVO role : roleAll) {
            userRoleVO = new RoleInfoVO();
            for(UserRole userRole : list) {
                RoleInfoVO roles = roleInfoService.getId(userRole.getRole_id());
                if(roles.getId() == role.getId()) {
                    userRoleVO.setState(true);
                }
            }
            userRoleVO.setId(role.getId());
            userRoleVO.setName(role.getName());
            userRoleVO.setCreate_time(role.getCreate_time());
            userRoleVO.setUpdate_time(role.getUpdate_time() == null ? null : role.getUpdate_time());
            userRoleVO.setDescription(role.getName());
            roleList.add(userRoleVO);

        }

        return roleList;


    }

    @Override
    public int delete(Long user_id) {
        //先删除
        int i = userRoleMapper.delete(user_id);
        return i;
    }
}
