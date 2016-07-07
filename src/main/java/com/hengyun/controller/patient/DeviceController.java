package com.hengyun.controller.patient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.domain.common.ResponseCode;
import com.hengyun.domain.patient.BloodPressureInfo;
import com.hengyun.domain.patient.MachineBloodResponse;
import com.hengyun.domain.patient.RegisterResponse;
import com.hengyun.domain.patient.SNMacRelation;
import com.hengyun.service.logininfo.LoginInfoCacheService;
import com.hengyun.service.patient.BloodPressureInfoService;
import com.hengyun.service.patient.MachineRelationService;
import com.hengyun.service.patient.SNMacRelationService;
import com.hengyun.util.network.NetworkUtil;
import com.hengyun.util.regex.HexStrXOR;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年5月13日 下午5:02:37
* 类说明
*/
@Controller

public class DeviceController {

	  @Resource
      private SNMacRelationService snMacRelationService;

      @Resource
      private MachineRelationService machineRelationService;

      @Resource
      private BloodPressureInfoService bloodPressureInfoService;
      
      @Resource
      private LoginInfoCacheService loginInfoCacheService;

      private static Logger log = LoggerFactory.getLogger(DeviceController.class);

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
              JSONObject jsonObject =JSON.parseObject(content);

              String magic = jsonObject.getString("magic");
              String mac = jsonObject.getString("mac");
              int opcode = jsonObject.getIntValue("opcode");
              int code = jsonObject.getIntValue("code");
              int timestamp = jsonObject.getIntValue("timestamp");
              int len = jsonObject.getIntValue("len");


              int device_user = jsonObject.getIntValue("device_user");
              int sys = jsonObject.getIntValue("sys");
              int dia = jsonObject.getIntValue("dia");
              int pulse=jsonObject.getIntValue("pulse");
              int arrhythmia = jsonObject.getIntValue("arrhythmia");
              String at = jsonObject.getString("at");
         //     MachineBlood mbt = JSON.toJavaObject(jsonObject, MachineBlood.class);
              /*
              mbt.setMac(mac);
              mbt.setMagic(magic);
              mbt.setOpcode(opcode);
              mbt.setCode(code);
              mbt.setTimestamp(timestamp);
              mbt.setLen(len);
              mbt.setArrhythmia(arrhythmia);
              mbt.setAt(at);
              mbt.setDia(dia);
              mbt.setDevice_user(device_user);
              mbt.setPulse(pulse);
              mbt.setSys(sys);*/
              String sn = snMacRelationService.getSN(mac);
              int userId = machineRelationService.getUser(sn, device_user);

       //       machineService.save(mbt);
              BloodPressureInfo bpi = new BloodPressureInfo();
              bpi.setUserId(userId);
              bpi.setArrhythmia(arrhythmia);
              bpi.setHeartRate(pulse);
              bpi.setHighBP(sys);
              bpi.setLowBP(dia);
              //bpi.setMeasureTime(measureTime);
              //  bloodPressureInfoService.addInfo(bpi);
              log.info("上传时间: "+at);
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              Date recodeTime=null;
             
                      try {
						recodeTime = sdf.parse(at);
						
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                      bpi.setMeasureTime(recodeTime.getTime());
             // bpi.setRecordTime(recodeTime);
              //添加血压数据
              bloodPressureInfoService.addInfo(bpi);
              
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
            
              String result = sb.toString();
              log.info("转换后的字符串是: "+result);
              return  result;
    

      }
      
   
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
         
              JSONObject jsonObject =JSON.parseObject(content);
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
              
              String sn = snMacRelationService.getSN(mac);
              int userId = machineRelationService.getUser(sn, 1);
              int userId2 = machineRelationService.getUser(sn, 2);
              if(userId>0){
            	  loginInfoCacheService.deviceState(userId, sn);
              }
              if(userId2>0){
            	  loginInfoCacheService.deviceState(userId2, sn);
              }
              
              RegisterResponse responseCode = new RegisterResponse();
              responseCode.setMagic(magic);
              responseCode.setMac(mac);
              responseCode.setOpcode(opcode);
              responseCode.setCode(code);
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
              java.util.Date date=new java.util.Date();
              String str=sdf.format(date);
              responseCode.setDate(str);

              responseCode.setReturn_code(0);

