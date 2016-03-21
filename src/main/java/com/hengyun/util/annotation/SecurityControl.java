package com.hengyun.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//允许通过注解
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SecurityControl {
	public String[] role() default "";
	public boolean roleOr() default true;
	
	public String[] perm() default "";
	public boolean permOr() default false;
	
}
