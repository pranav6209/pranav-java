package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer>
{
	
// method should start with findBy and getBy 	
List<Alien> findByTech(String tech);

List<Alien> findByAidGreaterThan(int aid);


// jpql query ? means data coming from user question mark no as we might have multiple input coming 
@Query("from Alien where tech=?1 order by aname")
List<Alien>findByTechSorted(String tech);

}
