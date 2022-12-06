 package com.anil.example.springboot.controller;

import java.lang.ProcessBuilder.Redirect;
import java.security.PublicKey;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import javax.xml.crypto.Data;

import org.dom4j.tree.BackedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.anil.example.springboot.entity.Admin;
import com.anil.example.springboot.entity.Pannel;
//import com.anil.example.springboot.entity.PannerDetails;
import com.anil.example.springboot.entity.Student;
import com.anil.example.springboot.repository.AdminRepository;
import com.anil.example.springboot.repository.PannelRepository;
//import com.anil.example.springboot.repository.PannerDetailsRepository;
import com.anil.example.springboot.repository.StudentRepository;
import com.anil.example.springboot.service.PannelService;
//import com.anil.example.springboot.repository.pannelRepository;
import com.anil.example.springboot.service.StudentService;

import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping("/students/")
public class StudentController {
	
	private final StudentRepository studentRepository;

	@Autowired
	private   StudentService studentService;
	@Autowired
	private AdminRepository adminrepository;
    
	@Autowired
    private PannelRepository pR;
	HttpSession session;
	
	@Autowired
	private PannelService pannelService;
	
	

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	@GetMapping("back")
	public  String back(HttpServletRequest request) {
		session=request.getSession(false);
		if(session!=null) {
			
		}
		return "index2";
	}
	
	@GetMapping("home")
	public  String home(HttpServletRequest request,Model model) {
    session = request.getSession(false);
		
		if(session != null) {
		
		return "index-with-logout";
	}
		return "index";	
		}
	
	
	
