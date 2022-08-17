package com.livecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		
		
		// here we are manually creating a object 
		// Alien a = new Alien();
		
		
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(DemoApplication.class, args);
		
		// even if we do not create an object, it will be created and kept in a spring 
		// container to serve an application.
		
		//object will be created once.
		Alien a = configurableApplicationContext.getBean(Alien.class);
		
		a.show();
		
//		Alien a1 = configurableApplicationContext.getBean(Alien.class);
//		
//		a1.show();
		
	}

}
