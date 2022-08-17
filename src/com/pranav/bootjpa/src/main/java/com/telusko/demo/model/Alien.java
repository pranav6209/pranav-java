package com.telusko.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;


// it will create a table and in h2 database.
// can be accessed at localhost:8080/h2
// with driver url spring.datasource.url=jdbc:h2:mem:navin
// @Entity annotation specifies that the class is an entity and is mapped to a database http://localhost:8080/h2-console/

@Entity
public class Alien {
@Id
	private int aid;
	private String aname;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() { 
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}

}
