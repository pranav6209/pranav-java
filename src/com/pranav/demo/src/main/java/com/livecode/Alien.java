package com.livecode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
// make this as a spring bean

// by default instance will be created with (alien.class) but if we want to use 
// specific name we can use @Component()  
@Component

// if we use a prototype, bean will be created only when getBean() is called. 
//@Scope(value = "prototype")
public class Alien {

	private int aid;
	private String aName;
	private int tech;
	
	// Alien class is dependent on laptop
	// search for laptop object in spring container by type
	@Autowired
	
	
	// searches by name.  
	// @Qualifier("lap1") // search by name  
	private Laptop laptop;
	
	
	
	
	public Alien() {
		super();
		System.out.println("Object Created");
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public int getTech() {
		return tech;
	}
	public void setTech(int tech) {
		this.tech = tech;
	}
	

	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public void show() {
		
		System.out.println("in show");
		laptop.compile();
	}
	
}
