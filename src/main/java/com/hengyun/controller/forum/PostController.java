package com.hengyun.controller.forum;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/*
 *  帖子管理
 * */
@Controller  
@RequestMapping("post")  
public class PostController {   
      
	@RequestMapping("/add")
	@ResponseBody
	public String addPost(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/set")
	@ResponseBody
	public String setPost(@RequestParam String data,HttpServletRequest request){
		
		return null;
	}
	
	@RequestMapping("/show")
	@ResponseBody
	public String showPost(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
	@RequestMapping("/edit")
	@ResponseBody
	public String editPost(@RequestParam String data,HttpServletRequest request){
		return null;
	}
	
}