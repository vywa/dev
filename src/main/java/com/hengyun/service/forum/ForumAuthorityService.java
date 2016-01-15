package com.hengyun.service.forum;

import java.util.List;

import com.hengyun.domain.forum.ForumAuthority;
import com.hengyun.service.BaseService;

public interface ForumAuthorityService  extends BaseService<ForumAuthority,Integer> {

	public List<ForumAuthority> show();
}
