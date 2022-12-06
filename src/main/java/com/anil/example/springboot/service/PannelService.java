package com.anil.example.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.anil.example.springboot.entity.Pannel;
import com.anil.example.springboot.entity.Student;

public interface PannelService {
	List<Pannel> getAllPannels();
	
	//Pannel deletePannelByUserName(String username);
	
	List<Pannel>  findThroughPannel(String keyword);
	
	List<Pannel>  findThroughUsername(String keyword);
	
	List<Pannel>  findThroughPassword(String keyword);
	
	
	List<Pannel> findByKeyword(String keyword);
	
	Page<Pannel> findPaginated(int pageNo,int pageSize);
	
	
}
