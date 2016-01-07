package com.hengyun.util.sms;

public class SmsSoapProxy implements SmsSoap {
  private String _endpoint = null;
  private SmsSoap smsSoap = null;
  
  public SmsSoapProxy() {
    _initSmsSoapProxy();
  }
  
  public SmsSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initSmsSoapProxy();
  }
  
  private void _initSmsSoapProxy() {
    try {
      smsSoap = (new SmsLocator()).getsmsSoap();
      if (smsSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)smsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)smsSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (smsSoap != null)
      ((javax.xml.rpc.Stub)smsSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public SmsSoap getSmsSoap() {
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap;
  }
  
  public SubmitResult submit(java.lang.String account, java.lang.String password, java.lang.String mobile, java.lang.String content) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.submit(account, password, mobile, content);
  }
  
  public ChangePasswordResult changePassword(java.lang.String account, java.lang.String password, java.lang.String newpassword) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.changePassword(account, password, newpassword);
  }
  
  public GetNumResult getNum(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.getNum(account, password);
  }
  
  public GetReplyResult getReply(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.getReply(account, password);
  }
  
  public QueryResult query(java.lang.String smsid) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.query(smsid);
  }
  
  public GetKeFuResult getKeFu(java.lang.String account, java.lang.String password) throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.getKeFu(account, password);
  }
  
  public VersionInfoResult versionInfo() throws java.rmi.RemoteException{
    if (smsSoap == null)
      _initSmsSoapProxy();
    return smsSoap.versionInfo();
  }
  
  
}