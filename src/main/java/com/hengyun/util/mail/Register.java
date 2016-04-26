package com.hengyun.util.mail;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月26日 下午3:30:00
* 注册模板
*/
public class Register {

	public static String register(String email,String code){
		StringBuilder builder = new StringBuilder();  
		String url = "http://123.56.200.202/healthcloudserver/account/mail?email="+email;
        builder.append("<html><head>");  
        builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />");  
        builder.append("</head><body>");  
        builder.append("您好，").append(email).append("：<br />");  
        builder.append("\t欢迎注册天衡医疗会员，下面是你的验证码<font color=red>").append(code).append("</font>：<br />");  
        builder.append("用户账户：").append(email).append("<br />用户密码：123456<br />您可以点击以下链接登录系统：");  
        builder.append("<a href=\"");  
        builder.append(url);  
        builder.append("\">");  
        builder.append("点我注册");  
        builder.append("</a>");  
        builder.append("</body></html>");  
        String htmlContent = builder.toString();  
        return htmlContent;
	}
}
