package com.telusko.demo.controller;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

//@Controller
@RestController
public class AlienController
{
	@Autowired
	AlienRepo repo;

	/*@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}*/
	/*@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}*/
	
	
	/*@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid)
	{
		ModelAndView mv=new ModelAndView("showAlien.jsp");
		Alien alien=repo.findById(aid).orElse(new Alien());
		System.out.println(repo.findByTech("Java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByTechSorted("Java"));
		mv.addObject(alien);
		return mv;
	}*/
	
	/*@RequestMapping("/showAlien")
	public ModelAndView getAlien( @RequestParam("aid") int aid)
	{
		ModelAndView mv = new ModelAndView();
		Alien alien = new Alien();
		alien = repo.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		mv.setViewName("showAlien.jsp");
		return mv;
	}*/
	
	/*@RequestMapping("/alien/{aid}")
	@ResponseBody
	public String getAlien(@PathVariable("aid") int aid)
	{
		
		return repo.findById(aid).toString();
	}*/
	
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid)
	{
		
		return repo.findById(aid);
	}
	
	//produces= {"application/xml"} did not work
	@RequestMapping(path="/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		
		return repo.findAll();
	}
	// worked consumes="application/xml"
	@PostMapping(path= "/alien", consumes="application/json")
	public Alien addAlien(@RequestBody Alien alien)
	{
		return repo.save(alien);
		//return "home.jsp";
	}
	
	// worked consumes="application/xml"
	@PutMapping(path= "/alien", consumes="application/json")
	public Alien saveorUpdate(@RequestBody Alien alien)
	{
		return repo.save(alien);
		//return "home.jsp";
	}
	
	@DeleteMapping("/alien/{aid}")
	@ResponseBody
	public String deleteAlien(@PathVariable("aid") int aid)
	{
		Alien  a = repo.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
}
