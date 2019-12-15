package cn.edu.cqu.hospital.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.pojo.Queue;
import cn.edu.cqu.hospital.pojo.Register;
import cn.edu.cqu.hospital.pojo.Reservation;
import cn.edu.cqu.hospital.pojo.Triage;
import cn.edu.cqu.hospital.pojo.TriageWithQueue;
import cn.edu.cqu.hospital.service.DepartmentService;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;
import cn.edu.cqu.hospital.service.PrescriptionService;
import cn.edu.cqu.hospital.service.QueueService;
import cn.edu.cqu.hospital.service.RegisterService;
import cn.edu.cqu.hospital.service.ReservationService;
import cn.edu.cqu.hospital.service.TriageService;

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
	@Autowired
	private PrescriptionService prescriptionService = null;
	@Autowired
	private TriageService triageService = null;
	@Autowired
	private QueueService queueService = null;
	@Autowired
	private RegisterService registerService = null;
	
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
	
	@RequestMapping("/Wait_check")
	public String Wait_check(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Wait_check";
	}
	
	@RequestMapping("/Prescription_check")
	public String Prescription_check(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Prescription_check";
	}
	
	@RequestMapping("/RervLists_patient")
	public String RervLists_patient(HttpServletRequest request,Model model) {
		return "RervLists_patient";
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
	
	@RequestMapping("/getReservationByPatient")
	@ResponseBody
	public List<Reservation> getReservationByPatient(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		List<Reservation> res = this.reservationService.getReservationsByPatient(ID);
		
		return res;
	}
	
	@RequestMapping("/cancelReservationByID")
	@ResponseBody
	public Integer cancelReservationByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		
		Reservation reservation = this.reservationService.getReservationByID(ID);
		if(reservation == null)
			return 0;
		
		Patient patient = this.patientService.getPatientByID(reservation.getPatientId());
		if(patient == null)
			return 0;
		
		patient.setCanceltime(patient.getCanceltime() + 1);
		if(this.patientService.updatePatient(patient) == 0)
			return 0;
		
		reservation.setState(2);
		return this.reservationService.updateReservation(reservation);
	}
	
	@RequestMapping("/getPrescriptionsByPatient")
	@ResponseBody
	public List<Prescription> getPrescriptionsByPatient(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		
		List<Prescription> res = this.prescriptionService.getPrescriptionByPatient(ID);
		
		Iterator<Prescription> it = res.iterator();
		while(it.hasNext()) {
			Prescription p = it.next();
			if(p.getState() != 2 && p.getState() != 3 && p.getState() != 4 && p.getState() != 5)
				it.remove();
		}
		
		return res;
	}
	
	@RequestMapping("/getIndexByID")
	@ResponseBody
	public List<TriageWithQueue> getIndexByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String patient_ID = request.getParameter("patient_ID");
		List<TriageWithQueue> res = new ArrayList<TriageWithQueue>();
		
		List<Triage> triages = this.triageService.getTriagesByPatient(patient_ID);
		
		for(Triage t : triages) {
			Queue q = this.queueService.getQueueByID(t.getQueue());
			Register r = this.registerService.getRegisterByID(t.getRegisterId());
			
			if(r == null || q == null)
				continue;
			
			TriageWithQueue tmp = new TriageWithQueue();
			tmp.setDepart_ID(r.getDepartId());
			tmp.setDoc_ID(r.getDocId());
			tmp.setQueue_ID(t.getQueue());
			tmp.setRegister_ID(t.getRegisterId());
			tmp.setIndex(t.getIndex());
			tmp.setRemained(t.getIndex() - q.getCurIndex());
			
			res.add(tmp);
		}
		
		return res;
	}
}
