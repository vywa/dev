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
	private static final int DAO_NOT_RUSULT=301;							//没有查询结果
	
	/*
	 *  2** 为业务异常
	 * */
	private static final int Service_DATAACCESS_ERROR=201;			//访问数据库失败
	
	/*
	 *  控制层异常
	 * */
	private static final int CONTROLLER_INPUT_ERROR=101;			//输入格式异常
}
