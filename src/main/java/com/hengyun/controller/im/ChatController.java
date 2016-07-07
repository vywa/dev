package com.hengyun.controller.im;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.WeixinException;
import org.weixin4j.spi.HandlerFactory;
import org.weixin4j.spi.IMessageHandler;
import org.weixin4j.util.TokenUtil;

import com.hengyun.dao.impl.RedisClientTemplate;
import com.hengyun.domain.im.Article;
import com.hengyun.domain.im.NewsMessage;
import com.hengyun.domain.im.TextMessage;
import com.hengyun.util.encrypt.SHA1;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午9:39:24
* 类说明
*/
@Controller
@RequestMapping("chat")
public class ChatController {

	private static final Logger log = LoggerFactory.getLogger(ChatController.class);
	private static String Token = "baoanweixin";

	@Resource
	private RedisClientTemplate redisClientTemplate;

	   @RequestMapping(value = "menu", method = { RequestMethod.GET, RequestMethod.POST })  
	    @ResponseBody  
	    public void menu(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {  
	     
		   MenuUtil.createMenu();
	   }
	
	    @RequestMapping(value = "receive", method = { RequestMethod.GET, RequestMethod.POST })  
	    @ResponseBody  
	    public void receive(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {  
	     
	        boolean isGet = request.getMethod().toLowerCase().equals("get");  
	        if (isGet) {  
	            String signature = request.getParameter("signature");  
	            String timestamp = request.getParameter("timestamp");  
	            String nonce = request.getParameter("nonce");  
	            String echostr = request.getParameter("echostr");  
	            log.info("收到的字符为: "+signature+" "+timestamp+" "+nonce+" "+echostr);
	            String token = TokenUtil.get();
	            if (TokenUtil.checkSignature(token, signature, timestamp, nonce)) {
	                response.getWriter().write(echostr);
	            }
	        } else {  
	            // 进入POST聊天处理  
	        	// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
	            request.setCharacterEncoding("UTF-8");  
	            response.setCharacterEncoding("UTF-8");
	            response.setContentType("text/xml");
	         
	          //获取POST流
	            ServletInputStream in = request.getInputStream();
	            PrintWriter out = response.getWriter();  
	            
	          //处理输入消息，返回结果
	            IMessageHandler messageHandler = MyHandlerFactory.getMessageHandler();
	            //处理输入消息，返回结果
	            String xml;
				try {
					xml = messageHandler.invoke(in);
				    //返回结果
		            response.getWriter().write(xml);
				} catch (WeixinException e) {
					// TODO Auto-generated catch block
					 response.getWriter().write("");
				}
	            	//  InputStream inputStream = request.getInputStream();  
		                // 调用核心服务类接收处理请求  
		               // String respXml =handle(inputStream);  
		               // out.print(respXml);  

	        }  
	    }  
	
	    /*
	     * 处理微信发来的请求
	     * */
	    private static String handle(InputStream inputStream){
	    	Date utilDate = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	        String str = sdf.format(utilDate);
	        
	     // xml格式的消息数据  
	        String respXml = null;  
	        // 默认返回的文本消息内容  
	        String respContent = "未知的消息类型！";  
	        
	        try {  
	            // 调用parseXml方法解析请求消息  
	            Map<String, String> requestMap = MessageUtil.parseXml(inputStream);  
	            // 发送方帐号  
	            String fromUserName = requestMap.get("FromUserName");  
	            // 开发者微信号  
	            String toUserName = requestMap.get("ToUserName");  
	            // 消息类型  
	            String msgType = requestMap.get("MsgType");  
	  
	            // 回复文本消息  
	            TextMessage textMessage = new TextMessage();  
	            textMessage.setToUserName(fromUserName);  
	            textMessage.setFromUserName(toUserName);  
	            textMessage.setCreateTime(new Date().getTime());  
	            textMessage.setMsgType(MessageUtil.MESSAGE_TYPE_TEXT);  
	  
	            // 文本消息  
	            if (msgType.equals(MessageUtil.MESSAGE_TYPE_TEXT)) {  
	                respContent = "您发送的是文本消息! "+fromUserName;  
	                //接收用户发送的文本消息内容
	                String content = requestMap.get("Content");
	                //创建图文消息
	                NewsMessage newsMessage = new NewsMessage();
	                newsMessage.setToUserName(fromUserName);
	                newsMessage.setFromUserName(toUserName);
	                newsMessage.setCreateTime(new Date().getTime());
	                newsMessage.setMsgType(MessageUtil.MESSAGE_TYPE_NEWS);
	                
	                List<Article> articleList = new ArrayList<Article>();
	                if(content.startsWith("翻译")){
	                	String keyword = content.replaceAll("^翻译", "").trim();
	                	if("".equals(keyword)){
	                		textMessage.setContent(BaudiTranslate.getTranslateUsage());
	                	} else {
	                		textMessage.setContent(BaudiTranslate.translate(keyword, "zh", "en"));
	                	}
	                	respContent = textMessage.getContent();
	                	textMessage.setContent(respContent);
	                	respXml = MessageUtil.messageToXml(textMessage);
	                }
	                
	                if("1".equals(content)){
	                	Article article = new Article();
	                	article.setTitle("微信公众账号开发教程");
	                	article.setDescription("可惜不是你，陪我到最后");
	                	article.setPicUrl("http://123.56.200.202/download/1463406346817temp.jpg");
	                	article.setUrl("http://finance.ifeng.com/a/20160703/14554493_0.shtml");
	                	articleList.add(article);
	                	//设置图文消息个数
	                	newsMessage.setArticleCount(articleList.size());
	                	//设置图文消息包含的图文集合
	                	newsMessage.setArticles(articleList);
	                	//将图文消息转换成xml字符串
	                	return MessageUtil.messageToXml(newsMessage);
	                } else if("2".equals(content)){		//单图文消息－－不含图片
	                	Article article = new Article();
	                	article.setTitle("微信公众帐号开发教程Java版");
	                	//图文消息可以使用qq表情，符号表情
	                	article.setDescription("目前已推出教程共12篇，包括接口配置、消息封装、"
	                			+ "框架搭建、QQ表情发送、符号表情发送等。"
	                			+ "\n\n后期还计划推出一些实用功能的开发讲解，例如：天气预报、周边搜索、聊天功能等。");
	                	//将图片设为空
	                	article.setPicUrl("");
	                	article.setUrl("http://finance.ifeng.com/a/20160703/14554493_0.shtml");
	                	articleList.add(article);
	                	newsMessage.setArticleCount(articleList.size());
	                	newsMessage.setArticles(articleList);
	                	return MessageUtil.messageToXml(newsMessage);
	                }else if("3".equals(content)){		//多图文消息
	                	Article article1 = new Article();
	                	article1.setTitle("微信公众帐号开发教程\n引言");
	                	article1.setDescription("");
	                	article1.setPicUrl("http://123.56.200.202/download/1463406346817temp.jpg");
	                	article1.setUrl("http://mil.sohu.com/20160704/n457598787.shtml?qq-pf-to=pcqq.discussion");
	                	
	                	Article article2 = new Article();
	                	article2.setTitle("第2篇\n微信公众帐号的类型");
	                	article2.setDescription("");
	                	article2.setPicUrl("http://123.56.200.202/download/sport.png");
	                	article2.setUrl("http://news.china.com.cn/live/2016-07/03/content_36407818.htm");
	                	
	                	Article article3 = new Article();
	                	article3.setTitle("关注");
	                	article3.setDescription("关注页面");
	                	article3.setPicUrl("http://123.56.200.202/download/tablet.png");
	                	article3.setUrl("http://finance.ifeng.com/a/20160703/14554588_0.shtml");
	                	
	                	articleList.add(article1);
	                	articleList.add(article2);
	                	articleList.add(article3);
	                	newsMessage.setArticleCount(articleList.size());
	                	newsMessage.setArticles(articleList);
	                	return MessageUtil.messageToXml(newsMessage);
	                	
	                }

	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_IMAGE)){	                //图片消息
	            	respContent = "你发送的是图片消息";
	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_VOICE)){					//语音消息
	            	respContent = "你发送的是语音消息";
	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_VIDEO)){					//视频消息
	            	respContent = "你发送的是视频消息";
	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_LOCATION)){			//地理位置消息
	            	respContent = "你发送的是地理位置消息";
	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_LINK)){						//链接消息
	            	respContent = "你发送的是链接消息";
	            } else if(msgType.equals(MessageUtil.MESSAGE_TYPE_EVENT)){					//事件推送
	            	//事件类型
	            	String eventType = requestMap.get("Event");
	            	if(eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){					//关注
	            		respContent = "欢迎光临爱情心路。\n这里有唯美的爱情故事，动听的音乐\n"
	            				+ "幽默的笑话，有趣的游戏\n还有更多的知识哦\n在这里我们去一起见证一个更好的自我吧!";
	            	} else if(eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){		//取消关注
	            		
	            	} else if(eventType.equals(MessageUtil.EVENT_TYPE_SCAN)){							//带参数二维码事件
	            		
	            	} else if(eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)){				//上报地理位置
	            		
	            	} else if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){							//自定义菜单
	            		
	            	}
	            }
	         
	            // 设置文本消息的内容  
	            textMessage.setContent(respContent);  
	            // 将文本消息对象转换成xml  
	            respXml = MessageUtil.messageToXml(textMessage);  
	            log.info(respXml);
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return respXml;  
		
	    	
	    }
	    
	/**  
     * 验证URL真实性  
     *   
    
     */  
    private String access(HttpServletRequest request, HttpServletResponse response) {  
        // 验证URL真实性  
       log.info("进入验证access");  
        String signature = request.getParameter("signature");// 微信加密签名  
        String timestamp = request.getParameter("timestamp");// 时间戳  
        String nonce = request.getParameter("nonce");// 随机数  
        String echostr = request.getParameter("echostr");// 随机字符串  
        List<String> params = new ArrayList<String>();  
        
        params.add(Token);  
        params.add(timestamp);  
        params.add(nonce);  
        // 1. 将token、timestamp、nonce三个参数进行字典序排序  
        Collections.sort(params, new Comparator<String>() {  
            @Override  
            public int compare(String o1, String o2) {  
                return o1.compareTo(o2);  
            }  
        });  
        // 2. 将三个参数字符串拼接成一个字符串进行sha1加密  
        String temp = SHA1.encode(params.get(0) + params.get(1) + params.get(2));  
        if (temp.equals(signature)) {  
            try {  
                response.getWriter().write(echostr);  
               log.info("成功返回 echostr：" + echostr);  
                return echostr;  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        log.info("失败 认证");  
        return null;  
    }  
  
   /*
    private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//xml格式的消息数据
    	String respXml = null;
    	//默认返回的文本消息内容
    	String context = "未知的消息类型";
    	
        // 处理接收消息  
        ServletInputStream in = request.getInputStream();  
        // 将POST流转换为XStream对象  
        XStream xs = SerializeXmlUtil.createXstream();  
        xs.processAnnotations(InputMessage.class);  
        xs.processAnnotations(OutputMessage.class);  
        // 将指定节点下的xml节点数据映射为对象  
        xs.alias("xml", InputMessage.class);  
        // 将流转换为字符串  
        StringBuilder xmlMsg = new StringBuilder();  
        byte[] b = new byte[4096];  
        for (int n; (n = in.read(b)) != -1;) {  
            xmlMsg.append(new String(b, 0, n, "UTF-8"));  
        }  
        // 将xml内容转换为InputMessage对象  
        InputMessage inputMsg = (InputMessage) xs.fromXML(xmlMsg.toString());  
  
        String servername = inputMsg.getToUserName();// 服务端  
        String custermname = inputMsg.getFromUserName();// 客户端  
        long createTime = inputMsg.getCreateTime();// 接收时间  
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间  
  
        // 取得消息类型  
        String msgType = inputMsg.getMsgType();  
        // 根据消息类型获取对应的消息内容  
        if (msgType.equals(MsgType.Text.toString())) {  
            // 文本消息  
            System.out.println("开发者微信号：" + inputMsg.getToUserName());  
            System.out.println("发送方帐号：" + inputMsg.getFromUserName());  
            System.out.println("消息创建时间：" + inputMsg.getCreateTime() + new Date(createTime * 1000l));  
            System.out.println("消息内容：" + inputMsg.getContent());  
            System.out.println("消息Id：" + inputMsg.getMsgId());  
  
            StringBuffer str = new StringBuffer();  
            str.append("<xml>");  
            str.append("<ToUserName><![CDATA[" + custermname + "]]></ToUserName>");  
            str.append("<FromUserName><![CDATA[" + servername + "]]></FromUserName>");  
            str.append("<CreateTime>" + returnTime + "</CreateTime>");  
            str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");  
            str.append("<Content><![CDATA[你说的是：" + inputMsg.getContent() + "，吗？]]></Content>");  
            str.append("</xml>");  
            System.out.println(str.toString());  
            response.getWriter().write(str.toString());  
        }  
        // 获取并返回多图片消息  
        if (msgType.equals(MsgType.Image.toString())) {  
            System.out.println("获取多媒体信息");  
            System.out.println("多媒体文件id：" + inputMsg.getMediaId());  
            System.out.println("图片链接：" + inputMsg.getPicUrl());  
            System.out.println("消息id，64位整型：" + inputMsg.getMsgId());  
  
            OutputMessage outputMsg = new OutputMessage();  
            outputMsg.setFromUserName(servername);  
            outputMsg.setToUserName(custermname);  
            outputMsg.setCreateTime(returnTime);  
            outputMsg.setMsgType(msgType);  
            ImageMessage images = new ImageMessage();  
            images.setMediaId(inputMsg.getMediaId());  
            outputMsg.setImage(images);  
            System.out.println("xml转换：/n" + xs.toXML(outputMsg));  
            response.getWriter().write(xs.toXML(outputMsg));  
  
        }  
    }  
  */
}  
	

