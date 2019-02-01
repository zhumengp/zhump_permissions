package com.zhump.blog.controller;

import com.zhump.blog.common.result.Result;
import com.zhump.blog.common.result.Status;
import com.zhump.blog.model.dto.ResourcesDTO;
import com.zhump.blog.model.vo.ResultLevelVO;
import com.zhump.blog.model.vo.ResourcesTreeVO;
import com.zhump.blog.model.vo.ResourcesVO;
import com.zhump.blog.service.ResourcesService;
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
@SuppressWarnings("all")
@Controller
@RequestMapping(value = "/resources")
public class ResourcesController {

    private final Logger logger = LoggerFactory.getLogger(ResourcesController.class);

    @Resource(name = "resourcesService")
    private ResourcesService resourcesService;

    @RequestMapping(value = "index")
    public String index(ModelMap modelMap){
        return "/menu/index";
    }


    /**
     * 根据角色查询所有权限
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/menuTree",method = RequestMethod.GET)
    @ResponseBody
    public Object menuTree(@RequestParam(value = "roleId",required = false) Long roleId){
        if (roleId == null){
            return new Result(Status.params,null);
        }
        List<ResourcesTreeVO> roleIdList = resourcesService.getRoleId(roleId);
        return new Result(Status.SUCCESS,roleIdList);
    }


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    @RequiresPermissions(value = "resources:create:read")
    public String add(ModelMap modelMap){
        return "menu/create";
    }

    /**
     * 添加数据
     * @param resourcesDTO
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = "resources:create:read")
    public Object add(@ModelAttribute(value = "resourcesDTO") ResourcesDTO resourcesDTO){
        if (resourcesDTO.getParent_id() == null
                ||resourcesDTO.getPermissions_url() == null
                ||resourcesDTO.getType() == null
                ||resourcesDTO.getStatus() == null){
            return new Result(Status.params,null);
        }
        int i = resourcesService.add(resourcesDTO);
        if (i <= 0){
            logger.debug("==============新增失败============");
            return new Result(Status.SUCCESS,"false");
        }
        logger.debug("=============sql执行成功==============");
        return new Result(Status.SUCCESS,"true");
    }

    /**
     * 分页查询所有数据
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam(value = "offset",required = false,defaultValue = "0") Integer offset,
                       @RequestParam(value = "limit",required = false,defaultValue = "10") Integer limit){
        try {
            List<ResourcesVO> list = resourcesService.selectAll(offset, limit);
            int count = resourcesService.count();
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
     * 编辑页面
     * @param menuId
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "eidt",method = RequestMethod.GET)
    @RequiresPermissions(value = "menu:update:read")
    public String eidt(@RequestParam(value = "menuId")Long menuId, ModelMap modelMap){
        ResourcesVO resourcesVO = resourcesService.getId(menuId);
        if (resourcesVO != null){
            modelMap.put("menuVO",resourcesVO);
        }
        return "/menu/edit";
    }

    /**
     * 修改数据
     * @param resourcesDTO
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = "menu:update:read")
    public Object update(@ModelAttribute(value = "resourcesDTO") ResourcesDTO resourcesDTO){
        try {
            int i = resourcesService.update(resourcesDTO);
            logger.info("============sql执行成功==============");
            if (i == 1){
                return new Result(Status.SUCCESS,"true");
            }else {
                return new Result(Status.SUCCESS,"false");
            }

        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }


    @RequestMapping(value = "/listChild",method = RequestMethod.POST)
    @ResponseBody
    //@RequiresPermissions(value = "menu:update:read")
    public Object listChild(){
        try {
            List<ResultLevelVO> levels = resourcesService.selectLinkage();
            return new Result(Status.SUCCESS,levels);
        }catch (Exception e){
            logger.error("==========sql执行失败==============",e);
            return new Result(Status.ERROR,"操作失败");
        }
    }
}
