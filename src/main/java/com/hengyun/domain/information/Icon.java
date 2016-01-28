package com.hengyun.domain.information;

import java.io.Serializable;
import java.util.Date;

/*
 *  图片
 * */
public class Icon implements Serializable{

	private int id;									//图片id
	private String filename;				//图片名称
	private String aliases;					//图片别名
	private long chunkSize;				//块大小
	private Date uploadDate;			//上传时间
	private long length;						//长度
	private String contentType;		//类型
	private String md5				;			//md5校验码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getAliases() {
		return aliases;
	}
	public void setAliases(String aliases) {
		this.aliases = aliases;
	}
	public long getChunkSize() {
		return chunkSize;
	}
	public void setChunkSize(long chunkSize) {
		this.chunkSize = chunkSize;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	
	
	
}
