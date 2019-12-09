package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Doctor;

public interface DoctorService {
	public Doctor getDoctorByID(String ID);
	
	public void updateDoctor(Doctor d);
	public void updatePassword(String ID, String password);
}
