package com.hengyun.dao.impl.hospital;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import com.hengyun.dao.hospital.HospitalDao;
import com.hengyun.dao.impl.BaseMongodbDaoImpl;
import com.hengyun.domain.hospital.Hospital;
import com.hengyun.domain.information.Icon;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;


/*
 *  上传文件
 * */

public class HospitalDaoImpl extends BaseMongodbDaoImpl<Hospital,Integer> implements HospitalDao{


	@Override
	protected Class<Hospital> getEntityClass() {
		// TODO Auto-generated method stub
		return Hospital.class;
	}
	
    
}
