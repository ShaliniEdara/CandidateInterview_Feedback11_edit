package com.anil.example.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.ReportsService;
import com.anil.example.springboot.service.StudentService;

import javassist.expr.NewArray;

@Controller
@RequestMapping("/students/")

public class ReportsController {
	@Autowired
	private   StudentService studentService;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ReportsService reportsService;
	
	@GetMapping("reports")
	public String reportsShowPage(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
		return "reports";
        }
		return null;
	}
	
	@RequestMapping(path = "reports1",method = RequestMethod.GET)
	public String reports1(Model model,@PathParam("fromdate") String fromdate,@PathParam("todate") String todate,@PathParam("interviewStatus")String interviewStatus,HttpServletRequest request){
		HttpSession session = request.getSession(false);
		if(session != null) {
			
		switch(interviewStatus) {
		case "ReadytotakeInterview":
			
			List<Student> list=reportsService.findByReadyToTakeInterview(fromdate,todate);
	        model.addAttribute("totalcandidates", list.size());
			model.addAttribute("students",reportsService.findByReadyToTakeInterview(fromdate,todate));
			model.addAttribute("fromdate", fromdate);
			model.addAttribute("todate", todate);
			model.addAttribute("interviewStatus", interviewStatus);
			return "reports";
			
		case "Noteligible":
			List<Student> list1=studentRepository.findByNoteligible(fromdate,todate);
	        model.addAttribute("totalcandidates", list1.size());
			model.addAttribute("students",studentRepository.findByNoteligible(fromdate,todate));
			model.addAttribute("fromdate", fromdate);
			model.addAttribute("todate", todate);
			model.addAttribute("interviewStatus", interviewStatus);
			System.out.println("studentRepository.findByNoteligible(fromdate,todate)");
			return "reports";
        
		case "PostponedInterview":
			List<Student> list2=studentRepository.findByPostponedInterview(fromdate,todate);
	        model.addAttribute("totalcandidates", list2.size());
			model.addAttribute("students",studentRepository.findByPostponedInterview(fromdate,todate));
			model.addAttribute("fromdate", fromdate);
			model.addAttribute("todate", todate);
			model.addAttribute("interviewStatus", interviewStatus);
			System.out.println(studentRepository.findByPostponedInterview(fromdate,todate));
			return "reports";
			
		case "InterviewCompleted":
			
			List<Student> list3=studentRepository.findByInterviewCompleted(fromdate,todate);
	        model.addAttribute("totalcandidates", list3.size());
			model.addAttribute("students",studentRepository.findByInterviewCompleted(fromdate,todate));
			model.addAttribute("fromdate", fromdate);
			model.addAttribute("todate", todate);
			model.addAttribute("interviewStatus", interviewStatus);
			System.out.println(studentRepository.findByInterviewCompleted(fromdate,todate));
			return "reports";
			
		case "Selected":
			List<Student> list4=studentRepository.findBySelected(fromdate,todate);
	        model.addAttribute("totalcandidates", list4.size());
			model.addAttribute("students",studentRepository.findBySelected(fromdate,todate));
			model.addAttribute("fromdate", fromdate);
			model.addAttribute("todate", todate);
 			model.addAttribute("interviewStatus", interviewStatus);
			System.out.println(studentRepository.findBySelected(fromdate,todate));
			return "reports";
			}
		return "reports";
		}
		return null;
	}
}
