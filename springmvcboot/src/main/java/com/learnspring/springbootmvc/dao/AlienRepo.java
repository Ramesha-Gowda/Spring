package com.learnspring.springbootmvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.learnspring.springbootmvc.model.Alien;

public interface AlienRepo extends JpaRepository<Alien,Integer> {

	List<Alien> findByAname(String aname); //query DSL
	
//	@Query("from Alien Where aname= :aname")
//	List<Alien> find(String aname);
	
	@Query("from Alien Where aname= :name")
	List<Alien> find(@Param("name") String aname);

}
