package com.hengyun.dao.impl.logininfo.mysql;

import javax.annotation.Resource;


import org.springframework.transaction.annotation.Transactional;

import com.hengyun.dao.logininfo.mysql.UserAccountDao;
import com.hengyun.domain.loginInfo.UserAccount;

//@RunWith(value=SpringJUnit4ClassRunner.class)
//@ContextConfiguration(value="classpath:spring.xml")
public class UserAccountDaoTest {

	@Resource
	private UserAccountDao userAccountDao;
	
	@Transactional
	public void getCountTest(){
		UserAccount userAccount = userAccountDao.queryById(100000001);
		System.out.println(userAccount);
	}
}
