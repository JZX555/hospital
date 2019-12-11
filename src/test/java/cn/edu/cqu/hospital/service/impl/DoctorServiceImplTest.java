package cn.edu.cqu.hospital.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.service.DoctorService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-context.xml"})  
public class DoctorServiceImplTest {
	@Autowired
	private DoctorService doctorService = null;
	
	@Test
	public void test() {
		List<Doctor> doctors = this.doctorService.getGoodDoctorByDepartment("0002");
		for(Doctor d : doctors) {
			System.out.println(d.getId());
		}
	}

}
