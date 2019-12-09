package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Patient;

public interface PatientService {
	Patient getPatientByID(String ID);
	
	void updatePatient(Patient p);
	void updatePassword(String ID, String password);
}
