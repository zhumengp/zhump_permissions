package com.zhump.blog.controller;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.UserInfoVO;
import com.zhump.blog.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/user")
public class UserInfoController {

    private final  Logger logger = LoggerFactory.getLogger(UserInfoController.class);


    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @RequiresPermissions(value = "user:list:read")
    public String index(ModelMap modelMap){
        return "/user/index";
    }


    /**
     * 分页查询用户信息
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = "user:list:read")
    public Object list(@RequestParam(value = "offset",required = false,defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit",required = false,defaultValue = "10") Integer limit){
        try {
            List<UserInfoVO> list = userInfoService.selectAll(offset,limit);
            int count = userInfoService.count();
            logger.info("==========sql执行完成==============");
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("total",count);
            map.put("rows",list);
            return map;
        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }


    /**
     * 添加用户
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = "user:create:read")
    public Object add(@ModelAttribute(value = "userInfoDTO")UserInfoDTO userInfoDTO){
        try {
            int i = userInfoService.add(userInfoDTO);
            if (i <= 0){
                return new Result(Status.SUCCESS,"false");
            }
            logger.info("==========sql执行成功==============");
            return new Result(Status.SUCCESS,"true");
        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }

    /**
     * 编辑用户
     * @param userId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    @RequiresPermissions(value = "user:update:read")
    public String edit(@RequestParam(value = "userId")Long userId, ModelMap modelMap){
        UserInfoVO userInfoVO = userInfoService.getId(userId);
        if (userInfoVO != null){
            modelMap.put("userInfo",userInfoVO);
        }
        return "/user/edit";
    }

    /**
     * 修改用户信息
     * @param userInfoDTO
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = "user:update:read")
    public Object update(@ModelAttribute(value = "userInfoDTO")UserInfoDTO userInfoDTO){
        try {
            int i = userInfoService.update(userInfoDTO);
            if (i <= 0){
                return new Result(Status.SUCCESS,"false");
            }
            logger.info("==========sql执行成功==============");
            return new Result(Status.SUCCESS,"true");
        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }

    /**
     *删除用户
     * @param userId 用户ID
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = "user:delete:read")
    public Object delete(Long userId){
        try {
            if (userId == null){
                return new Result(Status.params,"");
            }
            int i = userInfoService.delete(userId);
            if (i <= 0){
                return new Result(Status.SUCCESS,"false");
            }
            logger.info("==========sql执行成功==============");
            return new Result(Status.SUCCESS,"true");
        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }


}
