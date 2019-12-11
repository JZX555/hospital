package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.PatientMapper;
import cn.edu.cqu.hospital.pojo.Patient;
import cn.edu.cqu.hospital.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientMapper patientDao;
	
	public Patient getPatientByID(String ID) {
		return this.patientDao.selectByPrimaryKey(ID);
	}

	public Integer updatePassword(String ID, String password) {
		Patient p = new Patient();
		p.setId(ID);
		p.setPassword(password);
		return this.patientDao.updateByPrimaryKeySelective(p);
	}
	
	public Integer createPatient(Patient p) {
		return this.patientDao.insertSelective(p);
	}
	
	public Integer updatePatient(Patient p) {
		return this.patientDao.updateByPrimaryKeySelective(p);
	}
	
	public Integer deletePatient(String ID) {
		return this.patientDao.deleteByPrimaryKey(ID);
	}
}
