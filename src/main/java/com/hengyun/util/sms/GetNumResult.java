/**
 * GetNumResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.hengyun.util.sms;

public class GetNumResult  implements java.io.Serializable {
    private int code;

    private java.lang.String msg;

    private int num;

    public GetNumResult() {
    }

    public GetNumResult(
           int code,
           java.lang.String msg,
           int num) {
           this.code = code;
           this.msg = msg;
           this.num = num;
    }


    /**
     * Gets the code value for this GetNumResult.
     * 
     * @return code
     */
    public int getCode() {
        return code;
    }


    /**
     * Sets the code value for this GetNumResult.
     * 
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }


    /**
     * Gets the msg value for this GetNumResult.
     * 
     * @return msg
     */
    public java.lang.String getMsg() {
        return msg;
    }


    /**
     * Sets the msg value for this GetNumResult.
     * 
     * @param msg
     */
    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }


    /**
     * Gets the num value for this GetNumResult.
     * 
     * @return num
     */
    public int getNum() {
        return num;
    }


    /**
     * Sets the num value for this GetNumResult.
     * 
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetNumResult)) return false;
        GetNumResult other = (GetNumResult) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.code == other.getCode() &&
            ((this.msg==null && other.getMsg()==null) || 
             (this.msg!=null &&
              this.msg.equals(other.getMsg()))) &&
            this.num == other.getNum();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCode();
        if (getMsg() != null) {
            _hashCode += getMsg().hashCode();
        }
        _hashCode += getNum();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetNumResult.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://106.ihuyi.cn/", "GetNumResult"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://106.ihuyi.cn/", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("msg");
        elemField.setXmlName(new javax.xml.namespace.QName("http://106.ihuyi.cn/", "msg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("num");
        elemField.setXmlName(new javax.xml.namespace.QName("http://106.ihuyi.cn/", "num"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
