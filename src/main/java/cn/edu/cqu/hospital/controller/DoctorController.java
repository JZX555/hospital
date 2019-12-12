package cn.edu.cqu.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.pojo.Patient;
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
	
	@RequestMapping("/getNextPatientByDoctor")
	@ResponseBody
	public Register getNextPatientByDocto(String ID, HttpServletRequest request, HttpServletResponse response, Model model) {
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
			r.setId(register.getPatientId().substring(14) + ID + dateID);
			r.setPatientId(register.getPatientId());
			r.setDocId(ID);
			r.setTime(date);
			this.recordService.createRecord(r);
			
			return register;   
		}
		
		if(!this.queueService.isEmptyByID(qID)) {
			int cur_index = this.queueService.nextIndexByID(qID);
			Triage triage = this.triageService.getByQueueAndIndex(qID, cur_index);
			Register register = this.registerService.getRegisterByID(triage.getRegisterId());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        Date date = new Date();
	        String dateID = sdf.format(date).toString();
			
			RecordWithBLOBs r = new RecordWithBLOBs();
			r.setId(register.getPatientId() + ID + dateID);
			r.setPatientId(register.getPatientId());
			r.setDocId(ID);
			r.setTime(date);
			this.recordService.createRecord(r);
			
			return register;   
		}   
		
		return null;
	}
}
