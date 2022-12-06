package com.anil.example.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anil.example.springboot.entity.Admin;
import com.anil.example.springboot.entity.Pannel;
import com.anil.example.springboot.entity.Student;
@Repository
public interface PannelRepository  extends JpaRepository<Pannel, String>{
	Pannel findByUsername(String username);
	Pannel findByPannel(String pannel);
	
	@Modifying 
	@Query(value = "DELETE FROM Pannel WHERE username = :username",nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    int deleteByUserName(@Param("username") String username); 
	
	 @Query("SELECT p FROM Pannel p WHERE CONCAT(p.username,p.password,p.pannel) LIKE %?1%")
		public List<Pannel> findAll(String keyword);
		
	
	@Query("SELECT p FROM Pannel p WHERE CONCAT(p.pannel) LIKE %?1%")
	public List<Pannel> findThroughPannel(String Keyword);
	
	@Query("SELECT p FROM Pannel p WHERE CONCAT(p.username) LIKE %?1%")
	public List<Pannel> findThroughUsername(String Keyword);
	
	@Query("SELECT p FROM Pannel p WHERE CONCAT(p.password) LIKE %?1%")
	public List<Pannel> findThroughPassword(String Keyword);
			
			 
			
			
	
	
	
	
	

}