	@GetMapping("Adminlink")
	public String adminLink(HttpServletRequest request,Model model) {

		
		session = request.getSession(false);
		
		
		
		if(session != null) {
			//String sessionid=session.getId();
			//System.out.println(sessionid);
			//String adminsessionid=session.getAttribute("adminsessionid").toString();
			//System.out.println(adminsessionid);
			try {
			if(session.getId().equals(session.getAttribute("adminsessionid").toString())) {
			
				return "index2";
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			{
			model.addAttribute("message","There is already an Active session, Please logout first to open login page");
			return "loggedinadmin";
		//return "index2";

			}
		}
		return  "index1";
	}
	

	@RequestMapping(path = "checkdetails",method = RequestMethod.POST)
	public String showSignUpForm(@RequestParam("username") String username,@RequestParam("password") String password,Model model,HttpServletRequest request) {
		/*if(username == "" && password == "") {
			model.addAttribute("message", " please enter correct username ");
			return "index1";
		}*/
	      Admin admindata=adminrepository.findByUsername(username);
	      System.out.println(admindata);
          if(admindata == null) {
				model.addAttribute("message", " please enter correct username  and paassword");
				return "index1";
				
			}
          System.out.println(admindata);
          
               if(admindata.getUsername().equals(username) && admindata.getPassword().equals(password))	
				     {
					 HttpSession session= request.getSession();
					   HttpSession id=request.getSession();
					   String adminsessionid=id.getId();
					   System.out.println(id);
					   System.out.println(adminsessionid); 
					   session.setAttribute("adminsessionid", adminsessionid);
					   
						session = request.getSession(false);
					
						if(session != null) {
							//model.addAttribute("students", studentService.getAllStudent());
						return "index2";
						}
						//return "index1";
					  
				      }else {
					        System.out.println("login not sucessfull");

                            model.addAttribute("message", " please enter correct username and password");
					        return "index1";
					        }
               return "index1";
                   }

		
	@GetMapping("adminregistrationshowup") 
	public String adminregistrationshowup() {
		System.out.println("This is showing Admin registration form") ;
		//pannerDetailsRepository.save(panner); 
		return "admin";
	} 
	
   @PostMapping("adminregistration")
	public String addAdmin(@Valid Admin admin, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "admin";
		}
		System.out.println("This is testing") ;
		adminrepository.save(admin);
		return "index1";
	}
	@GetMapping("addpannel") 
	public String addPanner(HttpServletRequest request) {
		System.out.println("This is showing pannel registration form") ;
		session=request.getSession(false);
		if(session !=null) {
			
		return "pannelreg";
		}
		return "index";
	} 

		@RequestMapping(path = "pannelcheck",method = RequestMethod.GET)
	public String pannelCheck(HttpServletRequest request) {
			
			session = request.getSession(false);
		
			if(session != null) {
		return "pannelbar1";
			}
			return "index";
	}
	
	@RequestMapping(path = "pannelview",method = RequestMethod.POST )
	public String pannelA(@PathParam("pannel") String pannel,Model model,Student student,HttpServletRequest request) {
		 System.out.println("we are in pannelview "+pannel ); 
	     
	
//		request.getSession();
		session = request.getSession(false);
	
		if(session != null) {
	    
	      
		System.out.println(studentRepository.findByPannel(pannel));
	     
	  //System.out.println( studentdata.getPannel()); 
	     model.addAttribute("students", studentRepository.findByPannel(pannel));
	     return "pannelA";
		}
		return "pannelA";
		
	    	
	}
	
	@GetMapping("candidatelink")
	public String candidateLink(HttpServletRequest request,Model model) {
		session = request.getSession(false);
//		System.out.println(request.getSession()); 
		if(session != null) {
			try {
			if(session.getId().equals(session.getAttribute("candidateidsessionid").toString())) {
				String email=session.getAttribute("email").toString();
				model.addAttribute("students", studentRepository. findByEmail(email) );
				return "candidateview";
			}
			}
			catch(Exception e) {
				System.out.println(e);
				
			}
			{
			model.addAttribute("message","There is already an Active session, Please logout first to open login page");
		//return "loggedinadmin";
		    return "loggedincandidate";
			
			//return "candidateview";
			
		}
		}
		return "canditatelogin";
	}


	@RequestMapping(path = "candidatelogincheckdetails",method = RequestMethod.POST)
	public String candidatelogincheckdetails(@PathParam("email") String email,@PathParam("phoneNo") String phoneNo, @PathParam("action") String  action,Model model,Student student,HttpServletRequest request) {
		
            Student studentdata=studentRepository. findByEmail(email);
	       if(studentdata==null) {
			    System.out.println("data is null");
				model.addAttribute("message", " please enter correct username and password");
				return "canditatelogin";

			}
            if( studentdata.getEmail().equals(email) && studentdata.getPhoneNo().equals(phoneNo))
			{
				    System.out.println("login  sucessfull");
				    HttpSession session= request.getSession();
				    HttpSession id=request.getSession();
				     String candidateidsessionid=id.getId();
					   System.out.println(id);
					   System.out.println(candidateidsessionid);
					   session.setAttribute("candidateidsessionid", candidateidsessionid);
					   session.setAttribute("email", email);
					session = request.getSession(false);
				
					if(session != null) {
					model.addAttribute("students", studentRepository. findByEmail(email) );
				    return "candidateview";
			}
					return "canditatelogin";
			}
             else {
					System.out.println("login not sucessfull");
                    model.addAttribute("message", " please enter correct username and password");
					return "canditatelogin";
					}
                }
		     
			
	
	
	@GetMapping("pannerlink")
	public String pannerLink(Model model,HttpServletRequest request) {
		session=request.getSession(false);
	    if(session != null) {
	    	
	        try {
	    	if(session.getId().equals(session.getAttribute("pannelsessionid").toString())) {
	    		String pannelname=session.getAttribute("pannelname").toString();
	    		model.addAttribute("students", studentRepository.findByPannel( pannelname));
			     return "pannelA";
	    		
	    	}
	        }catch(Exception e) {
	        	System.out.println(e);
	        }
	    	
	        {
			model.addAttribute("message","There is already an Active session, Please logout first to open login page");
		return "loggedinpannel";
		}
	    }
		return "pannellogin";
	}
	
	@RequestMapping(path = "pannerlogincheckdetails",method = RequestMethod.POST)
	public String pannerlogincheckdetails(@PathParam("username") String username,@PathParam("password") String password,@PathParam("pannel") String pannel,Model model,Pannel pannel1,HttpServletRequest request) {
		

		System.out.println(username);
        System.out.println(password);
        System.out.println(pannel);
        Pannel panneldata=pR.findByUsername(username);
	    //System.out.println(panneldata.getUsername());
	    //System.out.println(panneldata.getPassword());
	    //System.out.println(panneldata.getPannel());
              if(panneldata==null) {
            	  
				model.addAttribute("message", " please enter correct username and password");
				return "pannellogin";
				}
            
                  if(panneldata.getUsername().equals(username) && panneldata.getPassword().equals(password) )	
				     {
                	  
					   System.out.println("login  sucessfull");
					   
					   HttpSession session= request.getSession();
					   String pannelsessionid=session.getId();
					   session.setAttribute("pannelsessionid",pannelsessionid);
					   
						session = request.getSession(false);
					
						if(session != null) {
					   //model.addAttribute("students", studentService.getAllStudent());
					   //return "pannelbar1";;
							Pannel pannel2=pR.findByUsername(username);
							System.out.println(pannel2);
							String pannelname=pannel2.getPannel();
							System.out.println(pannelname);
							session.setAttribute("pannelname", pannelname);
					   
					   model.addAttribute("students", studentRepository.findByPannel( pannelname));
					     return "pannelA";
				      }
						return null;
						}else {
					        System.out.println("login not sucessfull");

                           model.addAttribute("message", " please enter correct username and password");
					        return "pannellogin";
					        }
          }
	
	//save pannel details
	@PostMapping("pannelregistration")
	public String pannelRegistration(@Valid Pannel pannel, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "pannelreg";
		}
		System.out.println("This is testing") ;
		pR.save(pannel);
		//return "redirect:list";
		return "redirect:Pannellist";
	}
	
	
	

	
	
