package cn.edu.cqu.hospital.controller;

import java.util.List;
import java.util.ArrayList;

import javax.faces.flow.builder.ReturnBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Department;
import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.service.DepartmentService;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService = null;
	@Autowired
	private DepartmentService departmentService = null;
	@Autowired
	private DoctorService doctorService = null;
	
	@RequestMapping("/getAllDepartments")
	@ResponseBody
	public List<Department> getAllDepartments(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Department> res = this.departmentService.getAllDepartments();

		return res;
	}
	
	@RequestMapping("/getGoodDoctorByDepartment")
	@ResponseBody
	public List<Doctor> getGoodDoctorByDepartment(String ID, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Doctor> res = this.doctorService.getGoodDoctorByDepartment(ID);
		
		return res;
	}
	
	@RequestMapping("/DeptLists_patient")
	public String DeptLists_patient(HttpServletRequest request,Model model) {
		return "DeptLists_patient";
	}	
	
	@RequestMapping("/doctors_oneDept")
	public String doctors_oneDept(HttpServletRequest request,Model model) {
		return "doctors_oneDept";
	}
	
	@RequestMapping("/doctorLists_index")
	public String doctorLists_index(HttpServletRequest request,Model model) {
		return "doctorLists_index";
	}
	
}
