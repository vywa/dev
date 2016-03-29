package com.hengyun.service.hospital;

import java.util.List;

import com.hengyun.domain.hospital.Docter;
import com.hengyun.domain.information.NickIcon;
import com.hengyun.domain.loginInfo.UserAccount;
import com.hengyun.service.BaseService;


public interface DocterService  extends BaseService<Docter,Integer> {

	public List<Docter> queryAll();
	
	public List<Docter> queryByHospital(int hospitalId);
	
	public boolean exist(String workNum);
}
