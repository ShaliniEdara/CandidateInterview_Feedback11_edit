package com.anil.example.springboot.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anil.example.springboot.entity.Pannel;
import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.PannelRepository;
import com.anil.example.springboot.service.PannelService;
@Service
public class PannelServiceImpl  implements PannelService{
	@Autowired
	PannelRepository pannelRepository;

	@Override
	public List<Pannel> getAllPannels() {
		List<Pannel> pannels = new ArrayList<>();
	    pannelRepository.findAll()
	    .forEach(pannels::add);
		 return pannels;
		
	}

	@Override
	public List<Pannel> findThroughPannel(String keyword) {
		// TODO Auto-generated method stub
		return pannelRepository.findThroughPannel(keyword);
	}
 
	@Override
	public List<Pannel> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return pannelRepository.findAll(keyword);
	}

	@Override
	public List<Pannel> findThroughUsername(String keyword) {
		// TODO Auto-generated method stub
		return pannelRepository.findThroughUsername(keyword);
	}

	@Override
	public List<Pannel> findThroughPassword(String keyword) {
		// TODO Auto-generated method stub
		return pannelRepository.findThroughPassword(keyword);
	}

	@Override
	public Page<Pannel> findPaginated(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return this.pannelRepository.findAll(pageable);
	}

	

	
	

}
