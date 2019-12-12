package cn.edu.cqu.hospital.service.impl;

import java.util.Date;
import java.util.List;

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
		return this.doctorDao.selectByPrimaryKey(ID);
	}

	public List<Doctor> getGoodDoctorByDepartment(String ID) {
		return this.doctorDao.selectGoodByDepartmentKey(ID);
	}

	public Integer getUsedByIDAndDate(String ID, String date) {
		if(this.doctorDao.getUsedByIDAndDate(ID, date) == null)
			return 0;
		return this.doctorDao.getUsedByIDAndDate(ID, date);
	}

	public Integer updateDoctor(Doctor d) {
		return this.doctorDao.updateByPrimaryKeySelective(d);
	}

	public Integer updatePassword(String ID, String password) {
		Doctor d = new Doctor();
		d.setId(ID);
		d.setPassword(password);
		
		return this.doctorDao.updateByPrimaryKeySelective(d);
	}

}
