package com.zhump.blog.service;

import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.model.vo.UserInfoVO;

import java.util.List;

public interface UserInfoService {

    /**
     * 分页查询
     * */
    List<UserInfoVO> selectAll(Integer offset, Integer limit);

    /**登录*/
    UserInfoVO loginAuth(UserInfoDTO userInfoDTO);

    /**
     * 根据id去查询
     */
    UserInfoVO getId(Long id);

    /**
     *统计数量
     */
    int count();

    /**
     * 根据id去查询对应的权限
     */
    List<ResourcesVO> getResources(Long userId);

    /**
     * 根据id去修改
     */
    int update(UserInfoDTO userInfoDTO);

    /**
     * 添加数据
     */
    int add(UserInfoDTO userInfoDTO);

    /**
     * 删除
     */
    int delete(Long user_id);
}
