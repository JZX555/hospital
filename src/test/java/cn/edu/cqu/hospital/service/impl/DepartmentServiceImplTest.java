package cn.edu.cqu.hospital.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cqu.hospital.pojo.Department;
import cn.edu.cqu.hospital.service.DepartmentService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-context.xml"})  
public class DepartmentServiceImplTest {
	@Autowired
	private DepartmentService departmentService = null;
	
	@Test
	public void test() {
		Department[] departments = this.departmentService.getAllDepartments();
		for(Department d : departments) {
			System.out.println(d.getId());
		}
	}

}
