package com.hengyun.util.network;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.Enumeration;


/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年3月26日 上午8:56:00
* 网络信息工具类
*/
public class NetworkUtil {

	/** 
     * 获取本机所有IP 
     */  
	 public static String getPhysicalHostIP() {  
	        String res =null;
	        Enumeration netInterfaces;  
	        try {  
	            netInterfaces = NetworkInterface.getNetworkInterfaces();  
	            InetAddress ip = null;  
	            while (netInterfaces.hasMoreElements()) {  
	                NetworkInterface ni = (NetworkInterface) netInterfaces  
	                        .nextElement();  
	                if (ni.isLoopback() ) {
	                    continue;
	                }
	                Enumeration nii = ni.getInetAddresses();  
	                while (nii.hasMoreElements()) {  
	                    ip = (InetAddress) nii.nextElement();             
	                       res = ip.getHostName();
	                    }  
	                }  
	            
	        } catch (SocketException e) {  
	            e.printStackTrace();  
	        }  
	     return res;
	    }  
	 
}
