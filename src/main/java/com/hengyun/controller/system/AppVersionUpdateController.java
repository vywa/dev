package com.hengyun.controller.system;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hengyun.domain.system.AppVersionUpdate;
import com.hengyun.domain.system.AppVersionUpdateResponse;
import com.hengyun.service.system.AppVersionUpdateService;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月9日 下午5:03:43
* 版本更新控制器
*/
@Controller
@RequestMapping(value="version")
public class AppVersionUpdateController {


	@Resource
	private AppVersionUpdateService appVersionUpdateService;
	
	
	
	@RequestMapping(value="/dinfo",produces = "text/html;charset=UTF-8")  
    @ResponseBody  
    public String dinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{

    	AppVersionUpdateResponse responseCode = new AppVersionUpdateResponse();
    	AppVersionUpdate app = appVersionUpdateService.getLatest("doctor");
    	responseCode.setCode("206");
    	responseCode.setMessage("获取版本信息成功");
    	responseCode.setVersion(app);
    	
		return  JSON.toJSONString(responseCode);
	}
	
	
	@RequestMapping(value="/pinfo",produces = "text/html;charset=UTF-8")  
    @ResponseBody
    public String pinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
		AppVersionUpdateResponse responseCode = new AppVersionUpdateResponse();
		AppVersionUpdate app = appVersionUpdateService.getLatest("patient");
    	responseCode.setCode("206");
    	responseCode.setMessage("获取版本信息成功");
    	responseCode.setVersion(app);
		return  JSON.toJSONString(responseCode);
	}
	
	
}
