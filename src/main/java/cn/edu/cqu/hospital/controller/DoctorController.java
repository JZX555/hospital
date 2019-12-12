package cn.edu.cqu.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.pojo.PatientWithRecord;
import cn.edu.cqu.hospital.pojo.Queue;
import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;
import cn.edu.cqu.hospital.pojo.Register;
import cn.edu.cqu.hospital.pojo.Triage;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;
import cn.edu.cqu.hospital.service.QueueService;
import cn.edu.cqu.hospital.service.RecordService;
import cn.edu.cqu.hospital.service.RegisterService;
import cn.edu.cqu.hospital.service.TriageService;

@SessionAttributes(value = {"record_ID"})
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService = null;
	@Autowired
	private RecordService recordService = null;
	@Autowired
	private PatientService patientService = null;
	@Autowired
	private QueueService queueService = null;
	@Autowired
	private TriageService triageService = null;
	@Autowired
	private RegisterService registerService = null;
	
	@RequestMapping("/consult_doctor")
	public String consult_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "consult_doctor";
	}
	
	@RequestMapping("/editRecord")
	public String editRecord(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editRecord";
	}
	
	@RequestMapping("/editRequisition")
	public String editRequisition(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editRequisition";
	}
	
	@RequestMapping("/editPrescription")
	public String editPrescription(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editPrescription";
	}
	
	@RequestMapping("/viewHistoricalRec")
	public String viewHistoricalRec(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "viewHistoricalRec";
	}
	
	@RequestMapping("/getNextPatientByDoctor")
	@ResponseBody
	public Register getNextPatientByDocto(String ID, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession httpSession) {
		System.out.println("123:::"+ID);
		Doctor doctor = this.doctorService.getDoctorByID(ID);
		if(doctor == null)
			return null;
		
		String qID = doctor.getQueue();
		String prio_qID = doctor.getPrioQueue();
		
		Queue queue = this.queueService.getQueueByID(qID);
		Queue prio_queue = this.queueService.getQueueByID(prio_qID);
		
		if(queue == null || prio_queue == null)
			return null;
		
		if(!this.queueService.isEmptyByID(prio_qID)) {
			int cur_index = this.queueService.nextIndexByID(prio_qID);
			Triage triage = this.triageService.getByQueueAndIndex(prio_qID, cur_index);
			Register register = this.registerService.getRegisterByID(triage.getRegisterId());
			
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	        Date date = new Date();
	        String dateID = sdf.format(date).toString();
			
			RecordWithBLOBs r = new RecordWithBLOBs();
			String r_ID = register.getPatientId() + ID + dateID;
			r.setId(r_ID);
			r.setPatientId(register.getPatientId());
			r.setDocId(ID);
			r.setTime(date);
			this.recordService.createRecord(r);
			
			model.addAttribute("record_ID", r_ID);
			
			return register;   
		}
		
		if(!this.queueService.isEmptyByID(qID)) {
			int cur_index = this.queueService.nextIndexByID(qID);
			Triage triage = this.triageService.getByQueueAndIndex(qID, cur_index);
			Register register = this.registerService.getRegisterByID(triage.getRegisterId());
			
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date date = new Date();
	        String dateID = sdf.format(date).toString();
			
			RecordWithBLOBs r = new RecordWithBLOBs();
			String r_ID = register.getPatientId() + ID + dateID;
			r.setId(r_ID);
			r.setPatientId(register.getPatientId());
			r.setDocId(ID);
			r.setTime(date);
			this.recordService.createRecord(r);
			
			model.addAttribute("record_ID", r_ID);
			
			return register;   
		}   
		
		return null;
	}
	
	@RequestMapping("/getRecordByID")
	@ResponseBody
	public PatientWithRecord getRecordByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		
		RecordWithBLOBs recordWithBLOBs = this.recordService.getRecordByID(ID);
		if(recordWithBLOBs == null)
			return null;
		
		Patient patient = this.patientService.getPatientByID(recordWithBLOBs.getPatientId());
		if(patient == null)
			return null;
		
		PatientWithRecord res = new PatientWithRecord();
		res.setPatient(patient);
		res.setRecordWithBLOBs(recordWithBLOBs);
		
		return res;
	}
	
	@RequestMapping("/updatetRecordByID")
	@ResponseBody
	public Integer updateRecordByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		String illness = request.getParameter("illness");
		String history = request.getParameter("history");
		String result = request.getParameter("result");
		String treatment = request.getParameter("treatment");
		
		RecordWithBLOBs recordWithBLOBs = this.recordService.getRecordByID(ID);
		if(recordWithBLOBs == null)
			return 0;
		
		recordWithBLOBs.setIllness(illness);
		recordWithBLOBs.setHistory(history);
		recordWithBLOBs.setResult(result);
		recordWithBLOBs.setTreatment(treatment);
		
		return this.recordService.updateRecord(recordWithBLOBs);
	}
}
