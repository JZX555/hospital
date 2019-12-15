package cn.edu.cqu.hospital.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.cqu.hospital.pojo.Medicine;
import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.service.MedicineService;
import cn.edu.cqu.hospital.service.PrescriptionService;

@Controller
@RequestMapping("/Dispenser")
public class DispenserController {
	@Autowired
	private MedicineService medicinService = null;
	@Autowired
	private PrescriptionService prescriptionService = null;
	
	@RequestMapping("/Update_dispenser")
	public String Update_dispense(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Update_dispenser";
	}
	
	@RequestMapping("/MedList")
	public String MedList(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "MedList";
	}
	
	@RequestMapping("/show_dispenser")
	public String show_dispenser() {
		return "show_dispenser";
	}
	
	@RequestMapping("/getAllMedicines")
	@ResponseBody
	public List<Medicine> getAllMedicines(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.medicinService.getAllMedicines();
	}
	
	@RequestMapping("/getPrecriptions")
	@ResponseBody
	public List<Prescription> getPrescriptions(HttpServletRequest request, HttpServletResponse response, Model model) {
		return this.prescriptionService.getAllByDispenser();
	}
	
	@RequestMapping("/updatePrescriptionByID")
	@ResponseBody
	public Integer updatePrescriptionByID(HttpServletRequest request, HttpServletResponse response, Model model) {
		return null;
	}
}
