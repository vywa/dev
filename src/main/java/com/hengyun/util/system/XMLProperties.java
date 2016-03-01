package com.hengyun.util.system;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月29日 上午10:42:35
* 配置文件
*/
public class XMLProperties {

	private static final Logger log = LoggerFactory.getLogger(XMLProperties.class);
	
	private static final String  ENCRIPTED_ATTRIBUTE = "encrypted";
	
	private File file;
	private Document document;
	
	private Map<String,String> properties = new HashMap<String,String>();
	
	
	
	
}
