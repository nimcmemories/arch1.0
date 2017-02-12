package com.system.hospital.bean;

import java.io.File;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.json.JSONArray;
import org.json.JSONObject;

import com.application.bean.ModuleBean;

public class TestMain {
	public static void main(String[] args) {
		File file = new File("src/main/java/hibernate1.cfg.xml");
		TestBean testBean = new TestBean();
		testBean.setInteger(1);
		testBean.setName("nimesh");
		JSONObject jObj = new JSONObject();
		jObj.put("id", testBean.getInteger());
		jObj.put("name", testBean.getName());
		testBean = null;
		System.out.println(" json : " + jObj);
		System.out.println("file path " + file.getAbsolutePath());
		SessionFactory factory = new Configuration().configure(file).buildSessionFactory();
		List<ModuleBean> moduleBean = (List<ModuleBean>) factory.openSession().createCriteria(ModuleBean.class).list();
			
		JSONArray ja = new JSONArray(moduleBean.toString());
			System.out.println("objct mapper : " + ja.getJSONObject(0).getString("created_by"));
		factory.close();
	
			
		 
	}
}
