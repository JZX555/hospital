package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Doctor;

public interface DoctorService {
	public Doctor getDoctorByID(String ID);
	public List<Doctor> getGoodDoctorByDepartment(String ID);
	
	public Integer updateDoctor(Doctor d);
	public Integer updatePassword(String ID, String password);
}
