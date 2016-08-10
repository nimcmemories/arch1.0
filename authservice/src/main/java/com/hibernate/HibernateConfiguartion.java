package com.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author nimesh
 *
 */
public class HibernateConfiguartion {
	public static SessionFactory sessionFactory ;
	private static Logger logger = Logger.getLogger(HibernateConfiguartion.class);
	public static void createSessionFactory(){
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();                   
        sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
        if(sessionFactory!=null){
        	logger.debug(" sessionFactory is not null : ");
        	logger.debug("databases : " +sessionFactory.openSession().createSQLQuery("show databases;").list());
        }else{
        	logger.debug(" sessionFactory is null : ");
        }
	}
}
