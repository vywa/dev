package com.hengyun.controller.im;

import java.util.List;

import org.weixin4j.Data;
import org.weixin4j.Followers;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.message.OutputMessage;
import org.weixin4j.message.normal.ImageInputMessage;
import org.weixin4j.message.normal.LinkInputMessage;
import org.weixin4j.message.normal.LocationInputMessage;
import org.weixin4j.message.normal.ShortVideoInputMessage;
import org.weixin4j.message.normal.TextInputMessage;
import org.weixin4j.message.normal.VideoInputMessage;
import org.weixin4j.message.normal.VoiceInputMessage;
import org.weixin4j.message.output.TextOutputMessage;
import org.weixin4j.spi.INormalMessageHandler;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月6日 下午4:24:28
* 通常消息处理
*/
public class MyINormalMessageHandler implements INormalMessageHandler{

	@Override
	public OutputMessage textTypeMsg(TextInputMessage msg) {
		// TODO Auto-generated method stub
			String content = msg.getContent();
		  TextOutputMessage textMessage = new TextOutputMessage();  
		  
		  if(content.startsWith("翻译")){
          	String keyword = content.replaceAll("^翻译", "").trim();
          	if("".equals(keyword)){
          		textMessage.setContent(BaudiTranslate.getTranslateUsage());
          	} else {
          		try {
					textMessage.setContent(BaudiTranslate.translate(keyword, "zh", "en"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
          	}
          } else if(content.startsWith("关注者")){
        	  Weixin weixin;
			try {
				weixin = WeixinManager.getWeixin();
			
              //接下来就可以调用Weixin对象的其他方法了  
              //3.获取关注者列表  
              Followers followers = weixin.getUserList(null);  
              
              //打印：关注者总数  
              StringBuilder sb = new StringBuilder();
              sb.append("关注者总数：" + followers.getTotal());
          
              //打印：本次获取关注者记录数量  
           //   System.out.println("本次获取关注者数量：" + followers.getCount());  
              //打印：关注者openId数据  
              Data data = followers.getData();  
              textMessage.setContent(sb.toString());
			} catch (WeixinException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			textMessage.setContent("暂时没有关注者");
          }
          else {
        	  textMessage.setContent("你发送的文字是: "+content);
          }
		  return textMessage;
	}

	@Override
	public OutputMessage imageTypeMsg(ImageInputMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
		// TODO Auto-generated method stub
		String content = msg.getRecognition();
		 TextOutputMessage textMessage = new TextOutputMessage();  
		 textMessage.setContent(content);
		return textMessage;
	}

	@Override
	public OutputMessage videoTypeMsg(VideoInputMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage locationTypeMsg(LocationInputMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputMessage linkTypeMsg(LinkInputMessage msg) {
		// TODO Auto-generated method stub
		return null;
	}

}
