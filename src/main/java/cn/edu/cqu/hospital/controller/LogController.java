package cn.edu.cqu.hospital.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Chemist;
import cn.edu.cqu.hospital.pojo.Collector;
import cn.edu.cqu.hospital.pojo.Dispenser;
import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.service.ChemistService;
import cn.edu.cqu.hospital.service.CollectorService;
import cn.edu.cqu.hospital.service.DispenserService;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	private PatientService patientService = null;
	@Autowired
	private DoctorService DoctorService = null;
	@Autowired
	private CollectorService CollectorService = null;
	@Autowired
	private ChemistService ChemistService = null;
	@Autowired
	private DispenserService DispenserService = null;

	@RequestMapping("/login")
	public String login(HttpServletRequest request,Model model) {
    	System.out.println("------进入/log/login------");
		
		String IDCookie = null;
    	String passwordCookie = null;
    	
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null) {
    		for (Cookie cookie : cookies) {
    			// 得到cookie的用户名
    	        if (cookie.getName().equals("loginID"))
    	        	IDCookie = cookie.getValue(); 

    	        // 得到cookie的密码
    	        if (cookie.getName().equals("loginPassword"))
    	        	passwordCookie = cookie.getValue(); 

    		}
    		if (IDCookie != null && passwordCookie != null) {
    			Patient account = this.patientService.getPatientByID(IDCookie);
    			if(account != null && account.getPassword().equals(passwordCookie)) {
    				model.addAttribute("account", account);
    				System.out.println("准备回到redirect:/");
    				return "redirect:/";
    			}
    		}
    	}
    	System.out.println("准备回到login");
		return "login";
	}	
	
	@RequestMapping("/validate")
	@ResponseBody
	public String validate(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		System.out.println(userType);
		
		if(userType.equals("patient")) {
			Patient patient = this.patientService.getPatientByID(ID);
			System.out.println(ID);
			System.out.println(patient.getPassword());
	    	if(patient != null) {
	    		if(patient.getPassword().equals(password)) {	
		    	    Cookie IDCookie = new Cookie("loginID", ID);  
		    	    Cookie passwordCookie = new Cookie("loginPassword", password);  
		    	    IDCookie.setMaxAge(60 * 60);  
		    	    IDCookie.setPath("/");  
		    	    passwordCookie.setMaxAge(60 * 60);  
		    	    passwordCookie.setPath("/");  
		    	    response.addCookie(IDCookie);  
		    	    response.addCookie(passwordCookie); 
		   
		    	    model.addAttribute("patient", patient);
		    		
		            return "/index.jsp"; 
		    	}
	    	}
		}
		
		else if(userType.equals("doctor")) {
			Doctor doctor = this.DoctorService.getDoctorByID(ID); 
			if(doctor != null) {
				if(doctor.getPassword().equals(password))
					return "/index_doctor";
			}
		}
		
		else if(userType.equals("chemist")) {
			Chemist chemist = this.ChemistService.getChemistByID(ID);
			if(chemist != null) {
				if(chemist.getPassword().equals(password))
					return "/index_chemist";
			}
		}
		
		else if(userType.equals("dispenser")) {
			Dispenser dispenser = this.DispenserService.getDispenserByID(ID);
			if(dispenser != null) {
				if(dispenser.getPassword().equals(password))
					return "/index_dispenser";
			}
		}
		
		else if(userType.equals("collector")) {
			Collector collector = this.CollectorService.getCollectorByID(ID);
			if(collector != null) {
				if(collector.getPassword().equals(password))
					return "/index_collector";
			}
		}
    	
    	model.addAttribute("flag", 1);
    	return "/log/login";	
	}
	
	@RequestMapping("/goRegister")
	public String goRegister(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "register";
	}
	
	@RequestMapping("/doRegister")
	@ResponseBody
	public Integer doRegister(String ID, String name, String password, String phone, String sex, HttpServletResponse response, Model model) {
		Patient patient = new Patient();
		patient.setId(ID);
		patient.setName(name);
		patient.setPhone(phone);
		patient.setSex(Integer.parseInt(sex));
		patient.setPassword(password);
		
		int flag = this.patientService.createPatient(patient);
		
		if(flag == 0)
			return flag;
		
	    Cookie IDCookie = new Cookie("loginID", ID);  
	    Cookie passwordCookie = new Cookie("loginPassword", password);  
	    IDCookie.setMaxAge(60 * 60);  
	    IDCookie.setPath("/");  
	    passwordCookie.setMaxAge(60 * 60);  
	    passwordCookie.setPath("/");  

		response.addCookie(IDCookie);  
	    response.addCookie(passwordCookie); 	
		
		return flag;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
        //删除登录cookie  
		System.out.println("-----------进入/log/logout");
        Cookie cookieUserID = new Cookie("loginID", "");  
        Cookie cookiePassword = new Cookie("loginPassword", "");  
        cookieUserID.setMaxAge(0);  
        cookieUserID.setPath("/");  
        cookiePassword.setMaxAge(0); 
        cookiePassword.setPath("/");  
        response.addCookie(cookieUserID);  
        response.addCookie(cookiePassword);  
       
		return "redirect:/log/login";
	}
}
