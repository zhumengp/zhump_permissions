package com.zhump.blog.controller;

import com.zhump.blog.model.dto.SystemLogDTO;
import com.zhump.blog.service.SystemLogService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.ObjectUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


@Aspect
public class AspectController {

    private final Logger logger = LoggerFactory.getLogger(AspectController.class);

    /**开始时间**/
    private long startTime;

    /**
     * 结束时间
     */
    private long endTime;

    @Resource(name = "systemLogService")
    private SystemLogService systemLogService;


    @Before("execution(* *..controller..*.*(..))")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        logger.info("doBeforeInServiceLayer");
        startTime = System.currentTimeMillis();
    }

    @After("execution(* *..controller..*.*(..))")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        logger.info("doAfterInServiceLayer");
    }

    @Around("execution(* *..controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // 获取request
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();

        SystemLogDTO upmsLogDTO = new SystemLogDTO();
        // 从注解中获取操作名称、获取响应结果
        Object result = pjp.proceed();
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method.isAnnotationPresent(ApiOperation.class)) {
            ApiOperation log = method.getAnnotation(ApiOperation.class);
            upmsLogDTO.setMessage(log.value());
        }
       if (method.isAnnotationPresent(RequiresPermissions.class)) {
            RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
            String[] permissions = requiresPermissions.value();
            if (permissions.length > 0) {
                upmsLogDTO.setUser_name(permissions[0]);
            }
        }
        endTime = System.currentTimeMillis();
        logger.info("doAround>>>result={},耗时：{}", result, endTime - startTime);

        /*upmsLogDTO.setBasePath(RequestUtil.getBasePath(request));
        upmsLogDTO.setIp(RequestUtil.getIpAddr(request));
        upmsLogDTO.setMethod(request.getMethod());
        if (request.getMethod().equalsIgnoreCase("GET")) {
            upmsLogDTO.setParameter(request.getQueryString());
        } else {
            upmsLogDTO.setParameter(ObjectUtils.toString(request.getParameterMap()));
        }*/
        //upmsLogDTO.setResult(JSON.toJSONString(result));
        //upmsLogDTO.setSpendTime((int) (endTime - startTime));
        upmsLogDTO.setUrl(request.getRequestURI());
        upmsLogDTO.setOperation(request.getQueryString());
        upmsLogDTO.setUser_name(ObjectUtils.toString(request.getUserPrincipal()));
        upmsLogDTO.setIp("127.0.0.1");
        upmsLogDTO.setPlatform(request.getHeader("User-Agent"));
        systemLogService.add(upmsLogDTO);
        return result;
    }



}
