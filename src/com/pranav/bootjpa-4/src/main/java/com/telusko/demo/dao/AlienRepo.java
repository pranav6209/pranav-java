package com.telusko.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

import java.util.List;


// instead of crud extends jpa repository as it supports pagination  and sorting and then it also extends crud repo 
public interface AlienRepo extends JpaRepository<Alien,Integer>
{

}
