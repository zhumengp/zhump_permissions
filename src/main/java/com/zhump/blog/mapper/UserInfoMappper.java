package com.zhump.blog.mapper;

import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.UserInfoVO;

import java.util.List;

public interface UserInfoMappper {

    /**
     * 分页查询
     * */
    List<UserInfoVO> selectAll();

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
     * 根据id去修改
     */
    int update(UserInfoDTO userInfoDTO);

    /**
     * 增加用户
     * @param userInfoDTO
     * @return
     */
    int add(UserInfoDTO userInfoDTO);

    /**
     * 删除
     */
    int delete(Long user_id);

}
