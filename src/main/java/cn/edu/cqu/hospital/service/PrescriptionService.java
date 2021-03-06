package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Prescription;

public interface PrescriptionService {
	public Prescription getPrescriptionByID(String ID);
	public List<Prescription> getPrescriptionByPatient(String ID);
	public List<Prescription> getPrescriptionByRecord(String ID);
	public List<Prescription> getAllByDispenser();
	public List<Prescription> getAllByChemist();
	
	public Integer createPrescription(Prescription p);
	public Integer updatePrescription(Prescription p);
	public Integer deletaPrescription(String ID);
}
