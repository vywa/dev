package com.hengyun.controller.information;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.dao.information.IconDao;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.information.Information;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  个人基本信息管理
 * */
@Controller
@RequestMapping("info")
public class InfomationController {
	
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private InformationService informationService;
	@Resource
	private IconDao	IconDao;
	

	    @RequestMapping("/upload")  
	    @ResponseBody
	    public String upload(@RequestParam MultipartFile image,HttpServletRequest request) throws IOException  
	    {  
	    	String tocken = request.getParameter("tocken");
	    	tocken = "1452511202973DA08826AD948805063D8240168FE2F53";
	    	int userId = loginInfoService.isOnline(tocken);
	    	    String originalfilename = image.getOriginalFilename();
	    	    String filename = userId+originalfilename;
		    	ResponseCode response = new ResponseCode();
		      if(image.isEmpty()){
		    	  response.setCode("110");
		    	  response.setMessage("upload image failure");
		    	  }else{
		    		  IconDao.save(image.getInputStream(),filename);
		    		  Query query = Query.query(Criteria.where("userId").is(userId));
		    		  Update update = Update.update("iconUrl", originalfilename);
		    		  informationService.updateFirst(query, update);
		    		  response.setCode("207");
		    		  response.setMessage("upload image success");
		    	  }
		      
		      return JSON.toJSONString(response);
	      
	    }
	          
	
	    @RequestMapping("/download")
	    @ResponseBody
	    public String download(HttpServletRequest request ,Model model, HttpServletResponse response) throws IOException{
	     	ResponseCode responseCode = new ResponseCode();
	    	response.setContentType("image/jpeg"); // 设置返回内容格式
	    	String filename = request.getParameter("image");
	    	String tocken = request.getParameter("tocken");
	    	int userId = loginInfoService.isOnline(tocken);
	    	String icon = userId+filename;
	    	GridFSDBFile gridFSDBFile = IconDao.getByFileName(icon);
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
	    
	   
	//添加用户信息
	@RequestMapping("/add")
	@ResponseBody
	public String addInfo(@RequestParam String data,HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		JSONObject jsonObject =JSON.parseObject(data);
		Information generalInfo = JSON.toJavaObject(jsonObject, Information.class);
		int userId = loginInfoService.isOnline( tocken);
		
		
		ResponseCode response = new ResponseCode();
	
		 if(userId>0){
			 generalInfo.setUserId(userId);
			 informationService.save(generalInfo);
			 response.setCode("206");
			 response.setMessage("edit success");
		 } else if(userId<0){
			 response.setCode("109");
			 response.setMessage("user not login");
		 }

		 return JSON.toJSONString(response);
	}
	
	
	//查询用户信息
	@RequestMapping("/query")
	@ResponseBody
	public String queryInfo(HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		String tocken = request.getParameter("tocken");
		int userId = loginInfoService.isOnline( tocken);
		 if(userId>0){
		
			 Information information = informationService.query(tocken);
			 if(information != null){
				 response.setCode("206");
				 response.setMessage( JSON.toJSONString(information));
				
			 }
			
		 } else if(userId<0){
			 response.setCode("109");
			 response.setMessage("user not login");
		 }
		 return JSON.toJSONString(response);
	}
	
	//更新用户信息
	@RequestMapping("/update")
	@ResponseBody
	public String updateInfo(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		String tocken = request.getParameter("tocken");
		int userId = loginInfoService.isOnline( tocken);
		 if(userId>0){
			 Information information = JSON.toJavaObject(jsonObject, Information.class);
			 informationService.update(information, tocken);
		
				 response.setCode("206");
				 response.setMessage("update success");
		
		 } else if(userId<0){
			 response.setCode("109");
			 response.setMessage("user not login");
		 }
		 return JSON.toJSONString(response);
	}
	
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteInfo(HttpServletRequest request){
		String tocken = request.getParameter("tocken");
		
		return null;
	}
	
}
