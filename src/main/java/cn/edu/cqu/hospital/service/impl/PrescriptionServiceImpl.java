package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.PrescriptionMapper;
import cn.edu.cqu.hospital.pojo.Prescription;
import cn.edu.cqu.hospital.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
	@Autowired
	private PrescriptionMapper prescriptionDao;
	
	public Prescription getPrescriptionByID(String ID) {
		return this.prescriptionDao.selectByPrimaryKey(ID);
	}

	public Prescription[] getPrescriptionByPatient(String ID) {
		return this.prescriptionDao.selectByPatientKey(ID);
	}

	public void createPrescripiton(Prescription p) {
		this.prescriptionDao.insertSelective(p);
	}

	public void updatePrescription(Prescription p) {
		this.prescriptionDao.updateByPrimaryKeySelective(p);
	}

	public void deletaPrescription(String ID) {
		this.prescriptionDao.deleteByPrimaryKey(ID);
	}

	public Prescription[] getPrescriptionByRecord(String ID) {
		return this.prescriptionDao.selectByRecordKey(ID);
	}

}
