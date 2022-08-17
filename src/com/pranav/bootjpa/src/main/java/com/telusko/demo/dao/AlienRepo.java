package com.telusko.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

// class name Alien and primary key type is Integer
public interface AlienRepo extends CrudRepository<Alien,Integer>
{

}
