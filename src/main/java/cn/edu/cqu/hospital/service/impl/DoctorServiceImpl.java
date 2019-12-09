package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.DoctorMapper;
import cn.edu.cqu.hospital.pojo.Doctor;
import cn.edu.cqu.hospital.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private DoctorMapper doctorDao;
	
	public Doctor getDoctorByID(String ID) {
		return this.getDoctorByID(ID);
	}

	public void updateDoctor(Doctor d) {
		this.doctorDao.updateByPrimaryKeySelective(d);
	}

	public void updatePassword(String ID, String password) {
		Doctor d = new Doctor();
		d.setId(ID);
		d.setPassword(password);
		this.doctorDao.updateByPrimaryKeySelective(d);
	}

}
