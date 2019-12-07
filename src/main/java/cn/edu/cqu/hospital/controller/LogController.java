package cn.edu.cqu.hospital.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.service.PatientService;

@Controller
@RequestMapping("/log")
public class LogController {
	@Autowired
	PatientService patientService = null;

	public String login(HttpServletRequest request,Model model) {
    	System.out.println("进入/log/login");
		
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

}
