package com.hengyun.util.regex;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年6月20日 上午9:18:49
* 类说明
*/
public class HexStrXOR {

	public  static String xor(String str1, String str2) {
		StringBuffer sb = new StringBuffer();
		int len1 = str1.length(), len2 = str2.length();
		int i = 0, index = 0;
		if(len2 > len1 ) {
		index = len2 - len1;
			while(i ++ < len2 - len1) {
			sb.append(str2.charAt(i-1));
			str1 = "0" + str1;
			}
		} else if(len1 > len2) {
			index = len1 - len2;
			while(i ++ < len1 - len2) {
			sb.append(str1.charAt(i-1));
			str2 = "0" + str2;
			}
		}
		int len = str1.length();
		while(index < len) {
			int j = (Integer.parseInt(str1.charAt(index)+"", 16) ^ Integer.parseInt(str2.charAt(index)+"", 16)) & 0xf;
			sb.append(Integer.toHexString(j));
			index ++;
		}
		return sb.toString();
	}
}
