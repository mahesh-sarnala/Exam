package com.klef.jfsd.HCQLOperations;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Demo {

	public static void main(String[] args) {
                Demo d2= new Demo();
                d2.addStudent();
                d2.restrictionsdemo();
	}
	 public void addStudent() {
	 		
	 		
	 		Configuration cfg = new Configuration();
	 		cfg.configure("hibernate.cfg.xml");
	 		
	 		SessionFactory sf = cfg.buildSessionFactory();
	 		Session session = sf.openSession();
	 		
	 		
	 		Transaction transaction = session.beginTransaction();
	 		
	 		Student3 f = new Student3();
	 		f.setName("sita");
	 		f.setGender("F");
	 		f.setDept("cse");
	 		f.setCgpa(300000);
	 		f.setBacklogs(0);
	 		
	 		session.persist(f);
	 		transaction.commit();
	 		System.out.println("faculty added successfully");
	 		
	 		session.close();
	 		sf.close();
	 	}
	 public void restrictionsdemo() {
	    	Configuration cfg = new Configuration();
	 		cfg.configure("hibernate.cfg.xml");
	 		
	 		SessionFactory sf = cfg.buildSessionFactory();
	 		Session session = sf.openSession();
	 		
	 		HibernateCriteriaBuilder cb=session.getCriteriaBuilder();
	 		CriteriaQuery<Student3> cq=cb.createQuery(Student3.class);
	 		
	 		//complete object -from faculty
	 		Root<Student3> root=cq.from(Student3.class);
	 		
	 		//equals
	 		//cq.select(root).where(cb.equal(root.get("department"), "cse"));
	 		//between
	 		//cq.select(root).where(cb.between(root.get("salary"),10000,13000));
	 		//less than
	 		cq.select(root).where(cb.le(root.get("id"), 1));
	        
	 		
	 		List<Student3> studentlist=session.createQuery(cq).getResultList();
	 		System.out.println("faculty count"+studentlist.size());
	 		
	 		for(Student3 f: studentlist) {
	 			System.out.println(f.toString());
	 		}
	 		session.close();
	 		sf.close();
	 		
	    }

}
