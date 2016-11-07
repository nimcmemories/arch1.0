package com.bean.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.springframework.transaction.annotation.Transactional;

import com.model.ACLinkListModel;
import com.model.ACListModel;
import com.model.EventModel;
import com.model.LinkModel;
import com.model.UserModel;
@Transactional
public class UserDAOImpl extends AbstractDAO implements UserDAO{

	@Override
	public UserModel getUserModel(String username,String password) {
		Query query = getSession().createQuery("from UserModel where "
				+ "user=:username and password=:password" );
		query.setParameter("username",username);
		query.setParameter("password",password);
		UserModel userModel = null;
		try{
			if(query.list().size() < 1){
				System.out.println(" probable cause is not a valid user  : ");
				return userModel;
			}
		userModel= (UserModel) query.list().get(0);
		Hibernate.initialize(userModel.getRoleModel().getEventModel());
		Hibernate.initialize(userModel.getRoleModel().getLinkModel());
		Query queryToLoadEventACLs = getSession().createQuery("from ACListModel where roleId = :roleId  and eventId in :eventIdList" );
		Query queryToLoadLinkACLs = getSession().createQuery("from ACLinkListModel where roleId = :roleId  and linkId in :linkIdList" );
		queryToLoadEventACLs.setParameter("roleId", userModel.getRoleModel().getRoleId());
		queryToLoadEventACLs.setParameterList("eventIdList", getEventIds(userModel.getRoleModel().getEventModel()));
		
		queryToLoadLinkACLs.setParameter("roleId", userModel.getRoleModel().getRoleId());
		queryToLoadLinkACLs.setParameterList("linkIdList", getLinkIds(userModel.getRoleModel().getLinkModel()));
		List<ACListModel> acListModel = queryToLoadEventACLs.list();
		List<ACLinkListModel> acLinkListModel = queryToLoadLinkACLs.list();
		userModel.setAcListModel(acListModel);
		userModel.setAcLinkListModel(acLinkListModel);
		
		System.out.println(" user model retrieved from DB : accessrigt finally" + acListModel.get(0).getAccessRight());
		}catch(Exception e){
			e.printStackTrace();
		}
		return userModel;
	}
	
	/**
	 * This method is helpful in getting eventids for query or any other purpose
	 * @param setEventModel
	 * @return
	 */
	private List<Long> getEventIds(Set<EventModel> setEventModel){
		List<Long> eventIds = new ArrayList<Long>();
		for(EventModel eventModel : setEventModel){
			eventIds.add(eventModel.getAclEventId());
		}
		 return eventIds;
	}

	
	/**
	 * This method is helpful in getting linkIds for query or any other purpose
	 * @param setEventModel
	 * @return
	 */
	private List<Long> getLinkIds(Set<LinkModel> setLinkModel){
		List<Long> linkIds = new ArrayList<Long>();
		for(LinkModel linkModel : setLinkModel){
			linkIds.add(linkModel.getLinkId());
			Hibernate.initialize(linkModel.getSetLinkGroup());
			System.out.println("link Group Initialized ");
			System.out.println("main system Initialized " + linkModel.getSetLinkGroup().getName());
		}
		 return linkIds;
	}
	
}
