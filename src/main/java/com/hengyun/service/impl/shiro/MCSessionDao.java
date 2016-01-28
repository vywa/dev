package com.hengyun.service.impl.shiro;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *  会话实现类
 * */
public class MCSessionDao extends AbstractSessionDAO{

	private final static Logger log = LoggerFactory.getLogger(MCSessionDao.class);
	
	private MemcachedClient client;
	
	
	
	public MCSessionDao(MemcachedClient client) {
		if(client == null) {
			throw new RuntimeException("必须存在memcached客户端存在");
		}
		this.client = client;
	}
	
	

	@Override
	public void delete(Session session) {
		// TODO Auto-generated method stub
		try {
			//client.delete(session.getId().toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Session> getActiveSessions() {
		// TODO Auto-generated method stub
		
		return Collections.emptyList();
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		// TODO Auto-generated method stub
		try {
		//	client.replace(session.getId().toString(),(int)session.getTimeout()/1000,session);
		} catch (InvalidSessionException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
	}

	@Override
	protected Serializable doCreate(Session session) {
		// TODO Auto-generated method stub
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session,sessionId);
		
			try {
		//		client.set(sessionId.toString(),(int)session.getTimeout()/1000,session);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				log.error(ex.getMessage());
			}
		
		return sessionId;
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		// TODO Auto-generated method stub
		Session session = null;
		try {
		//	session = client.get(sessionId.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return session;
	}

	
}
