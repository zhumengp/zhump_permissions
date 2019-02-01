package com.zhump.blog.interceptor.shiro;



import com.zhump.blog.common.md5.MD5Util;
import com.zhump.blog.model.RoleInfo;
import com.zhump.blog.model.dto.UserInfoDTO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.model.vo.UserInfoVO;
import com.zhump.blog.service.RoleInfoService;
import com.zhump.blog.service.UserInfoService;
import com.zhump.blog.service.UserRoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm  extends AuthorizingRealm {


    private final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;

    @Resource(name = "userRoleService")
    private UserRoleService userRoleService;

    @Resource(name = "roleInfoService")
    private RoleInfoService roleInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName(username);
        UserInfoVO userInfo = userInfoService.loginAuth(userInfoDTO);
        // 当前用户所有角色
        if(userInfo != null) {
            List<RoleInfoVO> roleList = roleInfoService.getUserRole(userInfo.getId());
            Set<String> roles = new HashSet<String>();
            for (RoleInfoVO role : roleList) {
                if (StringUtils.isNotBlank(role.getName())) {
                    roles.add(role.getName());
                }
            }
            // 当前用户所有权限
            List<ResourcesVO> menuList = userInfoService.getResources(userInfo.getId());
            Set<String> menus = new HashSet<String>();
            for (ResourcesVO resourcesVO : menuList) {
                if (StringUtils.isNotBlank(resourcesVO.getPermissions_value())) {
                    menus.add(resourcesVO.getPermissions_value());
                }
            }
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.setStringPermissions(menus);
            simpleAuthorizationInfo.setRoles(roles);
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {


        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setName(username);
        UserInfoVO userInfoVO = userInfoService.loginAuth(userInfoDTO);
        if (null == userInfoVO){
            throw new UnknownAccountException();
        }
        if (!userInfoVO.getPassword().equals(MD5Util.getMD5(password + userInfoVO.getSalt()))){
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
