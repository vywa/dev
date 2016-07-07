package com.hengyun.controller.im;

import javax.net.ssl.TrustManager;
import javax.security.cert.CertificateException;
import javax.security.cert.X509Certificate;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 下午5:51:38
* 类说明
*/
public class TrustAnyTrustManager implements TrustManager {

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			   throws CertificateException {
			  
			 }

			 public void checkServerTrusted(X509Certificate[] chain, String authType)
			   throws CertificateException {
			  
			 }

			 public X509Certificate[] getAcceptedIssuers() {
			  return null;
			 }
}
