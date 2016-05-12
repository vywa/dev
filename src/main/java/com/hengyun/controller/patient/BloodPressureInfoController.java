package com.hengyun.controller.patient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.controller.BaseController;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.domain.patient.HealthInfoResponse;
import com.hengyun.domain.patient.HealthLine;
import com.hengyun.domain.patient.MachineBloodResponse;
import com.hengyun.domain.patient.PressureResponse;
import com.hengyun.domain.patient.RegisterResponse;
import com.hengyun.service.patient.BloodPressureInfoService;
import com.hengyun.service.patient.HealthLineService;
import com.hengyun.service.patient.HealthTargetService;
import com.hengyun.service.patient.MachineRelationService;
import com.hengyun.util.json.JSONUtil;

/*
 * 
 *  	血压操作
 *  
 * */
@Controller
@RequestMapping("bloodPressure")
public class BloodPressureInfoController extends BaseController{

	private static final Logger log = LoggerFactory.getLogger(BloodPressureInfoController.class);
	
	@Resource
	private BloodPressureInfoService  bloodPressureInfoService;
	
	@Resource
	private HealthTargetService healthTargetService;
	
	@Resource
	private HealthLineService healthLineService;
	
	@Resource
	private MachineRelationService machineRelationService;
	/*
	 * 
	 * 	查询某个指定时间段的测量数据
	 * 
	 * */
	@RequestMapping(value="/show",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBlood(@RequestParam String data,HttpServletRequest request){
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PressureResponse response = new PressureResponse();

		int userId = (int)request.getAttribute("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId);
		HealthLine healthLine = healthLineService.getPressureLine(userId);	
		
		response.setCode("211");//112
		response.setBloodPressureInfo(bloodList);
		response.setHealthLine(healthLine);
		return  JSONObject.toJSONString(response);
	}
	
	/*
	 * 
	 *  获取最近一段时间数据记录(单位是天，周，月)
	 * */
	@RequestMapping(value="/latestDay",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String lates(HttpServletRequest request){
	
		PressureResponse response = new PressureResponse();
		int userId = (int)request.getAttribute("userId");
		List<BloodPressureInfo> bloodList = null;
		BloodPressureInfo lastRecode = bloodPressureInfoService.getlatestRecord(userId);
		if(lastRecode==null){
			response.setCode("211");
			
			response.setBloodPressureInfo(bloodList);

		} else {
			bloodList= new ArrayList<BloodPressureInfo>();
			bloodList.add(lastRecode);
		
		response.setCode("211");
		
		response.setBloodPressureInfo(bloodList);
		}
		return  JSONObject.toJSONString(response);
	}
	
	/*
	 * 
	 * 	医生查询某个用户的血压记录
	 * 
	 * */
	@RequestMapping(value="/doctorQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String doctorShow(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PressureResponse response = new PressureResponse();
		int userId2 = jsonObject.getIntValue("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId2);
		HealthLine healthLine = healthLineService.getPressureLine(userId2);
		response.setCode("211");
		response.setHealthLine(healthLine);
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
		
	}
	
	/*
	 * 
	 * 	病人亲属查询某个用户的血压记录
	 * 
	 * */
	@RequestMapping(value="/friendQuery",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String friendQuery(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		PressureResponse response = new PressureResponse();
		int userId2 = jsonObject.getIntValue("userId");
		long startTime = jsonObject.getLongValue("startTime");
		long endTime =jsonObject.getLongValue("endTime");
		
		List<BloodPressureInfo> bloodList = bloodPressureInfoService.getInfoByTime(startTime, endTime, userId2);
		response.setCode("211");
		response.setBloodPressureInfo(bloodList);
		
		return  JSONObject.toJSONString(response);
		
	}
	
	/*
	 * 
	 * 	查询所有用户的血压记录 （管理员）
	 * 
	 * */
	@RequestMapping(value="/showAll",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String showBlood(){
		Query query = Query.query(Criteria.where("userId").exists(true));
	
		query.with(new Sort(Direction.DESC, "measureTime"));
		
		List<BloodPressureInfo> list =bloodPressureInfoService.queryList(query);
		String result = JSONObject.toJSONString(list);
		return result;
	}
	
	
	
	/*
	 * 
	 *  	上传用户的血压数据
	 *  
	 * */
	@RequestMapping(value="/upload",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String  upload(@RequestParam String data,HttpServletRequest request){
		
		JSONObject jsonObject =JSONUtil.parseObject(data);
		HealthInfoResponse response = new HealthInfoResponse();
		BloodPressureInfo blood = JSONUtil.toJavaObject(jsonObject, BloodPressureInfo.class);
		int userId = (int)request.getAttribute("userId");
		blood.setUserId(userId);
		
	
		//保存数据
		bloodPressureInfoService.addInfo(blood);
		
		response.setCode("0");//-1
		response.setMessage("血压上传成功");
	
	
		return JSON.toJSONString(response);
		
	}
	
	/*
	 *  血压计上传数据
	 * */
	@RequestMapping(value="finalresult")
	@ResponseBody
	public String upload(HttpServletRequest request,HttpServletResponse response){
		String content=null;
	 	OutputStream os = null;
		InputStream is = null;
		
		try {
			is = request.getInputStream();
			int i= -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			while ((i = is.read()) != -1) {  
			    baos.write(i);  
			}  
			 content = baos.toString();  
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		log.info("收到的数据是:"+content);
		JSONObject jsonObject =JSONUtil.parseObject(content);
		
		String magic = jsonObject.getString("magic");
		String mac = jsonObject.getString("mac");
		int opcode = jsonObject.getIntValue("opcode");
		int code = jsonObject.getIntValue("code");
	
		int len = jsonObject.getIntValue("len");  
		int device_user = jsonObject.getIntValue("device_user");
		int sys = jsonObject.getIntValue("sys");					//高压
		int dia = jsonObject.getIntValue("dia");					//低压
		int pulse=jsonObject.getIntValue("pulse");			//脉搏
		int arrhythmia = jsonObject.getIntValue("arrhythmia");					//心率不齐
		String at = jsonObject.getString("at");						//测量时间
		int timestamp	= jsonObject.getIntValue("timestamp");					//时间戳
		
		BloodPressureInfo blood = new BloodPressureInfo();
		blood.setHeartRate(pulse);
		blood.setHighBP(sys);
		blood.setLowBP(dia);
		blood.setArrhythmia(arrhythmia);
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-mm-ddhh:mm:ss " );
		Date recodeTime=null;
		try {
			recodeTime = sdf.parse(at);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blood.setRecordTime(recodeTime);
//		int userId =machineRelationService.getUser(mac, device_user);
		blood.setUserId(200000014);
		
	
		//保存数据
		bloodPressureInfoService.addInfo(blood);
		
		
		MachineBloodResponse responseCode = new MachineBloodResponse();
		responseCode.setMagic(magic);
		responseCode.setMac(mac);
		responseCode.setOpcode(opcode);
		responseCode.setCode(code);
		responseCode.setReturn_code(0);
		responseCode.setTimestamp(timestamp);
		responseCode.setLen(len);
		
		
		JSONObject json = new JSONObject();
		json.put("timestamp", timestamp);
		json.put("magic", magic);
		json.put("mac", mac);
		json.put("code", code);
		json.put("len", len);
		json.put("return_code", 0);
		json.put("opcode", 6);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{\"timestamp\":").append(timestamp).append(",\"magic\":\"").
		append(magic).append("\",\"mac\":\"").append(mac).
		append("\",\"code\":").append(code).append(",\"len\":").
		append(len).append(",\"return_code\":").append(0).append(",\"opcode\":").append(6).append("}");
		
		response.setContentType("application/octet-stream;charset=UTF-8");
		
		response.setDateHeader("Date", new Date().getTime());
		String result2 =JSON.toJSONString(responseCode);
		String result = sb.toString();
		log.info("转换后的字符串是: "+result);
		return  result;
	/*
		log.info("转换后的字符串是: "+result);
	
		ByteArrayInputStream in = new ByteArrayInputStream(result.getBytes());
		
	
		 try {
			os = response.getOutputStream();
			byte[] b =  new byte[1024];
	 		int z;
	 		while( (z=in.read(b,0,b.length))!= -1){ 
	 		os.write(b,0,z);     
	 		}
	 		in.close(); 
	 		os.flush();
	 		os.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
 */
		
	}
	
	
	/*
	 *  血压计心跳请求
	 * */
	@RequestMapping(value="reg")
	@ResponseBody
	public String reg(HttpServletRequest request,HttpServletResponse response){
		String content=null;
	 	OutputStream os = null;
		InputStream is = null;
		try {
			is = request.getInputStream();
			int i= -1;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();  
			while ((i = is.read()) != -1) {  
			    baos.write(i);  
			}  
			 content = baos.toString();  
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("上传数据为:"+content);	  
		JSONObject jsonObject =JSONUtil.parseObject(content);
		String magic = jsonObject.getString("magic");
		int len = jsonObject.getIntValue("len");  
		String mac = jsonObject.getString("mac");
		int opcode = jsonObject.getIntValue("opcode");
		int code = jsonObject.getIntValue("code");
		
		String product_name = jsonObject.getString("product_name");
		String hw_ver = jsonObject.getString("hw_ver");
		String fw_ver = jsonObject.getString("fw_ver");
		String ip = jsonObject.getString("ip");
		String port = jsonObject.getString("port");
	
		
	
		RegisterResponse responseCode = new RegisterResponse();
		responseCode.setMagic(magic);
		responseCode.setMac(mac);
		responseCode.setOpcode(opcode);
		responseCode.setCode(code);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-ddhh:mm:ss");  
		java.util.Date date=new java.util.Date();  
		String str=sdf.format(date);
		responseCode.setDate(str);
		
		responseCode.setReturn_code(0);
		
		response.setContentType("application/json;charset=UTF-8");	
		response.setDateHeader("Date", new Date().getTime());
		String result =JSON.toJSONString(responseCode);
		return result;
		/*
		ByteArrayInputStream in = new ByteArrayInputStream(result.getBytes());
		System.out.println("转换后的字符串是:"+result);
		 try {
			os = response.getOutputStream();
			byte[] b =  new byte[1024];
	 		int z;
	 		while( (z=in.read(b,0,b.length))!= -1){ 
	 		os.write(b,0,z);     
	 		}
	 		in.close(); 
	 		os.flush();
	 		os.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		} */
	}

	
}
