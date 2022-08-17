package com.livecode;

import org.springframework.stereotype.Component;


//by default instance will be created with (laptop.class) but if we want to use 
//specific name we can use @Component("lap1")  
@Component
public class Laptop {

	// laptop Id
	private int lid;
	private String brand;

	public int getLid() {
		return lid;
	}


	public void setLid(int lid) {
		this.lid = lid;
	}


	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + "]";
	}


	public void compile() {
		System.out.println("Compiling");
	}

}
