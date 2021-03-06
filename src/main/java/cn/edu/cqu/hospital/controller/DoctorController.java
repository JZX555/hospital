package cn.edu.cqu.hospital.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
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

import cn.edu.cqu.hospital.pojo.Department;
import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.pojo.Item;
import cn.edu.cqu.hospital.pojo.Medicine;
import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.pojo.PatientWithRecord;
import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.pojo.Queue;
import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;
import cn.edu.cqu.hospital.pojo.Register;
import cn.edu.cqu.hospital.pojo.Requisition;
import cn.edu.cqu.hospital.pojo.Triage;
import cn.edu.cqu.hospital.service.DepartmentService;
import cn.edu.cqu.hospital.service.DoctorService;
import cn.edu.cqu.hospital.service.ItemService;
import cn.edu.cqu.hospital.service.MedicineService;
import cn.edu.cqu.hospital.service.PatientService;
import cn.edu.cqu.hospital.service.PrescriptionService;
import cn.edu.cqu.hospital.service.QueueService;
import cn.edu.cqu.hospital.service.RecordService;
import cn.edu.cqu.hospital.service.RegisterService;
import cn.edu.cqu.hospital.service.RequisitionService;
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
	@Autowired
	private DepartmentService departmentService = null;
	@Autowired
	private MedicineService medicineService = null;
	@Autowired
	private PrescriptionService prescriptionService = null;
	@Autowired
	private RequisitionService requisitionService = null;
	@Autowired
	private ItemService itemService = null;
	
	
	@RequestMapping("/consult_doctor")
	public String consult_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "consult_doctor";
	}
	
	@RequestMapping("/viewPrevRecord_doctor")
	public String viewPrevRecord_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "viewPrevRecord_doctor";
	}
	
	@RequestMapping("/editRecord_doctor")
	public String editRecord(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editRecord_doctor";
	}
	
	@RequestMapping("/editRequisition")
	public String editRequisition(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editRequisition";
	}
	
	@RequestMapping("/editPrevPrescription_doctor")
	public String editPrevPrescription_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editPrevPrescription_doctor";
	}
	
	@RequestMapping("/editPrescriptionList_doctor")
	public String editPrescription(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editPrescriptionList_doctor";
	}
	
	@RequestMapping("/viewHistoricalRec")
	public String viewHistoricalRec(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "viewHistoricalRec";
	}
	
	@RequestMapping("/addPrescription_doctor")
	public String addPrescription_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "addPrescription_doctor";
	}
	
	@RequestMapping("/addRequisition_doctor")
	public String addRequisition_doctor() {
		return "addRequisition_doctor";
	}
	
	@RequestMapping("/viewRecordById_doctor")
	public String viewRecordById_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "viewRecordById_doctor";
	}
	
	@RequestMapping("/editRequisitionList_doctor")
	public String editItemList_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editRequisitionList_doctor";
	}
	
	@RequestMapping("/editPrevRequisition_doctor")
	public String editPrevItem_doctor(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "editPrevRequisition_doctor";
	}
	
	@RequestMapping("/getNextPatientByDoctor")
	@ResponseBody
	public Register getNextPatientByDocto(String ID, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession httpSession) {
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
			
			this.triageService.deleteTriage(triage.getId());
			
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
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
			
			this.triageService.deleteTriage(triage.getId());
			
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
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
		
		Doctor doctor = this.doctorService.getDoctorByID(recordWithBLOBs.getDocId());
		if(doctor == null)
			return null;
		
		Department department = this.departmentService.getDepartmentByID(doctor.getDepartId());
		if(department == null)
			return null;
		
		PatientWithRecord res = new PatientWithRecord();
		res.setPatient(patient);
		res.setRecordWithBLOBs(recordWithBLOBs);
		res.setDepartment(department);
		
		return res;
	}
	
	@RequestMapping("/getRecordByPatient")
	@ResponseBody
	public List<PatientWithRecord> getRecordByPatient(HttpServletRequest request, HttpServletResponse response, Model model) {
		String patient_ID = request.getParameter("patient_ID");
		List<PatientWithRecord> res = new ArrayList<PatientWithRecord>();
		
		Patient patient = this.patientService.getPatientByID(patient_ID);
		if(patient == null)
			return null;
		
		List<RecordWithBLOBs> recordWithBLOBs = this.recordService.getRecordByPatient(patient_ID);
		if(recordWithBLOBs == null)
			return null;
		
		
		for(RecordWithBLOBs r : recordWithBLOBs) {
			PatientWithRecord tmp = new PatientWithRecord();
			if(patient == null)
				return null;
			
			Doctor doctor = this.doctorService.getDoctorByID(r.getDocId());
			if(doctor == null)
				return null;
			
			Department department = this.departmentService.getDepartmentByID(doctor.getDepartId());
			if(department == null)
				return null;
			
			tmp.setRecordWithBLOBs(r);
			tmp.setDepartment(department);
			tmp.setPatient(patient);
			
			res.add(tmp);
		}
		
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
	
	@RequestMapping("/getAllMedicines")
	@ResponseBody
	public List<Medicine> getAllMedicines(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.medicineService.getAllMedicines();
	}
	
	@RequestMapping("/getMedicineByID")
	@ResponseBody
	public Medicine getMedicineByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String medicine_ID = request.getParameter("medicine_ID");
		
		return this.medicineService.getMedicineByID(medicine_ID);
	}
	
	@RequestMapping("/getPrescriptionById")
	@ResponseBody
	public Prescription getPrescriptionById(HttpServletRequest request, HttpServletResponse response, Model model) {
		String prescription_ID = request.getParameter("prescription_ID");
		
		return this.prescriptionService.getPrescriptionByID(prescription_ID);
	}
	
	@RequestMapping("/getAllPrescription")
	@ResponseBody
	public List<Prescription> getAllPrescription(HttpServletRequest request, HttpServletResponse response, Model model) {
		String record_ID = request.getParameter("record_ID");
		
		List<Prescription> res = this.prescriptionService.getPrescriptionByRecord(record_ID);
		
		return res;
	}
	
	@RequestMapping("/createPrescription")
	@ResponseBody
	public Prescription createPrescription(HttpServletRequest request, HttpServletResponse response, Model model) {
		String record_ID = request.getParameter("record_ID");
		
		RecordWithBLOBs recordWithBLOBs = this.recordService.getRecordByID(record_ID);
		if(recordWithBLOBs == null)
			return null;
		
		Prescription prescription = new Prescription();
		Date date = new Date();
		Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));	
		
		prescription.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		prescription.setPatientId(recordWithBLOBs.getPatientId());
		prescription.setDocId(recordWithBLOBs.getDocId());
		prescription.setRecordId(record_ID);
		prescription.setState(0);
		
		try {
			this.prescriptionService.createPrescription(prescription);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		return prescription;
	}
	
	@RequestMapping("/updatePrescription")
	@ResponseBody
	public Integer updatePrescription(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		String medicine_ID = request.getParameter("medicine_ID");
		Integer nums = Integer.parseInt(request.getParameter("nums"));
		Double price;
		
		Prescription prescription = this.prescriptionService.getPrescriptionByID(ID);
		if(prescription == null)
			return 0;
		
		
		if(prescription.getMedicineId() != null && prescription.getNum() != null) {
			Medicine medicine_old = this.medicineService.getMedicineByID(prescription.getMedicineId());
			medicine_old.setNums(medicine_old.getNums() + prescription.getNum());
			this.medicineService.updateMedicine(medicine_old);
		}
		
		Medicine medicine_new = this.medicineService.getMedicineByID(medicine_ID);
		if(medicine_new == null || medicine_new.getNums() < nums) {
			if(prescription.getMedicineId() != null && prescription.getNum() != null) {
				Medicine medicine_old = this.medicineService.getMedicineByID(prescription.getMedicineId());
				medicine_old.setNums(medicine_old.getNums() - prescription.getNum());
				this.medicineService.updateMedicine(medicine_old);
			}			
			return 0;
		}
		medicine_new.setNums(medicine_new.getNums() - nums);
		this.medicineService.updateMedicine(medicine_new);
		
		price = medicine_new.getPrice() * nums;
		
		prescription.setMedicineId(medicine_ID);
		prescription.setNum(nums);
		prescription.setPrice(price);
		prescription.setState(0);
		
		return this.prescriptionService.updatePrescription(prescription);
	}
	
	@RequestMapping("/getItemMedicineByID")
	@ResponseBody
	public Item getItemMedicineByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String item_ID = request.getParameter("item_ID");
		
		return this.itemService.getItemByID(item_ID);
	}
	
	@RequestMapping("/getAllItems")
	@ResponseBody
	public List<Item> getAllItems(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.itemService.getAllItems();
	}
	
	@RequestMapping("/getRequisitionById")
	@ResponseBody
	public Requisition getRequisitionById(HttpServletRequest request, HttpServletResponse response, Model model) {
		String Requisition_ID = request.getParameter("Requisition_ID");
		
		return this.requisitionService.getRequisitionByID(Requisition_ID);
	}
	
	@RequestMapping("/getAllRequisition")
	@ResponseBody
	public List<Requisition> getAllRequisition(HttpServletRequest request, HttpServletResponse response, Model model) {
		String record_ID = request.getParameter("record_ID");
		
		List<Requisition> res = this.requisitionService.getRequisitionByRecord(record_ID);  
				
		return res;
	}
	
	@RequestMapping("/createRequisition")
	@ResponseBody
	public Requisition createRequisition(HttpServletRequest request, HttpServletResponse response, Model model) {
		String record_ID = request.getParameter("record_ID");
		
		RecordWithBLOBs recordWithBLOBs = this.recordService.getRecordByID(record_ID);
		if(recordWithBLOBs == null)
			return null;
		
		Requisition requisition = new Requisition();
		Date date = new Date();
		Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
		
		requisition.setId(dateFormat.format(date) + (int)(random.nextDouble() * 899 + 100));
		requisition.setPatientId(recordWithBLOBs.getPatientId());
		requisition.setDocId(recordWithBLOBs.getDocId());
		requisition.setRecordId(record_ID);
		requisition.setTime(date);
		requisition.setState(0);
		
		try {
			this.requisitionService.createRequisition(requisition);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
		return requisition;
	}
	
	@RequestMapping("/updateRequisition")
	@ResponseBody
	public Integer updateRequisition(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		String item_ID = request.getParameter("item_ID");
		Double price;
		
		Requisition requisition = this.requisitionService.getRequisitionByID(ID);

		Item item = this.itemService.getItemByID(item_ID);
		if(item == null)
			return 0;
		
		price = item.getPrice();
		
		requisition.setItemId(item_ID);
		requisition.setPrice(price);
		
		return this.requisitionService.updateRequisition(requisition);
	}
}
