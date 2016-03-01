package com.hengyun.util.system;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:13:23
* 系统版本
*/
public final class VERSION {

	public  final static int MajorVersion = 0;
	public final static int MinorVersion = 0;
	public final static int ReversionVersion=2;
	
	public static String getVersionNumber(){
		return VERSION.MajorVersion+"."+VERSION.MinorVersion+"."+VERSION.ReversionVersion;
	}
	
}
