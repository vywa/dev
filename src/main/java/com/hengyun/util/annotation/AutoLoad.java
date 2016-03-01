package com.hengyun.util.annotation;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午3:58:03
* 类说明
*/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface AutoLoad {

	boolean value()  default true;
}
