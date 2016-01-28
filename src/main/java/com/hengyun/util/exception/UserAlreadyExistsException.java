package com.hengyun.util.exception;

import java.io.PrintStream;

public class UserAlreadyExistsException extends Exception{

	private Throwable nestedThrowable = null;

	public UserAlreadyExistsException(Throwable nestedThrowable) {
		super();
		this.nestedThrowable = nestedThrowable;
	}
	
	public UserAlreadyExistsException(){
		super();
	}
	
	public UserAlreadyExistsException(String msg){
		super(msg);
	}
	
	public UserAlreadyExistsException(String msg ,Throwable throwable){
		super(msg);
		this.nestedThrowable = throwable;
	}

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		if(nestedThrowable != null){
			nestedThrowable.printStackTrace();
		}
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		// TODO Auto-generated method stub
		super.printStackTrace(ps);
		if(nestedThrowable !=null){
			nestedThrowable.printStackTrace(ps);
		}
	}
	
	
}
