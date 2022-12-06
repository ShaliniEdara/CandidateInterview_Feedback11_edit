package com.anil.example.springboot.repository;

import java.util.List;

import org.hibernate.annotations.common.util.StringHelper;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.anil.example.springboot.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
    List<Student> findByName(String name);
    Student findByEmail(String email);
    
    List<Student> findByPannel(String pannel);
    
    @Query("SELECT s FROM Student s WHERE CONCAT(s.name,s.email,s.address,s.alternatePhoneNumber,s.phoneNo,s.interviewStatus,s.address,s.pincode,s.experience,s.designation,s.currentctc,s.exceptedctc,s.pannel) LIKE %?1%")
	public List<Student> findAll(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.address) LIKE %?1%")
	public List<Student> findByAddress(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.name) LIKE %?1%")
	public List<Student> findThroughName(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.email) LIKE %?1%")
	public List<Student> findThroughEmail(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.alternatePhoneNumber) LIKE %?1%")
	public List<Student> findThroughalternatePhoneNo(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.phoneNo) LIKE %?1%")
	public List<Student> findThroughPhoneNo(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.interviewStatus) LIKE %?1%")
	public List<Student> findThroughStatus(String keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.pincode) LIKE %?1%")
	public List<Student> findThroughPincode(String Keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.experience) LIKE %?1%")
	public List<Student> findThroughExperience(String Keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.designation) LIKE %?1%")
	public List<Student> findThrougheDesignation(String Keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.currentctc) LIKE %?1%")
	public List<Student> findThroughCurrentCtc(String Keyword);
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.exceptedctc) LIKE %?1%")
	public List<Student> findThroughExceptedCtc(String Keyword);
	 
	
	@Query("SELECT s FROM Student s WHERE CONCAT(s.pannel) LIKE %?1%")
	public List<Student> findThroughPannel(String Keyword);
			
	
	@Query(nativeQuery = true, value = "select * from candidates where pannel = :pannelname")
  	List<Student> findByPannelName(@Param("pannelname") String pannelname);
	
	@Query("SELECT s FROM Student s WHERE (s.interviewStatus = 'ReadytotakeInterview'  and s.createddate between :fromdate and :todate )")
	//@Query("SELECT s FROM Student s WHERE (CONCAT(s.interviewStatus) = 'interviewStatus' and CONCAT(s.createddate) between :fromdate and :todate )")
	public List<Student> findByReadyToTakeInterview(String fromdate,String todate);
	
	@Query("SELECT s FROM Student s WHERE (s.interviewStatus = 'Noteligible'  and s.createddate between :fromdate and :todate )")
    //@Query("SELECT s FROM Student s WHERE CONCAT(s.createddate) between :fromdate and :todate ")
	public List<Student> findByNoteligible(String fromdate,String todate);
	
	@Query("SELECT s FROM Student s WHERE (s.interviewStatus = 'PostponedInterview'  and s.createddate between :fromdate and :todate )")
	//@Query("SELECT s FROM Student s WHERE CONCAT(s.createddate) between :fromdate and :todate ")
	public List<Student> findByPostponedInterview(String fromdate,String todate);
	
	@Query("SELECT s FROM Student s WHERE (s.interviewStatus = 'InterviewCompleted'  and s.createddate between :fromdate and :todate )")
    //@Query("SELECT s FROM Student s WHERE CONCAT(s.createddate) between :fromdate and :todate ")
	public List<Student> findByInterviewCompleted(String fromdate,String todate);
	
	@Query("SELECT s FROM Student s WHERE (s.interviewStatus = 'Selected'  and s.createddate between :fromdate and :todate )")
    //@Query("SELECT s FROM Student s WHERE CONCAT(s.createddate) between :fromdate and :todate ")
	public List<Student> findBySelected(String fromdate,String todate);

			
			
			
			
			
    
    
}



