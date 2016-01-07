/**
 * Sms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hengyun.util.sms;

public interface Sms extends javax.xml.rpc.Service {
    public java.lang.String getsmsSoapAddress();

    public SmsSoap getsmsSoap() throws javax.xml.rpc.ServiceException;

    public SmsSoap getsmsSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
