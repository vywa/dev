package com.hengyun.service.hospital;

import java.util.List;

import com.hengyun.domain.hospital.Office;
import com.hengyun.service.BaseService;


public interface OfficeService  extends BaseService<Office,Integer> {

	public List<Office> queryAll();
	
	public int addDocter(int docterId,int officeId);
}
