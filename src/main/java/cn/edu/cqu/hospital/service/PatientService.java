package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Patient;

public interface PatientService {
	public Patient getPatientByID(String ID);
	
	public void updatePatient(Patient p);
	public void updatePassword(String ID, String password);
}
