package com.hengyun.util.mail;

import javax.mail.internet.MimeMessage;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SimpleMail {

 	private JavaMailSender javaMailSender;
    
    private SimpleMailMessage simpleMailMessage;
	
	 public void sendMail(String subject, String content, String to) {
	        
		
	        try {
	            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	         
	            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);
	            messageHelper.setFrom(simpleMailMessage.getFrom()); //设置发件人Email
	            messageHelper.setSubject(subject); //设置邮件主题
	            messageHelper.setText(content);   //设置邮件主题内容
	            messageHelper.setTo(to);          //设定收件人Email
	          /**
	             * ClassPathResource：很明显就是类路径资源,我这里的附件是在项目里的,所以需要用ClassPathResource
	             * 如果是系统文件资源就不能用ClassPathResource,而要用FileSystemResource,例：
	             * FileSystemResource file = new FileSystemResource(new File("D:/Readme.txt"));
	             */
	        //    ClassPathResource file = new ClassPathResource("attachment/Readme.txt");
	          /**
	             * MimeMessageHelper的addAttachment方法：
	             * addAttachment(String attachmentFilename, InputStreamSource inputStreamSource)
	             * InputStreamSource是一个接口,ClassPathResource和FileSystemResource都实现了这个接口
	             */
	           // messageHelper.addAttachment(file.getFilename(), file); //添加附件
	            javaMailSender.send(mimeMessage);    //发送附件邮件
	            
	        } catch (Exception e) {System.out.println("异常信息：" + e);}
	    }
	    
	    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
	        this.simpleMailMessage = simpleMailMessage;
	    }
	      
	    public void setJavaMailSender(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }
}
