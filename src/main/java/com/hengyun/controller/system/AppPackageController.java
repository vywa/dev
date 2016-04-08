package com.hengyun.controller.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
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
import com.hengyun.service.system.AppPackageService;
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
	
	/*
	 * 
	 *  app包上传
	 * 
	 * */
    @RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")  
    @ResponseBody
    public String upload(@RequestParam MultipartFile apk,HttpServletRequest request) throws IOException  
    {  
	    
	    	UploadResponseCode response = new UploadResponseCode();
	    	AppPackage app = new AppPackage();
    	    String originalfilename = apk.getOriginalFilename();
    	  
    	    String filename =originalfilename;
    	
	    	
	      if(apk.isEmpty()){
	    	  response.setCode("110");
	    	  response.setMessage("upload image failure");
	    	  }else{
	    		
	    		  appPackageService.save(apk.getInputStream(),filename);
	    		  String fileUrl = "http://"+NetworkUtil.getPhysicalHostIP()+"/healthcloudserver/app/download?url="+filename;
	    		    app.setAppName(originalfilename);
	        	    app.setPublishTime(new Date());
	        	    app.setUrl(fileUrl);
	        	 //   app.setVersion(version);
	        	    
	    		  response.setCode("0");
	    		  response.setDescription("上传成功");
	    		  response.setMessage(fileUrl);
	    		  response.setFileUrl(fileUrl);
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
