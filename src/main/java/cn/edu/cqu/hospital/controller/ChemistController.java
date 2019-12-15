package cn.edu.cqu.hospital.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.service.MedicineService;
import cn.edu.cqu.hospital.service.PrescriptionService;

@Controller
@RequestMapping("/Chemist")
public class ChemistController {
	@Autowired
	private MedicineService medicineService = null;
	@Autowired
	private PrescriptionService prescriptionService = null;
	
	@RequestMapping("/Update_chemist")
	public String Update_chemist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Update_chemist";
	}
	
	@RequestMapping("/show_chemist")
	public String show_chemist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "show_chemist";
	}
	
	@RequestMapping("/getPrecriptions")
	@ResponseBody
	public List<Prescription> getPrescriptions(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.prescriptionService.getAllByChemist();
	}
	
	@RequestMapping("/updatePrescriptionByID")
	@ResponseBody
	public Integer updatePrescriptionByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		String ID = request.getParameter("ID");
		Integer state = Integer.parseInt(request.getParameter("state"));
		
		Prescription prescription = this.prescriptionService.getPrescriptionByID(ID);
		if(ID == null) 
			return 0;
		prescription.setState(state);
		
		return this.prescriptionService.updatePrescription(prescription);
	}
}
