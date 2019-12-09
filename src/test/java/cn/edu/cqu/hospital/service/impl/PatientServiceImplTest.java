package cn.edu.cqu.hospital.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.service.PatientService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-context.xml"})  
public class PatientServiceImplTest {
	@Autowired
	private PatientService patientService = null;
	
	@Test
	public void test() {
		System.out.println("begin");
		Patient p;
		p = this.patientService.getPatientByID("511112199803190913");
		System.out.println(p.getPhone());
		
		Patient n_p = new Patient();
		n_p.setId("511112199803190913");
		n_p.setPhone("17725024014");
		this.patientService.updatePatient(n_p);
		
		p = this.patientService.getPatientByID("511112199803190913");
		System.out.println(p.getPhone());
	}

}
