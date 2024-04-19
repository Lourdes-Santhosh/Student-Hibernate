package com.lourdes.hibernate.StudentCRUD.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lourdes.hibernate.StudentCRUD.model.Marks;
import com.lourdes.hibernate.StudentCRUD.model.Student;



public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Student.class);
    	configuration.addAnnotatedClass(Marks.class);
    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	
	return sessionFactory;
}

}
