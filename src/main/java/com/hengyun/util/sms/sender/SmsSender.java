package com.hengyun.util.sms.sender;



import java.rmi.RemoteException;

import com.hengyun.util.sms.SmsSoap;
import com.hengyun.util.sms.SmsSoapProxy;
import com.hengyun.util.sms.SubmitResult;




/*
 *  AXIS 调用远程的web service
 * */
public class SmsSender {

	
	
	//private String endpoint ="http://106.ihuyi.cn/webservice/sms.php?";

	
	private final String account = "cf_171274409";
	private final String password="Hy_bob_2016";
	private String mobile;
	private int num;
	private String content;
	
	
	public SmsSender(String mobile, int num) {
		super();
		this.mobile = mobile;
		this.num = num;
		this.content = "您的验证码是："+this.getNum()+"。请不要把验证码泄露给其他人。";
	}
	
	
	public SmsSender() {
		super();
	}


	public  SubmitResult  send(){
		
		SmsSoapProxy  proxy = new SmsSoapProxy();
         //proxy.setEndpoint("");  
         //换成获取对应的serice  
		SmsSoap service =  proxy.getSmsSoap();
         //调用web service提供的方法  
		SubmitResult result;
		try {
			result = service.submit(account, password, mobile, content);
			 System.out.println("消息返回码为：　"+result.getCode()+"消息类型为：　"+result.getMsg());  
			 return result;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
           
        return null;
      
		
	}
	

	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