    @RequestMapping(path = "filter",method = RequestMethod.GET)
	public String filterI(Model model,@PathParam("keyword") String keyword,@PathParam("field")String field,HttpServletRequest request){
	System.out.println(field);
	System.out.println(keyword);
	session = request.getSession(false);
	if(session != null) {
		
		switch(field) {
	       case "address" :
	    	   model.addAttribute("students",studentService.findByAddress(keyword));
	    	   model.addAttribute("keyword",keyword);
	    	   model.addAttribute("field",field);
	       
	        return "studentlist";	
	       
	       case "name"    : 
	    	   model.addAttribute("students",studentService.findThroughName(keyword));
	    	   model.addAttribute("keyword",keyword);
	    	   model.addAttribute("field",field);
	          
	       
	       return "studentlist";
	       
	       case "email" 	: model.addAttribute("students",studentService.findThroughEmail(keyword));
	                          model.addAttribute("keyword",keyword);
	       return "studentlist";
	       
	       case "alternatePhoneNumber" : model.addAttribute("students",studentService.findThroughalternatePhoneNo(keyword));
	                                     model.addAttribute("keyword",keyword);
			return "studentlist";
			
		   case "phoneNo" : model.addAttribute("students",studentService.findThroughPhoneNo(keyword));       
		                    model.addAttribute("keyword",keyword);
		   return "studentlist";
		     
           case "interviewStatus" : model.addAttribute("students",studentService.findThroughStatus(keyword));
                                    model.addAttribute("keyword",keyword);
            return "studentlist";
            
           case "pincode" : model.addAttribute("students",studentService.findThroughPincode(keyword));
                            model.addAttribute("keyword",keyword);
           return "studentlist";
           
           case "experience" : model.addAttribute("students",studentService.findThroughExperience(keyword));
                               model.addAttribute("keyword",keyword);
           return "studentlist";
           
           case "designation" : model.addAttribute("students",studentService.findThrougheDesignation(keyword));
                                model.addAttribute("keyword",keyword);
           return "studentlist";
           
           case "currentctc" : model.addAttribute("students",studentService.getAllStudent().stream().filter(x->Long.toString(x.getCurrentctc()).contains(keyword)).collect(Collectors.toList()));
                               model.addAttribute("keyword",keyword);
           		return "studentlist";
           		
           case "exceptedctc" : model.addAttribute("students",studentService.findThroughExceptedCtc(keyword));
                                model.addAttribute("keyword",keyword);
           		return "studentlist";
           		
           case "pannel" : model.addAttribute("students",studentService.findThroughPannel(keyword));
                          model.addAttribute("keyword",keyword);
           return "studentlist";
           
           default : 	model.addAttribute("students",studentService.findByKeyword(keyword));
                        model.addAttribute("keyword",keyword);
           return "studentlist";
             }
	}return "null";
}
    
    
    //Filter for pannel
    
