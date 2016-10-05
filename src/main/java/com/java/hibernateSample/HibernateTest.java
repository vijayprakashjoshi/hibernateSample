package com.java.hibernateSample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.AddressDetails;
import com.java.hibernate.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user = new UserDetails();
		user.setUserName("First User");
		
		AddressDetails homeAddress = new AddressDetails();
		homeAddress.setCity("udaipur");
		homeAddress.setState("Rajasthan");
		
		AddressDetails officeAddress = new AddressDetails();
		officeAddress.setCity("udaipur office");
		officeAddress.setState("Rajasthan office");

//		user.setHomeAddress(homeAddress);
//		user.setOfficeAddress(officeAddress);

		user.getListOfAddress().add(homeAddress);
		user.getListOfAddress().add(officeAddress);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); 
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	
		user = null;
		
		session = sessionFactory.openSession();
		user = (UserDetails) session.get(UserDetails.class, 1);
		
		System.out.println(user.getUserId()+": "+user.getUserName());
		
	}

}
