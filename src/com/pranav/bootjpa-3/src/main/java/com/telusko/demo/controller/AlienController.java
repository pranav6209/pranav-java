package com.telusko.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@Controller
public class AlienController
{
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien)
	{
		repo.save(alien);
		return "home.jsp";
	}
	
	// localhost:8080/aliens
	@RequestMapping("/aliens")
	// not returning view but return responseBody
	@ResponseBody
	public String getAliens()
	{
		// JPA internal method
		return repo.findAll().toString();
		
		
	}
	
	// localhost:8080/aliens
	@RequestMapping("/alien/{aid}")
	@ResponseBody
	
	// @PathVariable annotation can be used to handle template variables in the request URI mapping, 
	// and set them as method parameters.
	public String getAlien(@PathVariable("aid")int aid)
	{
		return repo.findById(aid).toString();
		
		
	}
}
