package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.BaseBean;

public class TestImp implements TestDao{

	 @Autowired
	 SessionFactory sessionFactory;
	 Session session = null;
	 Transaction tx = null;

	@Override
	public BaseBean getTestObj() {
		Long id =0l;
		System.out.println(" method called ");
		 session = sessionFactory.openSession();
		  BaseBean employee = (BaseBean) session.load(BaseBean.class,
		    new Long(id));
		  tx = session.getTransaction();
		  session.beginTransaction();
		  tx.commit();
		  return employee;
	}
	
	public static void main(String[] args) {
		String str = "{\"responseInfo\":{\"userACL\":[{\"eventId\":3,\"aclListId\":2,\"accessRight\":2,\"roleId\":2,\"name\":\"Login\",\"description\":\"Login event must be allowed to all users Administrator\"},{\"eventId\":4,\"aclListId\":4,\"accessRight\":1,\"roleId\":2,\"name\":\"SessionOKCheck\",\"description\":\"Login event must be allowed to all users Administrator\"}],\"userLinkACL\":[{\"eventModel\":null,\"linkId\":4,\"name\":\"test_general_link\"},{\"eventModel\":null,\"linkId\":5,\"name\":\"test2_ link creation\"}]},\"status\":290}";
		JSONObject jObj = new JSONObject(str);
		System.out.println(jObj);
		System.out.println("jObj : " + jObj.getJSONObject("responseInfo").getJSONArray("userACL"));
	}
}
