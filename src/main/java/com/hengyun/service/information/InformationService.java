package com.hengyun.service.information;

import java.util.List;

import com.hengyun.domain.common.GeneralInfo;
import com.hengyun.domain.loginInfo.LoginInfo;
import com.hengyun.service.BaseService;

public interface InformationService  extends BaseService<GeneralInfo,Integer> {

	public int edit(GeneralInfo generalInfo);
}
