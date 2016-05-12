package com.hengyun.util.exception;

import java.io.Serializable;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年4月15日 下午4:56:34
* 异常类定义
*/
public class ExceptionCode implements Serializable{

	/*
	 *  3** 为数据库访问异常
	 * */
	public  static final int DAO_NOT_RUSULT=301;												//没有查询结果
	
	public  static final int NULL_ARGUMENT_EXCEPTION=302;					//参数为空值
	public  static final int ILLIGAL_ARGUMENT_EXCEPTION=303;			//参数非法
	public  static final int OPERATION_TIMEOUT=304;									//操作超时
	public  static final int INVALIDATE_QUERY_ROW=305;								//无效查询字段
	
	public  static final int AUTHORITY_DENY=310;											//没有权限操作
	
	/*
	 *  2** 为业务异常
	 * */
	public static final int SERVICE_UNKNOW_ERROR		=200;			//业务层位置异常未知异常			
	public static final int SERVICE_DATAACCESS_TIMEOUT		=220;			//业务层访问数据库超时	
	public  static final int Service_DATAACCESS_ERROR=201;			//访问数据库失败
	
	
	public  static final int NOT_USER 										=202;				//没有该用户
	public  static final int USER_EXIST										=203;				//用户已经存在
	public  static final int  PASSWORD_ERROR						=204;				//用户密码错误
	public static final int ILLEGAL_ACCOUNT_EXCEPTION=205;			//不支持的账号类型
	public static final int 	CONFORMCODE_ERROR				=206;				//验证码错误
	public static final int 	CONFORMCODE_COUNT_OVER				=207;				//验证码发送次数过多
	public static final int 	USER_NOT_EXIST_CACHE				=208;				//用户没有在缓存中
	
	public static final int ACCOUNT_EXCEPTION					=210;				//账号异常
	public static final int ACCOUNT_FROZEN						=211;				//账号冻结
	public static final int 	ACCOUNT_CANCEL						=212;				//账号注销
	
	
	
	/*
	 *  控制层异常
	 * */
	public  static final int ILLIGAL_ARGUMENT=101;								//输入格式异常
	public  static final int JSON_PARSET_ERROR=102;								//参数解析异常
	public  static final int JSON_TO_OBJECT_ERROR=103;						//参数解析异常
}
