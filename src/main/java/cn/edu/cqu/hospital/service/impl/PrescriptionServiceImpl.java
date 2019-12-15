package cn.edu.cqu.hospital.service.impl;

import java.util.List;

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

	public List<Prescription> getPrescriptionByPatient(String ID) {
		return this.prescriptionDao.selectByPatientKey(ID);
	}

	public List<Prescription> getAllByDispenser() {
		return this.prescriptionDao.selectAllByDispenser();
	}

	public List<Prescription> getAllByChemist() {
		return this.prescriptionDao.selectAllByChemist();
	}

	public Integer createPrescription(Prescription p) {
		return this.prescriptionDao.insertSelective(p);
	}

	public Integer updatePrescription(Prescription p) {
		return this.prescriptionDao.updateByPrimaryKeySelective(p);
	}

	public Integer deletaPrescription(String ID) {
		return this.prescriptionDao.deleteByPrimaryKey(ID);
	}

	public List<Prescription> getPrescriptionByRecord(String ID) {
		return this.prescriptionDao.selectByRecordKey(ID);
	}

}
