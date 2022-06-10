package com.learnspring.springbootmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnspring.springbootmvc.dao.AlienRepo;
import com.learnspring.springbootmvc.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@GetMapping(path="aliens",produces = {"application/xml"})
	public List<Alien> getAliens() {
		
		System.out.println("getAliens methos called...");
		
		
		List<Alien> aliens = repo.findAll();
		
		return aliens;
	}
	
	@GetMapping("alien/{aid}")
	public Alien getAlien(@PathVariable("aid") int aid) {
		
		Alien alien = repo.findById(aid).orElse(new Alien(0,""));
		return alien;
	}
	
	/*
	 * @PostMapping("alien") public Alien add(@RequestBody Alien alien) {
	 * repo.save(alien); return alien; }
	 */
	
	@PostMapping(path="alien",consumes = {"application/xml"})
	public Alien add(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}

}
