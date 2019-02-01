package com.zhump.blog.controller;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.model.Resources;
import com.zhump.blog.model.UserInfo;
import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.service.UserInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 登录相关控制层
 * @author zhump
 */
@Controller
@RequestMapping(value = "/sso")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;


    /**
     * 跳转到登录页
     * @return
     */
    @RequestMapping(value = "/login")
    public String login(){
        return "login/login";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "/index")
    public String index(ModelMap modelMap){

        // 当前登录用户权限
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName(username);
        UserInfo userInfo = userInfoService.loginAuth(userInfoDTO);
        List<ResourcesVO> menuList = userInfoService.getResources(userInfo.getId());
        for(ResourcesVO resourcesVO : menuList){
            System.out.println(resourcesVO.toString());
        }

        if(CollectionUtils.isNotEmpty(menuList)) {

            modelMap.put("menuList", menuList);
            return "index/index";
        }
        return null;
    }

    /**
     * 跳转到首页
     */
    @RequestMapping(value = "/page")
    public String page(){
        return "home/page";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "password",required = false) String password){
        try {
            if (StringUtils.isBlank(name) || StringUtils.isBlank(password)){
                return new Result(Status.params,null);
            }
            Subject subject = SecurityUtils.getSubject();
            //Session session = subject.getSession();
            UsernamePasswordToken token = new UsernamePasswordToken(name,password);
            subject.login(token);
            logger.info("===========登录执行成功===========");
        }catch (UnknownAccountException e) {
            return new Result(Status.NAME_ERROR, null);
        } catch (IncorrectCredentialsException e) {
            return new Result(Status.PASSWORD_ERROR, null);
        }catch (Exception e) {
            logger.error("===========系统异常===========", e);
            return new Result(Status.ERROR,"操作失败");
        }
        return new Result(Status.SUCCESS,"登录成功");
    }
}
