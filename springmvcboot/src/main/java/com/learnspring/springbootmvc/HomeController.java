package com.learnspring.springbootmvc;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.learnspring.springbootmvc.dao.AlienRepo;
import com.learnspring.springbootmvc.model.Alien;



@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	/*
	 * @RequestMapping("/") public String home() { return "index.jsp"; }
	 */
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	
	/*
	 * @RequestMapping("add") public String add(HttpServletRequest req) {
	 * 
	 * int i = Integer.parseInt(req.getParameter("num1")); int j =
	 * Integer.parseInt(req.getParameter("numj")); int num3 = i+j;
	 * 
	 * HttpSession session = req.getSession(); session.setAttribute("num3", num3);
	 * 
	 * return "result.jsp"; }
	 */
	
	/*
	 * @RequestMapping("add") public String add(@RequestParam("num1") int
	 * i,@RequestParam("num2") int j,HttpSession session) {
	 * 
	 * int num3 = i+j;
	 * 
	 * session.setAttribute("num3", num3);
	 * 
	 * return "result.jsp"; }
	 */
	
	/*
	 * @RequestMapping("add") public ModelAndView add(@RequestParam("num1") int
	 * i,@RequestParam("num2") int j,HttpSession session) {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * int num3 = i+j; mv.addObject("num3",num3); mv.setViewName("result.jsp");
	 * 
	 * return mv; }
	 */
	
	/*
	 * @RequestMapping("add") public ModelAndView add(@RequestParam("num1") int
	 * i,@RequestParam("num2") int j,HttpSession session) {
	 * 
	 * ModelAndView mv = new ModelAndView();
	 * 
	 * int num3 = i+j;
	 * 
	 * mv.addObject("num3",num3);//data mv.setViewName("result");//view name
	 * 
	 * return mv; }
	 */
	
	@RequestMapping("add")
	public String add(@RequestParam("num1") int i,@RequestParam("num2") int j,Model m) {
		
		int num3 = i+j;
		
		m.addAttribute("num3",num3);
		
		return "result";
	}
	
	/*
	 * @RequestMapping("addAlien") public String addAlien(@RequestParam("aid") int
	 * aid,@RequestParam("aname") String aname,Model m) { Alien a = new Alien();
	 * a.setAid(aid); a.setAname(aname);
	 * 
	 * m.addAttribute("alien",a);
	 * 
	 * return "result"; }
	 */
	
	/*
	 * @RequestMapping("addAlien") public String addAlien(@ModelAttribute Alien a) {
	 * return "result"; }
	 */
	
	/*
	 * @RequestMapping("addAlien") public String addAlien(@ModelAttribute("a1")
	 * Alien a) { return "result"; }
	 */
	
	/*
	 * @RequestMapping("addAlien") public String addAlien(Alien a) { return
	 * "result"; }
	 */
	
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Ramesha");
	}
	
	/*
	 * @RequestMapping(value="addAlien",method = RequestMethod.GET) public String
	 * add
	 * Alien(Alien a) { return "result"; }
	 */
	
	
	/*
	 * @RequestMapping(value="addAlien",method = RequestMethod.POST) public String
	 * addAlien(Alien a) { return "result"; }
	 * 
	 * @GetMapping(value="addAlien") public String addAlien(Alien a) { return
	 * "result"; }
	 */
	
	@PostMapping(value="addAlien")
	public String addAlien(Alien a) {
		
		repo.save(a);
		return "result";
	}
	
	@GetMapping("getAliens")
	public String getAliens(Model m) {
		
		m.addAttribute("result",repo.findAll());
		return "showAliens";
	}
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam int aid,Model m) {
		
		m.addAttribute("result",repo.getOne(aid));
		return "showAliens";
	}
	
	/*
	 * @GetMapping("getAlienByName") public String getAlienByName(@RequestParam
	 * String aname,Model m) {
	 * 
	 * m.addAttribute("result",repo.findByAname(aname)); return "showAliens"; }
	 */
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname,Model m) {
		
		m.addAttribute("result",repo.find(aname));
		return "showAliens";
	}
	
}
