package com.hengyun.util.exception;


/**
 * 自定义业务异常处理类    友好提示
 * @author bob
 *
 */
public class BusinessException extends RuntimeException
{
	
	private static final long serialVersionUID = -4641659455971522864L;

	public BusinessException(String frdMessage)
	{
		super(createFriendlyErrMsg(frdMessage));
	}

	public BusinessException(Throwable throwable)
	{
		super(throwable);
	}

	public BusinessException(Throwable throwable, String frdMessage)
	{
		super(throwable);
	}

	private static String createFriendlyErrMsg(String msgBody)
	{
		String prefixStr = "抱歉，";
		String suffixStr = " 请稍后再试或与管理员联系！";

		StringBuffer friendlyErrMsg = new StringBuffer("");

		friendlyErrMsg.append(prefixStr);

		friendlyErrMsg.append(msgBody);

		friendlyErrMsg.append(suffixStr);

		return friendlyErrMsg.toString();
	}
}