package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Doctor;

public interface DoctorService {
	Doctor getDoctorByID(String ID);
	
	void updateDoctor(Doctor d);
}
