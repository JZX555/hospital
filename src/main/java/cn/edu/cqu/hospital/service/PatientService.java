package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Patient;

public interface PatientService {
	public Patient getPatientByID(String ID);
	
	public Integer updatePassword(String ID, String password);
	
	public Integer createPatient(Patient p);
	public Integer updatePatient(Patient p);
	public Integer deletePatient(String ID);
}
