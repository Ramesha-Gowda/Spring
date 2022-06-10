package com.learnspring.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.learnspring.springmvc.model.Alien;

import jakarta.transaction.Transactional;

public class AlienDao {
	
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public List<Alien> getAliens(){
		
		Session session = sessionFactory.getCurrentSession();
		List<Alien> alien=session.createQuery("from Alien",Alien.class).list();
		return alien;
	}

	@Transactional
	public void addAlien(Alien a) {
		Session session = sessionFactory.getCurrentSession();
		session.save(a);
	}

	@Transactional
	public Alien getAlien(int aid) {
		
		Session session = sessionFactory.getCurrentSession();
		Alien a = session.get(Alien.class, aid);
		
		return a;
	}
}
