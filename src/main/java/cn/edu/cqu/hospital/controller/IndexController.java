package cn.edu.cqu.hospital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/index_doctor")
	public String index_doctor(HttpServletRequest request,Model model) {
		return "index_doctor";
	}
	
	@RequestMapping("/index_chemist")
	public String index_chemist(HttpServletRequest request,Model model) {
		return "index_doctor";
	}
	
	@RequestMapping("/index_collector")
	public String index_collector(HttpServletRequest request,Model model) {
		return "index_ollector";
	}
	
	@RequestMapping("/index_dispenser")
	public String index_dispenser(HttpServletRequest request,Model model) {
		return "index_dispenser";
	}

	@RequestMapping("/tabs_doctors")
	public String tabs_doctors(HttpServletRequest request,Model model) {
		return "tabs_doctors";
	}
	
	@RequestMapping("/DeptLists_patient")
	public String DeptLists_patient(HttpServletRequest request,Model model) {
		return "DeptLists_patient";
	}	
	
	@RequestMapping("/RervLists_patient")
	public String RervLists_patient(HttpServletRequest request,Model model) {
		return "RervLists_patient";
	}	
}
