package cn.edu.cqu.hospital.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/tabs_doctors")
	public String login(HttpServletRequest request,Model model) {
		System.out.println("------进入/index/tabs_doctors------");
		return "register";
	}
}
