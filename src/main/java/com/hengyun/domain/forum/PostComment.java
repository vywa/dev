package com.hengyun.domain.forum;

import java.io.Serializable;
import java.util.List;

/*
 *  		帖子回复
 * 
 * */

public class PostComment implements Serializable{

	/*
	 *  回复基本信息
	 * 
	 * */
	private int replyId;							//回复id
	
	private String type;						//回复的类型（主贴回复，别人评论回复）
	
	private int 	replyToId;					//回复评论的id;
	
	
	private String replyerName;			//回复人名称
	
	private int 	replyerId;						//回复人ID
	
	private CommonContent 	commonContent;					//回复内容
	
	
	/*
	 * 
	 *  回复处理
	 * 
	 * */

	private String status;						//回复状态 (屏蔽，正常)
	

	private List<CommonContent> 	commentList;				//回复的回复

	
	
	
}
