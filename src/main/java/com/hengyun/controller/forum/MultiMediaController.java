package com.hengyun.controller.forum;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;

import com.hengyun.domain.common.ResponseCode;
import com.hengyun.service.forum.MultiMediaService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 * 多媒体信息上传下载
 * */
@Controller
@RequestMapping("multiMedia")
public class MultiMediaController {

	@Resource
	private MultiMediaService multiMediaService;
	@Resource
	private LoginInfoService loginInfoService;
	
    @RequestMapping("/upload")  
    @ResponseBody
    public String upload(@RequestParam MultipartFile media,HttpServletRequest request) throws IOException  
    {  
    	String tocken = request.getParameter("tocken");
    	ResponseCode response = new ResponseCode();
    	int userId = loginInfoService.isOnline(tocken);
    	if(userId>0){
    	    String originalfilename = media.getOriginalFilename();
    	    String filename = userId+originalfilename;
	    	
	      if(media.isEmpty()){
	    	  response.setCode("110");
	    	  response.setMessage("upload image failure");
	    	  }else{

	    		  multiMediaService.save(media.getInputStream(),filename);
	    		
	    		  response.setCode("207");
	    		  response.setMessage("upload image success");
	    	  }
    	}
	      return JSON.toJSONString(response);
      
    }
          

    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpServletRequest request ,Model model, HttpServletResponse response) throws IOException{
    	String tocken = request.getParameter("tocken");
    	ResponseCode responseCode = new ResponseCode();
    	int userId = loginInfoService.isOnline(tocken);
    	if(userId>0){
     	//response.setContentType(arg0);
    	response.setContentType("image/jpeg"); // 设置返回内容格式
    	String filename = request.getParameter("iconUrl");
    
    	filename = userId+filename;
    	GridFSDBFile gridFSDBFile = multiMediaService.retrieveFileOne(filename);
    	InputStream in = gridFSDBFile.getInputStream();
    	OutputStream os = response.getOutputStream();  //创建输出流
		byte[] b = new byte[1024];  
		while( in.read(b)!= -1){ 
		os.write(b);     
		}
		in.close(); 
		os.flush();
		os.close();
		responseCode.setCode("208");
		responseCode.setMessage("download success");
    	}
		return  JSON.toJSONString(responseCode);
    }
    
}