              response.setContentType("application/json;charset=UTF-8");
              response.setDateHeader("Date", new Date().getTime());
              String result =JSON.toJSONString(responseCode);
              return result;

      }
      
      @RequestMapping(value="insert",produces = "text/html;charset=UTF-8")
      @ResponseBody
      public String insert(@RequestParam String data,HttpServletRequest request){
    	   JSONObject jsonObject =JSON.parseObject(data);
    	   SNMacRelation snMacRelation = JSON.toJavaObject(jsonObject, SNMacRelation.class);
    	   snMacRelationService.add(snMacRelation);
    	   ResponseCode response = new ResponseCode();
    	   response.setCode("206");
    	   response.setMessage("添加成功");
             String result =JSON.toJSONString(response);
              return result;

      }
      
      @RequestMapping(value="query",produces = "text/html;charset=UTF-8")
      @ResponseBody
      public String query(@RequestParam String data,HttpServletRequest request){
    	   JSONObject jsonObject =JSON.parseObject(data);
    	  String mac = jsonObject.getString("mac");
    	   String sn = snMacRelationService.getSN(mac);
    	   ResponseCode response = new ResponseCode();
    	   response.setCode("206");
    	   response.setMessage(sn);
             String result =JSON.toJSONString(response);
              return result;

      }
      
      /*
       *  仪器上传血压血糖数据
       * */
      @RequestMapping(value="upload",produces = "text/html;charset=UTF-8")
      @ResponseBody
      public String upload(HttpServletRequest request){
    	  String data = request.getParameter("data");
    	  String start = data.substring(0,2);										//起始码
    	  String ver = data.substring(2,4);											//版本号
    	  String user = data.substring(4, 5);										//用户号
    	  String customer = data.substring(5,7);							//客户码
    	  String modelCode = data.substring(7,9);						//机型代码
    	  String deviceType= data.substring(9,11);						//机种码
    	  String serialNum = data.substring(11, 20);						//系列号
    	  String sum = data.substring(39, 43);								//校验码
    	  String imsi = data.substring(44, 59);									//标志卡
    	  String ll = data.substring(60, 85);										//经纬度
    	  String date = data.substring(29,39);									//日期
    	  
    	  log.info("起始码: "+start+"版本号: "+ver+"用户号: "+user+"客户码: "+customer+"\n机型代码: "+
    	  modelCode+"机种码: "+deviceType+"系列号: "+serialNum+"校验码: "+sum+"卡标识: "+imsi+"经纬度: "+ll+"日期: "+date);
    	  
    	  //10为kpa显示
    	  
    	  switch(deviceType){
    	  case "01":
    		  String sys = data.substring(20, 23);								//高压
        	  String dia = data.substring(23, 26);								//低压
        	  String pul = data.substring(26, 29);								//心率
        	  log.info("高压为: "+sys+"低压为: "+dia+"心率为: "+pul);
        	  
    		  break;
    	  
    	  case "02":
    		  String value= data.substring(26, 29);
    		  log.info("血糖为: "+value);
    		  break;
    	  default:break;
    	  }
    	  StringBuilder result =new StringBuilder();
    	  String ipStr = getIP();
    	  String sum1 = getSum1();
    	  String dateStr = getDate();
    	  String sum2 = getSum2();
    	  result.append("+IP"+ipStr+"5000"+sum1+dateStr+sum2+"OK");
          return result.toString();

      }
  
      /*
       *  获取ip字符串
       * */
      private String getIP(){
    	  String ip = NetworkUtil.getPhysicalHostIP();
		  String[] IP = ip.split("\\.");
		  StringBuffer buffer = new StringBuffer();
		  for(int i=0;i<4;i++){
			 
			  buffer.append(HexStrXOR.xor("00",Integer.toHexString(Integer.valueOf(IP[i]))).toUpperCase());		//转换ip字符
		  }
		 return buffer.toString();		//转换新的ip字符
    	 
      }
      
      /*
       *  获取第一个验证码
       * */
      private String getSum1(){
    	  
    	  String sum1 ="00";
    	  String ip = NetworkUtil.getPhysicalHostIP();
		  String[] IP = ip.split("\\.");
		  for(int i=0;i<4;i++){
			  sum1= HexStrXOR.xor(sum1, Integer.toHexString(Integer.valueOf(IP[i])));
		  }
		  sum1 =  HexStrXOR.xor(sum1, "50");
		 // sum1 =  HexStrXOR.xor(sum1, "4E");
		  sum1 = HexStrXOR.xor(sum1, "00");
		  //sum1 = HexStrXOR.xor(sum1, "1F");
    	  return sum1.toUpperCase();
      }
      
      
      /*
       *  获取日期字符串
       * */
      private String getDate(){
    	  Date now = new Date();  
		  String year = HexStrXOR.xor("00",Integer.toHexString(now.getYear()%100)).toUpperCase();
		  String month = HexStrXOR.xor("00",Integer.toHexString(now.getMonth()+1)).toUpperCase();
		  String day =  HexStrXOR.xor("00", Integer.toHexString(now.getDate())).toUpperCase();
		  String hour = HexStrXOR.xor("00",Integer.toHexString(now.getHours())).toUpperCase();
		  String minute = HexStrXOR.xor("00",Integer.toHexString(now.getMinutes())).toUpperCase();
		  String date2 = year+month+day+hour+minute;									//计算日期
    	  return date2.toUpperCase();
      }
      
      /*
       *  获取第二个校验码
       * */
      private String getSum2(){
    	  
    	  Date now = new Date();
    	  String year = HexStrXOR.xor("00",Integer.toHexString(now.getYear()%100)).toUpperCase();
		  String month = HexStrXOR.xor("00",Integer.toHexString(now.getMonth()+1)).toUpperCase();
		  String day =  HexStrXOR.xor("00", Integer.toHexString(now.getDate())).toUpperCase();
		  String hour = HexStrXOR.xor("00",Integer.toHexString(now.getHours())).toUpperCase();
		  String minute = HexStrXOR.xor("00",Integer.toHexString(now.getMinutes())).toUpperCase();
		  
    	  String sum2="00";	
    	  sum2 = HexStrXOR.xor(sum2,year);
		  sum2 = HexStrXOR.xor(sum2,month);
		  sum2 = HexStrXOR.xor(sum2,day);
		  sum2 = HexStrXOR.xor(sum2,hour);
		  sum2 = HexStrXOR.xor(sum2,minute);
    	  return sum2.toUpperCase();
      }
}
