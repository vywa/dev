package com.hengyun.controller.im;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午10:08:45
* 类说明
*/
@Retention(RetentionPolicy.RUNTIME)  
@Target({ ElementType.FIELD })  
public @interface XStreamCDATA {  
  
}  
