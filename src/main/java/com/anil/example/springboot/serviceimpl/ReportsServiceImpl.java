package com.anil.example.springboot.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.ReportsService;
import com.anil.example.springboot.service.StudentService;

@Service
public class ReportsServiceImpl implements ReportsService{
	 @Autowired
	    private StudentRepository studentRepository;

	@Override
	public List<Student> findByReadyToTakeInterview(String fromdate, String todate) {
		
		return  studentRepository.findByReadyToTakeInterview(fromdate,todate);
	}

}
