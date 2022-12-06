package com.anil.example.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.example.springboot.entity.Admin;
@Repository
public interface AdminRepository extends  JpaRepository<Admin, String>{
	
	Admin  findByUsername(String username);
	

}
