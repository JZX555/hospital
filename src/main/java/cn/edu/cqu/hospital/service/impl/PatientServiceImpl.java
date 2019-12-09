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

	public void updatePatient(Patient p) {
		patientDao.updateByPrimaryKeySelective(p);
	}

	public void updatePassword(String ID, String password) {
		Patient p = new Patient();
		p.setId(ID);
		p.setPassword(password);
		patientDao.updateByPrimaryKeySelective(p);
	}
}
