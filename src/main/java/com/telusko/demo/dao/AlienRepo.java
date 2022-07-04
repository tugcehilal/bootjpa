package com.telusko.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.telusko.demo.model.Alien;

//public interface AlienRepo extends CrudRepository<Alien,Integer>
public interface AlienRepo extends JpaRepository<Alien,Integer>
{
 List<Alien> findByTech(String tech);
 List<Alien> findByAidGreaterThan(int aid);
 @Query("from Alien where tech=?1 order by aname") //should be Alien not alien
 List<Alien> findByTechSorted(String tech);
 
}
