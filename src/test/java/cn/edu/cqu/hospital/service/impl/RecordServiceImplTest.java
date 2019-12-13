package cn.edu.cqu.hospital.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;
import cn.edu.cqu.hospital.service.RecordService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-context.xml"})  
public class RecordServiceImplTest {
	@Autowired
	private RecordService recordService = null;
	
	@Test
	public void test() {
		RecordWithBLOBs recordWithBLOBs = this.recordService.getRecordByID("0001");
		
		System.out.println(recordWithBLOBs.getPatientId());
	}

}
