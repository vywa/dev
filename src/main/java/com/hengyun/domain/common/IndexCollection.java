package com.hengyun.domain.common;

import java.io.Serializable;

/*
 *  数据库中自增索引
 * */
public class IndexCollection implements Serializable{

	private int docterID;									//初始值100000000
	private int patientID;								//初始值200000000
	
	private int reTreateInfoID;						//回访表
	private int adminID;									//管理员０
	
	/*
	 *  论坛模块索引
	 * */
	private int postID;										//帖子id
	private int commentID;							//回复id
	private int forumTemplateID;				//板块id
	private int multiMediaID;						//多媒体信息id
	
	/*
	 *  病历部分索引
	 * 
	 * */
	private int caseHistoryID;						//病历初值
	private int recipeId;									//处方id
	private int doctorAdviceId;					//医嘱id
	private int riskFactorId;							//危险因素id
	private int targetOrganDamageId;		//器官受损id
	private int affiliatedClinicalDiseaseId;		//伴随临床疾患
	private int diagnosisId;							//诊断id
	
	/*
	 *  资源管理
	 * */
	private int resourceId;								//资源id
	
	/*
	 *  通知
	 * */
	private int noticeId;									//通知id
	
	/*
	 *  监控
	 * */
	private int exceptionId;							//异常id
	
	/*
	 *  收藏
	 * */
	private int collectionId;							//收藏id
	private int newsId;									//资讯id
	
	/*
	 *  版本更新
	 * */
	private int updateId;								//更新id
	
	
	
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public int getCollectionId() {
		return collectionId;
	}
	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}
	public int getExceptionId() {
		return exceptionId;
	}
	public void setExceptionId(int exceptionId) {
		this.exceptionId = exceptionId;
	}
	public int getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public int getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public int getAffiliatedClinicalDiseaseId() {
		return affiliatedClinicalDiseaseId;
	}
	public void setAffiliatedClinicalDiseaseId(int affiliatedClinicalDiseaseId) {
		this.affiliatedClinicalDiseaseId = affiliatedClinicalDiseaseId;
	}
	public int getTargetOrganDamageId() {
		return targetOrganDamageId;
	}
	public void setTargetOrganDamageId(int targetOrganDamageId) {
		this.targetOrganDamageId = targetOrganDamageId;
	}
	public int getRiskFactorId() {
		return riskFactorId;
	}
	public void setRiskFactorId(int riskFactorId) {
		this.riskFactorId = riskFactorId;
	}
	public int getDoctorAdviceId() {
		return doctorAdviceId;
	}
	public void setDoctorAdviceId(int doctorAdviceId) {
		this.doctorAdviceId = doctorAdviceId;
	}
	public int getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(int recipeId) {
		this.recipeId = recipeId;
	}
	public int getMultiMediaID() {
		return multiMediaID;
	}
	public void setMultiMediaID(int multiMediaID) {
		this.multiMediaID = multiMediaID;
	}
	public int getReTreateInfoID() {
		return reTreateInfoID;
	}
	public void setReTreateInfoID(int reTreateInfoID) {
		this.reTreateInfoID = reTreateInfoID;
	}
	public int getCaseHistoryID() {
		return caseHistoryID;
	}
	public void setCaseHistoryID(int caseHistoryID) {
		this.caseHistoryID = caseHistoryID;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}

	
	
	
	public int getDocterID() {
		return docterID;
	}
	public void setDocterID(int docterID) {
		this.docterID = docterID;
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public int getCommentID() {
		return commentID;
	}
	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}
	public int getForumTemplateID() {
		return forumTemplateID;
	}
	public void setForumTemplateID(int forumTemplateID) {
		this.forumTemplateID = forumTemplateID;
	}
	
	
}
