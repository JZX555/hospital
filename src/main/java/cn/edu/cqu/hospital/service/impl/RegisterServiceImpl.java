package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.RegisterMapper;
import cn.edu.cqu.hospital.pojo.Register;
import cn.edu.cqu.hospital.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterMapper registerDao;
	
	public Register getRegisterByID(String ID) {
		return this.registerDao.selectByPrimaryKey(ID);
	}

	public Register[] getRegisterByPatient(String ID) {
		return this.registerDao.selectByPatientKey(ID);
	}

	public Register[] getRegisterByDoctor(String ID) {
		return this.registerDao.selectByDoctorKey(ID);
	}

	public Register[] getRegisterByCollector(String ID) {
		return this.registerDao.selectByCollectorKey(ID);
	}

	public void createRegister(Register r) {
		this.registerDao.insertSelective(r);
	}

	public void updateRegister(Register r) {
		this.registerDao.updateByPrimaryKeySelective(r);
	}

	public void deleteRegister(String ID) {
		this.registerDao.deleteByPrimaryKey(ID);
	}

}
