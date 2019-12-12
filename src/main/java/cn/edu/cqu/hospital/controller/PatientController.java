package cn.edu.cqu.hospital.controller;

import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.pojo.Reservation;
import cn.edu.cqu.hospital.service.DepartmentService;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;
import cn.edu.cqu.hospital.service.ReservationService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientService = null;
	@Autowired
	private DepartmentService departmentService = null;
	@Autowired
	private DoctorService doctorService = null;
	@Autowired
	private ReservationService reservationService = null;
	
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
	
	@RequestMapping("/getPatientByID")
	@ResponseBody
	public Patient getPatientByID(String ID, HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.patientService.getPatientByID(ID);
	}
	
	@RequestMapping("/getRemainedByIDAndDate")
	@ResponseBody
	public Integer getRemainedByIDAndDate(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		String date = request.getParameter("Date");
		
		Doctor doctor = this.doctorService.getDoctorByID(ID);
		if(doctor == null)
			return -1;
		
		int used = this.doctorService.getUsedByIDAndDate(ID, date);
		
		return doctor.getMax() - used;
	}
	
	@RequestMapping("/insertReservation")
	@ResponseBody
	public Integer insertReservation(HttpServletRequest request, HttpServletResponse response, Model model) {
		int flag = 0;
		
		String ID = request.getParameter("ID");
		String date = request.getParameter("Date");
		String doc_ID = request.getParameter("doc_ID");
		String depart_ID = request.getParameter("depart_ID");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-8:00"));
		Random random=new Random();
		
		try {
			Reservation reservation = new Reservation();
			reservation.setId(date + (int)(random.nextDouble() * 900 + 100));
			reservation.setPatientId(ID);
			reservation.setDocId(doc_ID);
			reservation.setDepartId(depart_ID);
			reservation.setState(0);
			reservation.setTime(dateFormat.parse(date));
			
			this.reservationService.createReservation(reservation);
			
			flag = 1;
		} catch (ParseException e) {
			e.printStackTrace();
			flag = 0;
		}
		
		return flag;
	}
	
}
