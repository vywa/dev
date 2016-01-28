package com.hengyun.controller.forum;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

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
import com.hengyun.domain.forum.UploadResponseCode;
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
	
    @RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")  
    @ResponseBody
    public String upload(@RequestParam MultipartFile media,HttpServletRequest request) throws IOException  
    {  
	    
	    	UploadResponseCode response = new UploadResponseCode();

    	    String originalfilename = media.getOriginalFilename();
    	  
    	    String filename = new Date().getTime()+originalfilename;
    	    System.out.println(filename);
	    	
	      if(media.isEmpty()){
	    	  response.setCode("110");
	    	  response.setMessage("upload image failure");
	    	  }else{

	    		  multiMediaService.save(media.getInputStream(),filename);
	    		  
	    		  response.setCode("0");
	    		  response.setResponseCode(0);
	    		  response.setDescription("上传成功");
	    		  String fileUrl = "http://192.168.31.114/healthcloudserver/multiMedia/download?url="+filename;
	    		  response.setMessage(fileUrl);
	    		  response.setFileUrl(fileUrl);
	    	  }
    	
	      return JSON.toJSONString(response);
      
    }
          

    @RequestMapping("/download")
    @ResponseBody
    public String download(HttpServletRequest request ,Model model, HttpServletResponse response) throws IOException{
    //	String tocken = request.getParameter("tocken");
    	ResponseCode responseCode = new ResponseCode();
    //	int userId = loginInfoService.isOnline(tocken);
    
     	//response.setContentType(arg0);
    //	response.setContentType("image/jpeg"); // 设置返回内容格式
    	String filename = request.getParameter("url");
    	System.out.println(filename);
    
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

		return  JSON.toJSONString(responseCode);
    }
    
}