    @RequestMapping(path = "pannelfilter",method = RequestMethod.GET)
   	public String pannelFilter(Model model,@PathParam("keyword") String keyword,@PathParam("field")String field,HttpServletRequest request) {
   	System.out.println(field);
   	System.out.println(keyword);
   	session = request.getSession(false);
   	if(session != null) {
   		switch(field) {
   	       case "username" : model.addAttribute("pannels",pannelService.findThroughUsername(keyword));
   	                         model.addAttribute("keyword", keyword);
   	                         model.addAttribute("field", field);
   	                        
   	        return "pannellist";	
   	        
   	       case "password" : model.addAttribute("pannels",pannelService.findThroughPassword(keyword));
   	       
   	                           model.addAttribute("keyword", keyword);
   	        return "pannellist";
   	        
   	       case "pannel": model.addAttribute("pannels",pannelService.findThroughPannel(keyword));
   	                       model.addAttribute("keyword", keyword);
   	        return "pannellist";
   	    default : model.addAttribute("pannels",pannelService.findByKeyword(keyword));
        return "pannellist";
   	        
               }
   		
   	}
   	return null;
    }
	
 @GetMapping("/page/{pageNo}")
	 public String findPaginated(@PathVariable ("pageNo") int pageNo, Model model){
	 
		 int pageSize=5;
		System.out.println("we are in pagination");
	    Page<Student> page= studentService.findPaginated(pageNo, pageSize);
		 List<Student> students=page.getContent();
		 model.addAttribute("currentPage",pageNo);
		 model.addAttribute("totalPages",page.getTotalPages());
		 model.addAttribute("totalItems",page.getTotalElements());
		 model.addAttribute("students", students);
		 System.out.println("we are in pagination end");
		
		 return "studentlist";
		 //return "redirect:list";
		 }
		
 
 @GetMapping("/pannelpage/{pageNo}")
 public String findPaginatedPannel(@PathVariable ("pageNo") int pageNo, Model model,HttpServletRequest request ) {
	 session = request.getSession(false);
		if(session != null) {
	 int pageSize=5;
	System.out.println("we are in pagination");
    Page<Pannel> page= pannelService.findPaginated(pageNo, pageSize);
	 List<Pannel> pannels=page.getContent();
	 model.addAttribute("currentPage",pageNo);
	 model.addAttribute("totalPages",page.getTotalPages());
	 model.addAttribute("totalItems",page.getTotalElements());
	 model.addAttribute("pannels", "pannels");
	 System.out.println("we are in pagination end");
	
	 return "pannellist";
	 //return "redirect:list";
	 
	}
		return "index";
 }

 

 
 
 


	@GetMapping("signup")
	public String showSignUpForm(Student student,HttpServletRequest request) {
		session = request.getSession(false);
		if(session != null) {
		
		return "add-student";
		}
		return null;
	}

	@GetMapping("list")
	public String showUpdateForm(Model model,HttpServletRequest request) {
		
		session = request.getSession(false);
		if(session != null) {
		model.addAttribute("students", studentService.getAllStudent());
		//return "student";
		return findPaginated(1,model);
	}
		model.addAttribute("message", "there is no active session");
		System.out.println("i am printing because of invalid session");
		
		return "index";
	}
	
