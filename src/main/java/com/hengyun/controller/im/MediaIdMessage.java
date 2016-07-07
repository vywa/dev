package com.hengyun.controller.im;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
* @author bob E-mail:panbaoan@thealth.cn
* @version 创建时间：2016年7月4日 上午10:10:57
* 类说明
*/
public class MediaIdMessage {  
    @XStreamAlias("MediaId")  
    @XStreamCDATA  
    private String MediaId;  
  
    public String getMediaId() {  
        return MediaId;  
    }  
  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
  
}  