package com.hengyun.service.hospital;

import java.util.List;

import com.hengyun.domain.hospital.Hospital;
import com.hengyun.service.BaseService;


public interface HospitalService  extends BaseService<Hospital,Integer> {

	public List<Hospital> queryAll();
	
	public void addHospital(Hospital hospital);
}
