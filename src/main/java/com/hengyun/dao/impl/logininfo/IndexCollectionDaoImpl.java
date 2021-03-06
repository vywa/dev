package com.hengyun.dao.impl.logininfo;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.dao.logininfo.IndexCollectionDao;
import com.hengyun.domain.common.IndexCollection;

/*
 *  管理员数据访问层实现
 * */

public class IndexCollectionDaoImpl extends BaseMongodbDaoImpl<IndexCollection,Integer> implements IndexCollectionDao{

	@Override
	protected Class<IndexCollection> getEntityClass() {
		// TODO Auto-generated method stub
		return IndexCollection.class;
	}

	public boolean load() {
		// TODO Auto-generated method stub
		IndexCollection indexCollection = new IndexCollection();
		indexCollection.setDocterID(1000000000);
		indexCollection.setPatientID(200000000);
		
		if(!this.mongoTemplate.collectionExists(IndexCollection.class)){
			this.mongoTemplate.save(indexCollection);
			return false;
		}
		return true;
	}

	/*
	 * 获取名称为name的自增索引
	 * */
	public int updateIndex(String name) {
		// TODO Auto-generated method stub
		int userId =0;
		Query query = new Query();
		 Update update = new Update();
		 IndexCollection index=null;
		switch(name){
			case "patient":	
				 query = Query.query(Criteria.where("patientID").gt(0));
		         update = new Update();
		        update.inc("patientID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getPatientID();
				 break;
			case "doctor":
				 query = Query.query(Criteria.where("docterID").gt(0));
		         update = new Update();
		        update.inc("docterID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getDocterID();
				 break;
			case "admin":
				 query = Query.query(Criteria.where("adminID").gt(0));
		         update = new Update();
		        update.inc("adminID", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getAdminID();
				 break;
			case "recipeId":
				 query = Query.query(Criteria.where("recipeId").gt(0));
		         update = new Update();
		        update.inc("recipeId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getRecipeId();
				 break;
			case "doctorAdviceId":
				 query = Query.query(Criteria.where("doctorAdviceId").gt(0));
		         update = new Update();
		        update.inc("doctorAdviceId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getDoctorAdviceId();
				 break;
			case "riskFactorId":
				 query = Query.query(Criteria.where("riskFactorId").gt(0));
		         update = new Update();
		        update.inc("riskFactorId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getRiskFactorId();
				 break;
			case "targetOrganDamageId":
				 query = Query.query(Criteria.where("targetOrganDamageId").gt(0));
		         update = new Update();
		        update.inc("targetOrganDamageId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getTargetOrganDamageId();
				 break;
			case "affiliatedClinicalDiseaseId":
				 query = Query.query(Criteria.where("affiliatedClinicalDiseaseId").gt(0));
		         update = new Update();
		        update.inc("affiliatedClinicalDiseaseId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getAffiliatedClinicalDiseaseId();
				 break;
			case "diagnosisId":
				 query = Query.query(Criteria.where("diagnosisId").gt(0));
		         update = new Update();
		        update.inc("diagnosisId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getDiagnosisId();
				 break;
			case "resourceId":
				 query = Query.query(Criteria.where("resourceId").gt(0));
		         update = new Update();
		        update.inc("resourceId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getResourceId();
				 break;
			case "noticeId":
				 query = Query.query(Criteria.where("noticeId").gt(0));
		         update = new Update();
		        update.inc("noticeId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getNoticeId();
				 break;
			case "collectionId":
				 query = Query.query(Criteria.where("collectionId").gt(0));
		         update = new Update();
		        update.inc("collectionId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getCollectionId();
				 break;
			case "newsId":
				 query = Query.query(Criteria.where("newsId").gt(0));
		         update = new Update();
		        update.inc("newsId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getNewsId();
				 break;
			case "subjectId":
				 query = Query.query(Criteria.where("subjectId").gt(0));
		         update = new Update();
		        update.inc("subjectId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getSubjectId();
				 break;
			case "updateId":
				 query = Query.query(Criteria.where("updateId").gt(0));
		         update = new Update();
		        update.inc("updateId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getUpdateId();
				 break;
			case "sportId":
				 query = Query.query(Criteria.where("sportId").gt(0));
		         update = new Update();
		        update.inc("sportId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getSportId();
				 break;
			case "dietId":
				 query = Query.query(Criteria.where("dietId").gt(0));
		         update = new Update();
		        update.inc("dietId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getDietId();
				 break;
			case "medicalRecordId":
				 query = Query.query(Criteria.where("medicalRecordId").gt(0));
		         update = new Update();
		        update.inc("medicalRecordId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getMedicalRecordId();
				 break;
			case "followupId":
				 query = Query.query(Criteria.where("followupId").gt(0));
		         update = new Update();
		        update.inc("followupId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getFollowupId();
				 break;
			case "measureId":
				 query = Query.query(Criteria.where("measureId").gt(0));
		         update = new Update();
		        update.inc("measureId", 1);
		         index =  this.mongoTemplate.findAndModify(query, update, IndexCollection.class);
				 userId = index.getMeasureId();
				 break;
			default:
				 break;
		}
		return userId;
	}

	
	

}
