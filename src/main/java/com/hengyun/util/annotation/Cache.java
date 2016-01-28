package com.hengyun.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 *  用于在查询是放置缓存信息
 * */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Cache {

	String prefix();				//key的前缀
	long expiration() default 1000*60*60*2;		//缓存有效期
}
