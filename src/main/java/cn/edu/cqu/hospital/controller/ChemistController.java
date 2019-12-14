package cn.edu.cqu.hospital.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.cqu.hospital.service.MedicineService;

@Controller
@RequestMapping("/Chemist")
public class ChemistController {
	@Autowired
	private MedicineService medicineService = null;
	
	@RequestMapping("/Update_chemist")
	public String Update_chemist(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "Update_chemist";
	}
}
