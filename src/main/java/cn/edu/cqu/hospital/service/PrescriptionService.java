package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Prescription;

public interface PrescriptionService {
	public Prescription getPrescriptionByID(String ID);
	public Prescription[] getPrescriptionByPatient(String ID);
	public Prescription[] getPrescriptionByRecord(String ID);
	
	public void createPrescripiton(Prescription p);
	public void updatePrescription(Prescription p);
	public void deletaPrescription(String ID);
}