	//show the pannel list
	@GetMapping("Pannellist")
	public String showPannelList(Model model,HttpServletRequest request) {
		session = request.getSession(false);
		if(session != null) {
		model.addAttribute("pannels", pannelService.getAllPannels());
		//return findPaginatedPannel(1,model);
		return "pannellist";
		}
		model.addAttribute("message", "there is no active session");
		System.out.println("i am printing because of invalid session");
		
		return "index";
	}
	
	/*@GetMapping("list")
	 public String showUpdateForm (Model model) {
		 return findPaginated(1,model);//1 default page no 
	 }*/
	
	@PostMapping("add")
	public String addStudent(@Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-student";
		}
		System.out.println("This is testing") ;
		studentService.addStudent(student);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model,HttpServletRequest request) {
		session = request.getSession(false);
	   	if(session != null) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "update-student";
	   	}return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStudent(@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			student.setId(id);
			return "update-student";
		}

		studentService.addStudent(student);
		model.addAttribute("students", studentService.getAllStudent());
		return findPaginated(1, model);
	}
	
	
	//pannelassigned candidates edit & update
	
	@GetMapping("pannelcandidateedit/{id}")
	public String showUpdateFormPannelCandidate(@PathVariable("id") long id, Model model,HttpServletRequest request) {
		session = request.getSession(false);
	   	if(session != null) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "updatebypannelcandidate";
	   	}
	   	return null;
	}

	@PostMapping("pannelcandidateupdate/{id}")
	public String updateStudentPannelCandidate(@PathParam("action") String  action,@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		System.out.println(action);
		if("Update Candidate".equals(action)){
		if (result.hasErrors()) {
			student.setId(id);
			
			return "pannelA";
		}

		studentService.addStudent(student);
		String pannel=student.getPannel();
		System.out.println(pannel);
		
		
		model.addAttribute("students", studentRepository.findByPannel(pannel));
		//return findPaginated(1, model);
		return "pannelA";
	}
		else if("cancel".equals(action)){
			String pannel=student.getPannel();
			System.out.println(pannel);
		   model.addAttribute("students", studentRepository.findByPannel(pannel));
            return "pannelA";
			}
		return null;
	}

	
	
	
	
	//pannelmember edit and update
	
	@GetMapping("panneledit/{username}")
	public String PannelshowUpdateForm(@PathVariable("username") String username, Model model,HttpServletRequest request) {
		System.out.println(username);
		session = request.getSession(false);
	   	if(session != null) {
		Pannel pannel = pR.findByUsername(username);
				//.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + username));
		model.addAttribute("pannels", pannel);
		return "updatepannel";
	   	}
	   	return "index";
	}

	@PostMapping("updatepannel/{username}")
	public String Pannelupdate(@PathVariable("username") String username, @Valid Pannel pannel, BindingResult result,
			Model model) {
		System.out.println(username);
		System.out.println(result);
		System.out.println(pannel);
		if (result.hasErrors()) {
			pannel.setUsername(username);
			return "updatepannel";
		}
        pR.save(pannel);
		model.addAttribute("pannels", pannelService.getAllPannels());
		return "pannellist";
	}
	
	

		
	
	
	//edit for candidate
	@GetMapping("candidateedit/{id}")
	public String showUpdateForm1(@PathVariable("id") long id, Model model,HttpServletRequest request) {
		session = request.getSession(false);
	   	if(session != null) {
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		model.addAttribute("student", student);
		return "candidate-update";
	   	}
	   	return null;
	}

	@PostMapping("candidateupdate/{id}")
	public String updateStudent1(@PathParam("action") String  action,@PathVariable("id") long id, @Valid Student student, BindingResult result,
			Model model) {
		System.out.println("hi");
		System.out.println(action);
		if("Update Candidate".equalsIgnoreCase(action))
		{
		if (result.hasErrors()) {
			System.out.println("THis the id i am carrying  " +id);
			student.setId(id);
//			model.addAttribute("student",student);
			
			return "candidate-update";
		}

		studentService.addStudent(student);
		model.addAttribute("students", student);
		System.out.println(student);
		return "candidateview";
	}else if("cancel".equalsIgnoreCase(action)) {
		System.out.println("hi");
		String username=student.getEmail();
		System.out.println(username);
		model.addAttribute("students", studentRepository.findByEmail(username));
	    return "candidateview";
		
	}
		return "candidateview";
	}
	
	
	
	

	@GetMapping("delete/{id}")
	public String deleteStudent(@PathVariable("id") long id, Model model) {
		/* .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id)); */	
		System.out.println("This is inside delete");
		model.addAttribute("alert", "Are you sure delete the candidate");
		studentService.deleteStudentById(id);
		
		model.addAttribute("students", studentService.getAllStudent());
		//return "studentlist";
		return findPaginated(1, model);
	} 
	
	//pannel delete 
	@GetMapping("panneldelete/{username}")
	public String deletePannel(@PathVariable("username") String username, Model model,Pannel p) {
		System.out.println(username);
		/* .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id)); */	
		System.out.println("This is inside delete");
		model.addAttribute("alert", "Are you sure delete the candidate");
		//pannelService.deletePannelById(id);
		//
	Pannel pannel= pR.findByUsername(username)	;
	System.out.println(p);
	//pR.deleteByUserName(username);
	pR.delete(pannel);
	
			//pannelService.deletePannelByUserName(username);
		
		model.addAttribute("pannels", pannelService.getAllPannels());
		return "pannellist";
	} 
	
	
	
	
	
	
	
	
	@GetMapping("logout")
	public String logoutAction(HttpServletRequest request) {
		System.out.println("hi");
		
		request.getSession();
		session = request.getSession(false);
		
		session.invalidate();
		
		return "index";
	}
	
	
	/*@RequestMapping(path = "candidatefilter",method = RequestMethod.GET)
	public String filtercandidate(Model model,@PathParam("keyword") String keyword,@PathParam("field")String field,HttpServletRequest request){
	System.out.println(field);
	session = request.getSession(false);
	if(session != null) {
		
		switch(field) {
	       case "address" : model.addAttribute("students",studentService.findByAddress(keyword));
	        return "pannelA";	
	       
	       case "name"    : model.addAttribute("students",studentService.findThroughName(keyword));
	       return "pannelA";
	       
	       case "email" 	: model.addAttribute("students",studentService.findThroughEmail(keyword));
	       return "pannelA";
	       
	       case "alternatePhoneNumber" : model.addAttribute("students",studentService.findThroughalternatePhoneNo(keyword));
			return "pannelA";
			
		   case "phoneNo" : model.addAttribute("students",studentService.findThroughPhoneNo(keyword));
		   
            return "pannelA";
		     
           case "interviewStatus" : model.addAttribute("students",studentService.findThroughStatus(keyword));
            return "pannelA";
            
           case "pincode" : model.addAttribute("students",studentService.findThroughPincode(keyword));
           return "pannelA";
           
           case "experience" : model.addAttribute("students",studentService.findThroughExperience(keyword));
           return "pannelA";
           
           case "designation" : model.addAttribute("students",studentService.findThrougheDesignation(keyword));
           return "pannelA";
           
           case "currentctc" : model.addAttribute("students",studentService.getAllStudent().stream().filter(x->Long.toString(x.getCurrentctc()).contains(keyword)).collect(Collectors.toList()));
           		return "pannelA";
           		
           case "exceptedctc" : model.addAttribute("students",studentService.findThroughExceptedCtc(keyword));
           		System.out.println("ENtered into expected CTC");
           		return "pannelA";
           		
           case "pannel" : model.addAttribute("students",studentService.findThroughPannel(keyword));
           return "pannelA";
           
           default : 	model.addAttribute("students",studentService.findByKeyword(keyword));
           return "pannelA";
             }
	}return "null";
}*/
    
	
	
		
	//creating cookie
	@GetMapping("cookie")
	public String createCookie(HttpServletResponse response){
		Cookie cookie=new Cookie("field","key");
		cookie.setSecure(true);
		cookie.setPath("/");
		response.addCookie(cookie);
			
		return null;
	}
	
	
	
}