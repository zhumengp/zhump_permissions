package com.zhump.blog.mapper;


import com.zhump.blog.model.dto.UserRoleDTO;
import com.zhump.blog.model.vo.UserRoleVO;

import java.util.List;

/**
 * 用户角色
 * @author zhump
 */
public interface UserRoleMapper {

    /**
     * 插入角色
     * @return
     */
    int add(UserRoleDTO userRoleDTO);

    /**
     * 根据用户id去查询对应的角色
     * @param user_id
     * @return
     */
    List<UserRoleVO> getId(Long user_id);

    /**
     * 根据用户id去删除
     * */
    int delete(Long user_id);


}
