package com.zhump.blog.service;

import com.alibaba.fastjson.JSONObject;
import com.zhump.blog.model.RoleInfo;
import com.zhump.blog.model.dto.UserRoleDTO;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.model.vo.UserRoleVO;

import java.util.List;

public interface UserRoleService {
    /**
     * 插入角色
     * @return
     */
    JSONObject save(Long user_id, List<Long> roleIds);

    /**
     * 根据用户id去查询对应的角色
     * @param user_id
     * @return
     */
    List<RoleInfoVO> getId(Long user_id, Integer offset, Integer limit);

    int delete(Long user_id);
}
