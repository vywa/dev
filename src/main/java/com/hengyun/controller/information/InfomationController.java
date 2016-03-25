package com.hengyun.controller.information;

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
import com.hengyun.domain.information.DoctorInfo;
import com.hengyun.domain.information.DoctorInfoResponse;
import com.hengyun.domain.information.InfoResponse;
import com.hengyun.domain.information.Information;
import com.hengyun.domain.information.NickIcon;
import com.hengyun.domain.information.NickIconResponse;
import com.hengyun.domain.information.UploadImageResponse;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.information.InformationService;
import com.hengyun.service.logininfo.LoginInfoService;
import com.hengyun.service.logininfo.UserAccountService;
import com.mongodb.gridfs.GridFSDBFile;

/*
 *  个人基本信息管理
 * */
@Controller
@RequestMapping("info")
public class InfomationController {
	
	private static final Logger log = LoggerFactory.getLogger(InfomationController.class);
	 
	@Resource
	private LoginInfoService loginInfoService;
	@Resource
	private UserAccountService userAccountService;
	@Resource
	private InformationService informationService;
	@Resource
	private IconDao	IconDao;
	

		/*
		 * 加载用户图像
		 * 
		 * */
	    @RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")  
	    @ResponseBody
	    public String upload(@RequestParam MultipartFile image,HttpServletRequest request) throws IOException  
	    {  
	    	
	    	UploadImageResponse response = new UploadImageResponse();
	    	String baseUrl = "http://192.168.31.114/healthcloudserver/info/download?iconUrl=";
	    	
	    	int userId = (int)request.getAttribute("userId");
	    	
	    
    	    String originalfilename = image.getOriginalFilename();
    	    String filename = userId+new Date().getTime()+originalfilename;
		    	
		      if(image.isEmpty()){
		    	  response.setCode("110");
		    	  response.setMessage("upload image failure");
		    	  }else{
		    		  
		    		  //图片存在，替换
		    		  if(IconDao.exist(filename)!=null){
			    		  IconDao.updateIcon(image.getInputStream(),filename);
			    		  Query query2 = Query.query(Criteria.where("userId").is(userId));
			    		  long recordTime = Long.valueOf(new Date().getTime());
			    		  Update update = Update.update("iconUrl", baseUrl+filename).set("recordTime", recordTime);
			    		  informationService.updateFirst(query2, update);
			    		  log.info("用户 "+userId+" 更新图像成功");
			    		  response.setCode("207");
			    		  response.setMessage(String.valueOf(recordTime));
			    		  
			    		  response.setIconUrl(baseUrl+filename);
			    		  response.setRecordTime(recordTime);
		    	  }else {
		    		  IconDao.save(image.getInputStream(),filename);
		    		  Query query2 = Query.query(Criteria.where("userId").is(userId));
		    		  long recordTime = Long.valueOf(new Date().getTime());
		    		  Update update = Update.update("iconUrl", baseUrl+filename).set("recordTime", recordTime);
		    		  informationService.updateFirst(query2, update);
		    		  log.info("用户 "+userId+" 保存图像成功");
		    		  response.setCode("207");
		    		  response.setMessage("upload image success");
		    	
		    		  response.setIconUrl(baseUrl+filename);
		    		  response.setRecordTime(recordTime);
		    	  }
		    	  }
	    	
		      return JSON.toJSONString(response);
	      
	    }
	          
	
	    /*
	     * 下载用户图像
	     * 
	     * */
	    @RequestMapping("/download")
	    @ResponseBody
	    public String download(HttpServletRequest request ,Model model, HttpServletResponse response) throws IOException{
	    	
	    	ResponseCode responseCode = new ResponseCode();
	    	InputStream in = null;
	    	OutputStream os = null;

	    	response.setContentType("image/jpeg"); // 设置返回内容格式
	    	String filename = request.getParameter("iconUrl");
	    
	    	String icon = filename;
	    	GridFSDBFile gridFSDBFile = IconDao.getByFileName(icon);
	    	try{
	    	 in = gridFSDBFile.getInputStream();
	    	} catch(Exception ex){
	    		log.error("图片不存在，获取默认图片");
	    		GridFSDBFile gridFSDBFile2 = IconDao.getByFileName("200000010temp.jpg");
	    		in = gridFSDBFile2.getInputStream();
	    	}
	    	 os = response.getOutputStream();  //创建输出流
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
	    
	   

	 /*
	  * 显示所有用户信息
	  * 
	  * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String show(){
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").exists(true));
		List<Information> information = informationService.queryList(query);
	//	List<Information> information = informationService.getPage(query, 0, 3);
		 return JSON.toJSONString(information);
	}
	
	/*
	 * 登陆加载信息
	 * 
	 * */
	@RequestMapping("/load")
	@ResponseBody
	public String queryInfo(@RequestParam String data,HttpServletRequest request){
		InfoResponse response = new InfoResponse();
		
		JSONObject jsonObject =JSON.parseObject(data);

		String timeStamp = jsonObject.getString("recordTime");
	
		int userId = (int)request.getAttribute("userId");
		
			 Information information = informationService.query(userId);
			 if(information != null){
				 long recordTime = Long.valueOf(information.getRecordTime());
				 if(recordTime>Long.valueOf(timeStamp)){
				
				 response.setCode("206");
				 response.setInfo(information);
				 } else {
					 response.setCode("207");
					 response.setInfo(null);
				 }
			 }else {
				 response.setCode("206");
				 response.setInfo(null);
			 }
			
		
		 return JSON.toJSONString(response);
	}
	
	/*
	 * 
	 * 更新用户信息
	 * 
	 * */
	@RequestMapping(value="/update",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateInfo(@RequestParam String data,HttpServletRequest request){
		ResponseCode response = new ResponseCode();
		JSONObject jsonObject =JSON.parseObject(data);
		Information info = JSON.toJavaObject(jsonObject, Information.class);
		
		int userId =(int)request.getAttribute("userId");
	
			 long recordTime = new Date().getTime();
			 info.setRecordTime(String.valueOf(recordTime));
			
			 Query query =Query.query(Criteria.where("userId").is(userId));
			 Information temp=null;
			try {
				temp = informationService.queryOne(query);
				if(temp!=null){
					
				}
				 informationService.update(info, userId);
			} catch (NullPointerException ex) {
				//加载默认图片
				  String fileUrl = "http://192.168.31.114/healthcloudserver/info/download?iconUrl=200000010temp.jpg";
				 info.setIconUrl(fileUrl);
				 info.setRecordTime(String.valueOf(new Date().getTime()));
				 informationService.add(info, userId);
			}
				 response.setCode("206");
				 response.setMessage(String.valueOf(recordTime));
			 
		
		 return JSON.toJSONString(response);
	}
	
	
	/*
	 * 获取用户昵称
	 * 
	 * */
	@RequestMapping(value="/nickName",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getnickName(HttpServletRequest request,@RequestParam String data){
		NickIconResponse response = new NickIconResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
			
			Query query =Query.query(Criteria.where("userId").is(userId));
			 Information temp =informationService.queryOne(query);
			 String nickname = temp.getTrueName();
			 String disease = temp.getDisease();
			 UserAccount account = userAccountService.queryById(userId);
			 String mobilephone = account.getMobilephone();
			 String email = account.getEmail();
			 String qq = account.getQQ();
			 String weiChat = account.getWeiChat();
			 String weiBo = account.getWeiBo();
			 String workNum = account.getWorkNum();
			 if(nickname==null){
				 if(mobilephone != null){
					 nickname = mobilephone;
				 } else if(email!=null){
					 nickname=email;
				 } else if(qq!=null){
					 nickname = qq;
				 } else if(weiChat !=null){
					 nickname = weiChat;
				 } else if(weiBo !=null){
					 nickname = weiBo;
				 } else if(workNum != null){
					 nickname = workNum;
				 }
			 }
			 String iconUrl = temp.getIconUrl();
			 NickIcon nickIcon = new NickIcon();
			 nickIcon.setNickName(nickname);
			 nickIcon.setDisease(disease);
			 nickIcon.setIconUrl(iconUrl);
			 response.setCode("206");
			 response.setMessage("返回用户昵称和图像");
			 response.setNickIcon(nickIcon);
		
		
		 return JSON.toJSONString(response);
	}
	
	/*
	 * 获取用户信息
	 * 
	 * */
	@RequestMapping(value="/getInfo",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getInfo(HttpServletRequest request,@RequestParam String data){
		NickIconResponse response = new NickIconResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
			
			Query query =Query.query(Criteria.where("userId").is(userId));
			 Information temp =informationService.queryOne(query);
			 String nickname = temp.getTrueName();
			 String sex = temp.getSex();
			 int age = temp.getAge();
			 String birthday  = temp.getBirthday();
			String home = temp.getHometown();
			String disease = temp.getDisease();
			 UserAccount account = userAccountService.queryById(userId);
			 String mobilephone = account.getMobilephone();
			 String email = account.getEmail();
			 String qq = account.getQQ();
			 String weiChat = account.getWeiChat();
			 String weiBo = account.getWeiBo();
			 String workNum = account.getWorkNum();
			 
			
			 String iconUrl = temp.getIconUrl();
			 NickIcon nickIcon = new NickIcon();
			 nickIcon.setIconUrl(iconUrl);
			 nickIcon.setBirthday(birthday);
			 nickIcon.setEmail(email);
			 nickIcon.setHome(home);
			 nickIcon.setMobilephone(mobilephone);
			 nickIcon.setQq(qq);
			 nickIcon.setNickName(nickname);
			 nickIcon.setDisease(disease);
			 nickIcon.setUserId(userId);
			 nickIcon.setWeiBo(weiBo);
			 nickIcon.setWeiChat(weiChat);
			 nickIcon.setWorkNum(workNum);
			 nickIcon.setAge(age);
			 nickIcon.setSex(sex);
			 response.setCode("206");
			 response.setMessage("返回用户昵称和图像");
			 response.setNickIcon(nickIcon);
		
		
		 return JSON.toJSONString(response);
	}
	
	/*
	 * 获取用户信息
	 * 
	 * */
	@RequestMapping(value="/doctorInfo",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorInfo(HttpServletRequest request,@RequestParam String data){
		DoctorInfoResponse response = new DoctorInfoResponse();
		JSONObject jsonObject =JSON.parseObject(data);
		int userId = jsonObject.getIntValue("userId");
			
			Query query =Query.query(Criteria.where("userId").is(userId));
			 Information temp =informationService.queryOne(query);
			 String nickname = temp.getTrueName();
			 String sex = temp.getSex();
			 int age = temp.getAge();
			 String birthday  = temp.getBirthday();
		
			 UserAccount account = userAccountService.queryById(userId);
			 String mobilephone = account.getMobilephone();
			 String email = account.getEmail();
			 String workNum = account.getWorkNum();
			 
			
			 String iconUrl = temp.getIconUrl();
			 DoctorInfo doctorInfo = new DoctorInfo();
			 doctorInfo.setIconUrl(iconUrl);
			 doctorInfo.setBirthday(birthday);
			 doctorInfo.setEmail(email);
			
			 doctorInfo.setMobilephone(mobilephone);
		
			 doctorInfo.setTrueName(nickname);
			 doctorInfo.setUserId(userId);
			
			 doctorInfo.setWorkNum(workNum);
			 doctorInfo.setAge(age);
			 doctorInfo.setSex(sex);
			 response.setCode("206");
			 response.setMessage("返回用户昵称和图像");
			 response.setDoctorInfo(doctorInfo);
		
		
		 return JSON.toJSONString(response);
	}
	
	

}
