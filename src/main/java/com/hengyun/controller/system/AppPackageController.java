package com.hengyun.controller.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.forum.UploadResponseCode;
import com.hengyun.domain.system.AppPackage;
import com.hengyun.domain.system.AppPackageResponse;
import com.hengyun.domain.system.AppVersionUpdate;
import com.hengyun.domain.system.AppVersionUpdateResponse;
import com.hengyun.service.system.AppPackageService;
import com.hengyun.service.system.AppVersionUpdateService;
import com.hengyun.util.network.NetworkUtil;
import com.mongodb.gridfs.GridFSDBFile;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月30日 上午10:20:11
* app版本控制器类
*/
@Controller
@RequestMapping("app")
public class AppPackageController {

	private static final Logger log = LoggerFactory.getLogger(AppPackageController.class);
	@Resource
	private AppPackageService appPackageService;
	
	@Resource
	private AppVersionUpdateService appVersionUpdateService;
	/*
	 * 
	 *  app包上传
	 * 
	 * */
    @RequestMapping(value="/dupload",produces = "text/html;charset=UTF-8")  
    @ResponseBody
    public String dupload(@RequestParam MultipartFile apk,HttpServletRequest request) throws IOException  
    {  
	    
    	AppVersionUpdateResponse response = new AppVersionUpdateResponse();
	   
    	    String filename = apk.getOriginalFilename();
	    	
	      if(apk.isEmpty()){
	    	  response.setCode("110");
	    	  response.setMessage("上传医生端app失败");
	    	  }else{
	    		
	    		
	    		  AppVersionUpdate appVersion;
				try {
					appVersion = appVersionUpdateService.getLatest("doctor");
					float versionCode = Float.valueOf(appVersion.getServerCode());
					versionCode = (float) (versionCode + 0.1);
					String newVersion = String.valueOf(versionCode);
					appVersion.setServerCode(newVersion);
					String appName = appVersion.getAppName();
					appName.substring(0, 17);
					appName="healthclouddoctor"+newVersion+".apk";
					appVersion.setAppName(appName);
					  appPackageService.save(apk.getInputStream(),appName);
		    		  String fileUrl = "http://"+NetworkUtil.getPhysicalHostIP()+"/healthcloudserver/app/download?url="+appName;
		    		  appVersion.setApkUrl(fileUrl);
		    		  appVersion.setDescription("更新版本");
		    		  appVersionUpdateService.addUpdate(appVersion);
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					String file = "healthclouddoctor0.1.apk";
					appVersion = new AppVersionUpdate();
					appVersion.setAppName(file);
					appVersion.setDescription("添加医生apk");
					appVersion.setServerCode("1.0");
					appVersion.setType("doctor");
					
					  appPackageService.save(apk.getInputStream(),file);
		    		  String fileUrl = "http://"+NetworkUtil.getPhysicalHostIP()+"/healthcloudserver/app/download?url="+file;
		    		  appVersion.setApkUrl(fileUrl);
				
					 appVersionUpdateService.addUpdate(appVersion);
				}

		    		  response.setCode("0");
		    		  response.setMessage("上传医生端app成功");

	    	  }
    	
	      return JSON.toJSONString(response);
      
    }
       
    /*
     *  上传病人端apk
     * */
    @RequestMapping(value="/pupload",produces = "text/html;charset=UTF-8")  
    @ResponseBody
    public String pupload(@RequestParam MultipartFile apk,HttpServletRequest request) throws IOException  
    {  
	    
     	AppVersionUpdateResponse response = new AppVersionUpdateResponse();
 	   
	    String filename = apk.getOriginalFilename();
    	
      if(apk.isEmpty()){
    	  response.setCode("110");
    	  response.setMessage("上传病人端app失败");
    	  }else{
    		
    		
    		  AppVersionUpdate appVersion;
			try {
				appVersion = appVersionUpdateService.getLatest("patient");
				float versionCode = Float.valueOf(appVersion.getServerCode());
				versionCode = (float) (versionCode + 0.1);
				String newVersion = String.valueOf(versionCode);
				appVersion.setServerCode(newVersion);
				String appName = appVersion.getAppName();
				appName.substring(0, 18);
				appName="healthcloudpatient"+newVersion+".apk";
				appVersion.setAppName(appName);
				  appPackageService.save(apk.getInputStream(),appName);
	    		  String fileUrl = "http://"+NetworkUtil.getPhysicalHostIP()+"/healthcloudserver/app/download?url="+appName;
	    		  appVersion.setApkUrl(fileUrl);
	    		  appVersion.setDescription("更新版本");
	    		  appVersionUpdateService.addUpdate(appVersion);
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				String file = "healthcloudpatient0.1.apk";
				appVersion = new AppVersionUpdate();
				appVersion.setAppName(file);
				appVersion.setDescription("添加病人apk");
				appVersion.setServerCode("1.0");
				appVersion.setType("patient");
				
				  appPackageService.save(apk.getInputStream(),file);
	    		  String fileUrl = "http://"+NetworkUtil.getPhysicalHostIP()+"/healthcloudserver/app/download?url="+file;
	    		  appVersion.setApkUrl(fileUrl);
			
				 appVersionUpdateService.addUpdate(appVersion);
			}

	    		  response.setCode("0");
	    		  response.setMessage("上传病人端app成功");

    	  }
	
      return JSON.toJSONString(response);
      
    }

    /*
     * 
     *  下载app文件
     * 
     * */
    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpServletRequest request ,Model model, HttpServletResponse response) throws IOException{
    	ResponseCode responseCode = new ResponseCode();
   
    	String filename = request.getParameter("url");
  
    	response.addHeader("Content-Disposition", "attachment;filename="+filename);  
       
    	GridFSDBFile gridFSDBFile = appPackageService.retrieveFileOne(filename);
    	InputStream in = gridFSDBFile.getInputStream();
    	OutputStream os = response.getOutputStream();  //创建输出流
    	
		byte[] b = new byte[1024];
		int z;
		while( (z=in.read(b,0,b.length))!= -1){ 
		os.write(b,0,z);     
		}
		in.close(); 
		os.flush();
		os.close();
	
		responseCode.setCode("208");
		responseCode.setMessage("download success");

		return  JSON.toJSONString(responseCode);
    }
	
    /*
     * 
     *  查询app文件列表
     * 
     * */
    @RequestMapping("/list")
    @ResponseBody
    public String list(HttpServletRequest request , HttpServletResponse response) throws IOException{
    	AppPackageResponse responseCode = new AppPackageResponse();
    	List<AppPackage> list =appPackageService.queyList();
    	responseCode.setCode("206");
    	responseCode.setMessage("查询列表成功");
    	responseCode.setList(list);
		return  JSON.toJSONString(responseCode);
    }
}
