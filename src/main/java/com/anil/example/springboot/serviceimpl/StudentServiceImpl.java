package com.anil.example.springboot.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.StudentService;

@Service
public  class StudentServiceImpl implements StudentService
{
    @Autowired
    private StudentRepository studentRepository;
    
    @Override 
	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<>();
	    studentRepository.findAll()
	    .forEach(students::add);
		 return students;
	}
	
	public Student addStudent(Student student) {
	     return studentRepository.save(student);
	}
	
	public Student getStudent(long id) {
	     return studentRepository.findById(id)
	    		 .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
	}
		
	@Override
	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
		
	}

	
	public void updateStudent(String id, Student student) {
	     studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Student student) {
		// TODO Auto-generated method stub
		
	}	
	@Override
	public Object findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(@Valid Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student findByEmail(String email) {
		// TODO Auto-generated method stub
		return studentRepository.findByEmail(email);
	}

	
	@Override
	public List<Student> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findAll(keyword);
	}

	
	
	@Override
	public List<Student> findAll(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize) {
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		return this.studentRepository.findAll(pageable);
	}

	@Override
	public List<Student> findByAddress(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findByAddress(keyword);
	}

	@Override
	public List<Student> findThroughName(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughName(keyword);
	}

	@Override
	public List<Student> findThroughEmail(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughEmail(keyword);
	}

	@Override
	public List<Student> findThroughalternatePhoneNo(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughalternatePhoneNo(keyword);
	}

	@Override
	public List<Student> findThroughPhoneNo(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughPhoneNo(keyword);
	}

	@Override
	public List<Student> findThroughStatus(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughStatus(keyword);
	}

	@Override
	public List<Student> findThroughPincode(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughPincode(keyword);
	}

	@Override
	public List<Student> findThroughExperience(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughExperience(keyword);
	}

	@Override
	public List<Student> findThrougheDesignation(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThrougheDesignation(keyword);
	}

	
	@Override
	public List<Student> findThroughPannel(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughPannel(keyword);
	}

	@Override
	public List<Student> findThroughExceptedCtc(String keyword) {
		// TODO Auto-generated method stub
		return studentRepository.findThroughExceptedCtc(keyword);
	}

}