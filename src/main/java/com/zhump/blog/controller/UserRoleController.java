package com.zhump.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.model.RoleInfo;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.service.RoleInfoService;
import com.zhump.blog.service.UserRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/userRole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleInfoService roleInfoService;
	
	@RequestMapping(value = "/userRoleList",method = RequestMethod.GET)
	@ResponseBody
	@RequiresPermissions("user:role:author")
	public Object selectUserAll(@RequestParam(required = false, defaultValue = "0", value = "offset")Integer offset, 
			   					@RequestParam(required = false, defaultValue = "10", value = "limit")Integer limit,
			   					Long userId) {
		List<RoleInfoVO> rows = userRoleService.getId(userId,offset, limit);
		int count = roleInfoService.count();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", count);
		map.put("rows", rows);
		return map;
	}
	
	@RequestMapping(value = "/insertUserRole",method = RequestMethod.POST)
	@ResponseBody
	public Object selectUserAll(Long userId,@RequestParam(value = "ids[]")Long[] ids) {
		List<Long> roleIds = new ArrayList<Long>();
		if(ids != null && ids.length > 0) {
			for(Long roleId: ids) {
				roleIds.add(roleId);
			}
		}
		JSONObject jsonObject = userRoleService.save(userId, roleIds);
		return new Result(Status.SUCCESS, jsonObject);
	}

	@RequestMapping(value = "/test",method = RequestMethod.POST)
	@ResponseBody
	public Object test(Long userId) {

		int i = userRoleService.delete(userId);
		return new Result(Status.SUCCESS, i);
	}

}
