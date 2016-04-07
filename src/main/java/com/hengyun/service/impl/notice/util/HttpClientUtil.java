package com.hengyun.service.impl.notice.util;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月23日 下午4:44:19
* 客户代理
*/
public class HttpClientUtil {

	public static void main(String[] args){
		String hehe = "noticeId=123&noticeToId=123&noticeFromeId=321";
		String ni = "?bob=bob";
		try {
			HttpClientUtil.doGet(ni);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
private static String url = "http://192.168.31.114:9090/plugins/httpService/httpservice?data=";
	
	/*
	 *  生成请求字符串
	 * */
	
	public static int doGet(String data)
		      throws Exception {
		    HttpClient httpClient = new HttpClient();
		
		    httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		    String data2 = data.toString();
		   
	//	   HttpMethod getMethod = getMethod(url, data2);
		    GetMethod getMethod = new GetMethod(url+data2); 
		    System.out.println(getMethod.getPath()+getMethod.getQueryString());
		    int statusCode=0;
		  
		    try {
		       statusCode = httpClient.executeMethod(getMethod);
		 
		      if (statusCode != HttpStatus.SC_OK) {
		        System.err.println("请求出错: "+ getMethod.getStatusLine());
		      } else {
		    	  
		    	  System.out.println("请求发送成功"+statusCode);
		      }
		   
		
		    } catch (HttpException e) {
		     
		      System.out.println("请检查输入的URL!");
		      e.printStackTrace();
		    } catch (IOException e) {
		   
		      System.out.println("发生网络异常!");
		      e.printStackTrace();
		    } finally {
		    
		    	getMethod.releaseConnection();
		    }
		    return statusCode;
		  }

	 private static HttpMethod getMethod(String url,String param) throws IOException{  
	        GetMethod get = new GetMethod(url+"?"+param); 
	        
	        get.releaseConnection();  
	        return get;  
	    }  
}
