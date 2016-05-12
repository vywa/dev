package com.hengyun.util.exception;
/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年2月26日 下午2:33:30
* 系统检查异常基类
*/
public class ThealthException extends Exception{

	  private int code;

      public int getCode() {
              return code;
      }

      public void setCode(int code) {
              this.code = code;
      }


      public ThealthException(int code) {
              super();
              this.code = code;
      }

      public ThealthException(int code,String msg) {
              super(msg);
              this.code = code;
      }

      public ThealthException(int code,String msg,Throwable cause) {
              super(msg,cause);
              this.code = code;
      }


      public ThealthException(){
              super();
      }

      public ThealthException (String msg){
              super(msg);
      }

      public ThealthException(Throwable cause){
              super(cause);
      }

      public ThealthException(String msg , Throwable cause){
              super(msg,cause);
      }

	
}
