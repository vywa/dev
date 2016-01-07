/**
 * SmsSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hengyun.util.sms;

public interface SmsSoap extends java.rmi.Remote {

    /**
     * 提交短信:<br>参数说明:<br>account:账号<br>password:密码<br>mobile:手机号码<br>content:短信内容
     */
    public SubmitResult submit(java.lang.String account, java.lang.String password, java.lang.String mobile, java.lang.String content) throws java.rmi.RemoteException;

    /**
     * 修改短信账号密码:<br>参数说明:<br>account:账号<br>password:旧密码<br>newpassword:新密码
     */
    public ChangePasswordResult changePassword(java.lang.String account, java.lang.String password, java.lang.String newpassword) throws java.rmi.RemoteException;

    /**
     * 查询账户余额:<br>参数说明:<br>account:查询用户名<br>password:查询用户密码
     */
    public GetNumResult getNum(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 查询用户回复:<br>参数说明:<br>account:查询用户名<br>password:查询用户密码
     */
    public GetReplyResult getReply(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 查询发送回执:<br>参数说明:<br>smsid:流水号
     */
    public QueryResult query(java.lang.String smsid) throws java.rmi.RemoteException;

    /**
     * 获取客服信息:<br>参数说明:<br>account:查询用户名<br>password:查询用户密码
     */
    public GetKeFuResult getKeFu(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * 版本信息,仅用于提示:<br>参数说明:
     */
    public VersionInfoResult versionInfo() throws java.rmi.RemoteException;
}
