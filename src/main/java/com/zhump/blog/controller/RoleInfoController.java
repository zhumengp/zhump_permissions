package com.zhump.blog.controller;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.model.vo.RoleInfoVO;
import com.zhump.blog.service.RoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/role")
public class RoleInfoController {

    private final Logger logger = LoggerFactory.getLogger(UserInfoController.class);


    @Resource(name = "roleInfoService")
    private RoleInfoService roleInfoService;

    @RequestMapping(value = "index")
    public String index(ModelMap modelMap){
        return "/role/index";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "offset",required = false,defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit",required = false,defaultValue = "10") Integer limit){
        try {
            List<RoleInfoVO> list = roleInfoService.selectAll(offset, limit);
            int count = roleInfoService.count();
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
}
