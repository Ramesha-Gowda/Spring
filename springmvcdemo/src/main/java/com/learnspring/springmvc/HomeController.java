package com.learnspring.springmvc;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnspring.springmvc.dao.AlienDao;
import com.learnspring.springmvc.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	private AlienDao dao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,Model m) {
		
		int num3 = i+j;
		
		m.addAttribute("num3",num3);
		
		return "result";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute("result") Alien a) {
		
		dao.addAlien(a);
		return "result";
	}
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Ramesha");
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
		m.addAttribute("result",dao.getAliens());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid,Model m) {
		
		m.addAttribute("result",dao.getAlien(aid));
		return "showAliens";
	}
	
}
