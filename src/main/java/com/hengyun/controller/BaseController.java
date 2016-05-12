package com.hengyun.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.controller.exception.ControllerException;
import com.hengyun.domain.common.AppResponse;
import com.hengyun.util.exception.ThealthException;
import com.hengyun.util.exception.ThealthRuntimeException;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月25日 上午10:05:09
* 控制器基础类
*/

public  class BaseController {

        @ExceptionHandler
        @ResponseBody
        public String exception(HttpServletRequest request,Exception e,HttpServletResponse response){
                //request.setAttribute("exceptionMessage", e.getMessage());
                AppResponse appResponse = new AppResponse();
                int code=0;
                String message =null;
                if(e instanceof ControllerException){
                        code =110;
                        message=e.getMessage();
                } else if(e instanceof ThealthException){
                        code = 110;
                        message = e.getMessage();
                }else if(e instanceof Exception){
                        code = 444;
                        message="未知错误";
                }
                appResponse.setCode(code);
                appResponse.setMessage(message);
                Map<String,String> modeMap = new HashMap<String,String>();
                modeMap.put("code", String.valueOf(code));
                modeMap.put("message", message);

                return JSON.toJSONString(appResponse);
        }
}
