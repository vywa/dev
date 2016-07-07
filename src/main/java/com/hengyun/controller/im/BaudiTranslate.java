package com.hengyun.controller.im;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.hengyun.util.encrypt.MD5Util;




/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 下午3:42:22
* 类说明
*/
public class BaudiTranslate {

	   private static final String UTF8 = "utf-8";

       //申请者开发者id，实际使用时请修改成开发者自己的appid
       private static final String appId = "20160704000024543";

       //申请成功后的证书token，实际使用时请修改成开发者自己的token
       private static final String token = "uGc89L08hFjYu_njVQ2U";

       private static final String url = "http://api.fanyi.baidu.com/api/trans/vip/translate";

       //随机数，用于生成md5值，开发者使用时请激活下边第四行代码
       private static final Random random = new Random();

	
       public static String translate(String q, String from, String to) throws Exception{
           //用于md5加密
          int salt = random.nextInt(10000);
           //本演示使用指定的随机数为1435660288
          // int salt = 1435660288;

           // 对appId+源文+随机数+token计算md5值
           StringBuilder md5String = new StringBuilder();
           md5String.append(appId).append(q).append(salt).append(token);
           String md5 =  DigestUtils.md5Hex(md5String.toString());


           //使用Post方式，组装参数
           HttpClient httpClient = null;  
           HttpPost httpPost = null;  
           String result = null;  
           
           HttpPost httpost = new HttpPost(url);
           List<NameValuePair> nvps = new ArrayList<NameValuePair>();
           
         
           	nvps.add(new BasicNameValuePair("q", q));
              nvps.add(new BasicNameValuePair("from", from));
              nvps.add(new BasicNameValuePair("to", to));
              nvps.add(new BasicNameValuePair("appid", appId));
              nvps.add(new BasicNameValuePair("salt", String.valueOf(salt)));
              nvps.add(new BasicNameValuePair("sign", md5));
        //   httpost.setEntity(new UrlEncodedFormEntity((Iterable<? extends org.apache.http.NameValuePair>) nvps, Consts.UTF_8));
              httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8)); 
           //创建httpclient链接，并执行
             CloseableHttpClient httpclient = HttpClients.createDefault();
             CloseableHttpResponse response = httpclient.execute(httpost);

       //对于返回实体进行解析
           HttpEntity entity = (HttpEntity) response.getEntity();
           InputStream returnStream = ((org.apache.http.HttpEntity) entity).getContent();
           BufferedReader reader = new BufferedReader(
                           new InputStreamReader(returnStream, UTF8));
           StringBuilder result2 = new StringBuilder();
           String str = null;
           while ((str = reader.readLine()) != null) {
                   result2.append(str).append("\n");
           }

           //转化为json对象，注：Json解析的jar包可选其它
           JSONObject resultJson = JSON.parseObject(result2.toString());
           //开发者自行处理错误，本示例失败返回为null
           try {
                   String error_code = resultJson.getString("error_code");
                   if (error_code != null) {
                           System.out.println("出错代码:" + error_code);
                           System.out.println("出错信息:" + resultJson.getString("error_msg"));
                           return null;
                   }
           } catch (Exception e) {}

           //获取返回翻译结果
           JSONArray array = (JSONArray) resultJson.get("trans_result");
           JSONObject dst = (JSONObject) array.get(0);
           String text = dst.getString("dst");
           text = URLDecoder.decode(text, UTF8);

           return text;
   }

	   //实际抛出异常由开发者自己处理
	   public static  String translateToEn(String q) throws Exception{
		   /*
	           ApplicationContext container=new FileSystemXmlApplicationContext("src//spring//resource//baidu.xml");
	           BaiduTranslateDemo baidu = (BaiduTranslateDemo)container.getBean("baidu");
	
	           String result = null;
	           try {
	                   result = baidu.translate(q, "zh", "en");
	           } catch (Exception e) {
	                   e.printStackTrace();
	           }
	
	           return result;

	*/
		   return null;
       }
       
	/** 
     * utf编码 
     *  
     * @param source 
     * @return 
     */  
    public static String urlEncodeUTF8(String source) {  
        String result = source;  
        try {  
            result = java.net.URLEncoder.encode(source, "utf-8");  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return result;  
    }  
    
    /** 
     * 翻译（中->英 英->中 日->中 ） 
     *  
     * @param source 
     * @return 
     */  
    public static String transEnTo(String source) {  
        String dst = null;  
  
        // 组装查询地址  
     //    String BaiduTrans = "http://openapi.baidu.com/public/2.0/bmt/translate";  
         String BaiduTrans = "http://fanyi.baidu.com/#en/zh/";
          String Client_id = " 20160704000024543";  
          // path: http://fanyi.baidu.com/#en/zh/  
          String keyword = null;
          String str = null;
          try {  
              // 对中文字符进行编码,否则传递乱码  
        	  keyword = URLEncoder.encode(source, "utf-8");  
              URL url = new URL(BaiduTrans + "?client_id=" + Client_id + "&q="  
                      + source + "&from=auto&to=zh");  
              URLConnection con = url.openConnection();  
              con.connect();  
              InputStreamReader reader = new InputStreamReader(  
                      con.getInputStream());  
              BufferedReader bufread = new BufferedReader(reader);  
              StringBuffer buff = new StringBuffer();  
              String line;  
              while ((line = bufread.readLine()) != null) {  
                  buff.append(line);  
              }  
              // 对字符进行解码  
              String back = new String(buff.toString().getBytes("ISO-8859-1"),  
                      "UTF-8");  
               str = JsonToString(back);  
             
              reader.close();  
              bufread.close();  
          } catch (Exception e) {  
              // TODO Auto-generated catch block  
              e.printStackTrace();  
          }  
        return str;  
    }  
    
    /**  
     * 获取jsoon中翻译的内容  
     *   
     * @param jstring  
     * @return  
     */  
    private static String JsonToString(String jstring) {  
        try {  
            JSONObject obj = JSON.parseObject(jstring);
            JSONArray array = obj.getJSONArray("trans_result");
            obj = array.getJSONObject(0);  
            String word = obj.getString("dst");  
            return word;  
        } catch (JSONException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return "";  
    }  
  
    public static String getTranslateUsage() {  
        StringBuffer buffer = new StringBuffer();  
        // buffer.append(XiaoqUtil.emoji(0xe148)).append("Q译通使用指南").append("\n\n");  
        buffer.append("Q译通为用户提供专业的多语言翻译服务，目前支持以下翻译方向：").append("\n");  
        buffer.append("    中 -> 英").append("\n");  
        buffer.append("    英 -> 中").append("\n");  
        buffer.append("    日 -> 中").append("\n\n");  
        buffer.append("使用示例：").append("\n");  
        buffer.append("    翻译我是中国人").append("\n");  
        buffer.append("    翻译dream").append("\n");  
        buffer.append("    翻译さようなら").append("\n\n");  
        buffer.append("回复“?”显示主菜单");  
        return buffer.toString();  
    }  
}
