package com.hengyun.controller.im;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月5日 上午9:57:17
* 类说明
*/
public class MenuUtil {

	//获取accecc_token
	private static String accessToken = "jQkBTdpYOhamRmW-s7Fy4QGIMoISD1surYmkc4yCcdqi5yHKTMmmb"
			+ "WPB2AMOm5g4IWuaZWI1dCLYxTKO9bB-8sP2EckM3J8Z2YBL3-TccxI8c5FiMiMX5iZyDR2GUZFhUISjAEAHVF";
	
	private static String appid="wxd39d473aefc362de";
	private static String secret="111ee1a113017f391496465d8ff2d3bf";
	
    public static void menu(String button) throws Exception{
     
     
        String url = " https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+accessToken;
        URI uri =null;
        try{  
            URL url1 = new URL(url);   
             uri = new URI(url1.getProtocol(), url1.getHost(), url1.getPath(), url1.getQuery(), null);   
           
        }catch(Exception e){  
            e.printStackTrace();  
        }  
        
        //使用Post方式，组装参数
        HttpClient httpClient = null;  
        HttpPost httpPost = null;  
        String result = null;  
        
        HttpPost httpost = new HttpPost(uri);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        
      
        	nvps.add(new BasicNameValuePair("button", button));
        
     //   httpost.setEntity(new UrlEncodedFormEntity((Iterable<? extends org.apache.http.NameValuePair>) nvps, Consts.UTF_8));
           httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8)); 
        //创建httpclient链接，并执行
          CloseableHttpClient httpclient = HttpClients.createDefault();
          CloseableHttpResponse response = httpclient.execute(httpost);

    //对于返回实体进行解析
        HttpEntity entity = (HttpEntity) response.getEntity();
        InputStream returnStream = ((org.apache.http.HttpEntity) entity).getContent();
        BufferedReader reader = new BufferedReader(
                        new InputStreamReader(returnStream, HTTP.UTF_8));
        StringBuilder result2 = new StringBuilder();
        String str = null;
        while ((str = reader.readLine()) != null) {
                result2.append(str).append("\n");
        }

        //转化为json对象，注：Json解析的jar包可选其它
        JSONObject resultJson = JSON.parseObject(result2.toString());
        //开发者自行处理错误，本示例失败返回为null
        try {
                int error_code = resultJson.getIntValue("errcode");
                if (error_code==0) {
                        System.out.println("出错代码:" + error_code);
                        System.out.println("出错信息:" + resultJson.getString("errmsg"));
                        resultJson.getString("errmsg");
                }
        } catch (Exception e) {}

}
	
	
	 /*
	  *  生成菜单
	  * */
	 public  static void  createMenu(){
		 ClickButton cbt=new ClickButton();
		    cbt.setKey("image");
		    cbt.setName("回复图片");
		    cbt.setType("click");
		    
		    
		    ViewButton vbt=new ViewButton();
		    vbt.setUrl("http://www.cuiyongzhi.com");
		    vbt.setName("博客");
		    vbt.setType("view");
		    
		    JSONArray sub_button=new JSONArray();
		    sub_button.add(cbt);
		    sub_button.add(vbt);
		    
		    JSONObject buttonOne=new JSONObject();
		    buttonOne.put("name", "菜单");
		    buttonOne.put("sub_button", sub_button);
		    
		    JSONArray button=new JSONArray();
		    button.add(vbt);
		    button.add(buttonOne);
		    button.add(cbt);
		    
		    JSONObject menujson=new JSONObject();
		    menujson.put("button", button);
		    try {
				menu(menujson.toJSONString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
