package com.hengyun.domain.hospital;

import java.io.Serializable;
import java.util.List;

/*
 * 职能科室信息
 * 
 * 门诊部：内科、外科、儿科、妇科、眼科、耳鼻喉科、
	口腔科、
	皮肤科、中医科、针灸推拿科、心理咨询室等。
	住院部：呼吸内科、
	消化内科、泌尿内科、心内科、血液科、
	内分泌科、
	神经内科、
	小儿科、感染科、
	普外科、骨科、
	神经外科、肝胆外科、
	泌尿外科、烧伤科、妇科、产科、血透室、
	重症监护室等。
	急诊部：内科、外科、
	妇产科、儿科等。
	药房：门诊药房、急诊药房、住院药房、药房仓库等。
	收费室：门诊收费窗口、住院收费窗口、急诊收费窗口等。
	化验室：生化室、检验室、病理室等。
 * */
public class Office implements Serializable{

	private int			officeId;									//科室编号
	private int			hospitalId;								//医院ID
	private String officeName;								//科室名称
	private String description;								//科室描述
	private List<Integer>	docters;						//科室医生
	
	
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getOfficeId() {
		return officeId;
	}
	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Integer> getDocters() {
		return docters;
	}
	public void setDocters(List<Integer> docters) {
		this.docters = docters;
	}
	
	
	
}
