package cn.edu.cqu.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.pojo.Payment;
import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.pojo.Queue;
import cn.edu.cqu.hospital.pojo.Register;
import cn.edu.cqu.hospital.pojo.Reservation;
import cn.edu.cqu.hospital.pojo.Triage;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.PatientService;
import cn.edu.cqu.hospital.service.PaymentService;
import cn.edu.cqu.hospital.service.PrescriptionService;
import cn.edu.cqu.hospital.service.QueueService;
import cn.edu.cqu.hospital.service.RegisterService;
import cn.edu.cqu.hospital.service.ReservationService;
import cn.edu.cqu.hospital.service.TriageService;

@Controller
@RequestMapping("/collector")
public class CollectorController {
	@Autowired
	private RegisterService registerService = null;
	@Autowired
	private TriageService triageService = null;
	@Autowired
	private PatientService patientService = null;
	@Autowired
	private ReservationService reservationService = null;
	@Autowired
	private DoctorService doctorService = null;
	@Autowired
	private PrescriptionService prescriptionService = null;
	@Autowired
	private QueueService queueService = null;
	@Autowired
	private PaymentService paymentService = null;
	
	@RequestMapping("/DeptLists_collector")
	public String DeptLists_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "DeptLists_collector";
	}
	
	@RequestMapping("/register_collector")
	public String register_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "register_collector";
	}
	
	@RequestMapping("/SolveRerv_collector")
	public String SolveRerv_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "SolveRerv_collector";
	}
	
	@RequestMapping("/Money_collector")
	public String Money_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Money_collector";
	}
	
	@RequestMapping("/getPID_collector")
	public String getPID_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "getPID_collector";
	}
	
	@RequestMapping("/search_collector")
	public String search_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "search_collector";
	}
	
	@RequestMapping("/SolvePay_collector")
	public String SolvePay_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "SolvePay_collector";
	}
	
	@RequestMapping("/searchpay_collector")
	public String searchpay_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "searchpay_collector";
	}
	
	@RequestMapping("/searchrefund_collector")
	public String searchrefund_collector(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "searchrefund_collector";
	}
	
	@RequestMapping("/insertRegister")
	@ResponseBody
	public Integer insertRegister(HttpServletRequest request, HttpServletResponse response, Model model) {
		String patient_ID = request.getParameter("patient_ID");
		String doc_ID = request.getParameter("doc_ID");
		String depart_ID = request.getParameter("depart_ID");
		String collector_ID = request.getParameter("collector_ID");
		Integer type;
		
		Doctor doctor = this.doctorService.getDoctorByID(doc_ID);
		if(doctor == null)
			return 0;
		
		if(doctor.getLevel() == 0)
			type = 0;
		else
			type = 1;
		
		Queue queue = this.queueService.getQueueByID(doctor.getQueue());
		if(queue == null)
			return 0;
		
		Date date = new Date();
		Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

		
		Register register = new Register();
		String register_ID = dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100);
		
		register.setId(register_ID);
		register.setPatientId(patient_ID);
		register.setDocId(doc_ID);
		register.setDepartId(depart_ID);
		register.setCollectorId(collector_ID);
		register.setType(type);
		register.setState(0);
		register.setTime(date);
		
		if(this.registerService.createRegister(register) == 0)
			return 0;
		
		Payment payment = new Payment();
		payment.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		payment.setPatientId(patient_ID);
		payment.setItem(1);
		payment.setItemId(register_ID);
		payment.setType(0);
		payment.setTime(date);
		payment.setPrice(10.0 + doctor.getLevel() * 10.0);
		
		if(this.paymentService.createPayment(payment) == 0) {
			this.registerService.deleteRegister(register_ID);
			return 0;
		}
		
		Triage triage = new Triage();
		triage.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		triage.setPatientId(patient_ID);
		triage.setRegisterId(register_ID);
		triage.setQueue(queue.getId());
		triage.setIndex(this.queueService.increaseNumsByID(queue.getId()));
		
		return this.triageService.createTriage(triage);
	}
	
	@RequestMapping("/insertRegisterByReservation")
	@ResponseBody
	public Integer insertRegisterByReservation(HttpServletRequest request, HttpServletResponse response, Model model) {
		String reservation_ID = request.getParameter("reservation_ID");
		String collector_ID = request.getParameter("collector_ID");
		Integer type;
		
		Reservation reservation = this.reservationService.getReservationByID(reservation_ID);
		if(reservation == null || reservation.getState() != 0)
			return 0;
		reservation.setState(1);
		if(this.reservationService.updateReservation(reservation) == 0)
			return 0;
		
		Doctor doctor = this.doctorService.getDoctorByID(reservation.getDocId());
		if(doctor == null)
			return 0;
		
		if(doctor.getLevel() == 0)
			type = 2;
		else
			type = 3;
		
		Queue queue = this.queueService.getQueueByID(doctor.getPrioQueue());
		if(queue == null)
			return 0;
		
		Date date = new Date();
		Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		
		Register register = new Register();
		String register_ID = dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100);
		
		register.setId(register_ID);
		register.setPatientId(reservation.getPatientId());
		register.setDocId(reservation.getDocId());
		register.setDepartId(reservation.getDepartId());
		register.setCollectorId(collector_ID);
		register.setType(type);
		register.setState(0);
		register.setTime(date);		
		
		if(this.registerService.createRegister(register) == 0)
			return 0;
		
		Payment payment = new Payment();
		payment.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		payment.setPatientId(reservation.getPatientId());
		payment.setItem(1);
		payment.setItemId(register_ID);
		payment.setType(0);
		payment.setTime(date);
		payment.setPrice(10.0 + doctor.getLevel() * 10.0);
		
		if(this.paymentService.createPayment(payment) == 0) {
			this.registerService.deleteRegister(register_ID);
			return 0;
		}
		
		Triage triage = new Triage();
		triage.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		triage.setPatientId(reservation.getPatientId());
		triage.setRegisterId(register_ID);
		triage.setQueue(queue.getId());
		triage.setIndex(this.queueService.increaseNumsByID(queue.getId()));
		
		return this.triageService.createTriage(triage);
	}
	
	@RequestMapping("/getRemainedByID")
	@ResponseBody
	public Integer getRemainedByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		
		Doctor doctor = this.doctorService.getDoctorByID(ID);
		if(doctor == null)
			return -1;
		
		int used = this.doctorService.getUsedByIDAndDate(ID, dateFormat.format(date));
		
		return doctor.getMax() - used;
	}
	
	@RequestMapping("/getReservationByID")
	@ResponseBody
	public List<Reservation> getReservationByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		
		List<Reservation> res = this.reservationService.getReservationsByPatientAndDate(ID, dateFormat.format(date));
		for(Reservation r : res) {
			if(r.getState() != 0 && r.getState() != 1)
				res.remove(r);
		}
		
		return res;
	}
}
