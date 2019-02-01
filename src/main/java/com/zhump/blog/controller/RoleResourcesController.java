package com.zhump.blog.controller;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.service.RoleResourcesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/roleMenu")
public class RoleResourcesController {

    private final Logger logger = LoggerFactory.getLogger(RoleResourcesController.class);

    @Resource(name = "roleResourcesService")
    private RoleResourcesService roleResourcesService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Object add(@RequestParam(value = "roleId")Long roleId,
                      @RequestParam(value = "ids[]")Long[] ids){

        List<Long> menuIds = new ArrayList<Long>();
        for (Long id : ids){
            menuIds.add(id);
        }
        int i = roleResourcesService.add(roleId, menuIds);
        if (i <= 0){
            return new Result(Status.SUCCESS,"false");
        }
        return new Result(Status.SUCCESS,"true");
    }

}
