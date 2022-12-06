package com.anil.example.springboot.service;

import java.util.List;

import com.anil.example.springboot.entity.Student;

public interface ReportsService {
	List<Student> findByReadyToTakeInterview( String fromdate,String todate);
	

}
