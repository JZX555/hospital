package cn.edu.cqu.hospital.service.impl;

import java.util.List;

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

	public List<Register> getRegisterByPatient(String ID) {
		return this.registerDao.selectByPatientKey(ID);
	}

	public List<Register> getRegisterByDoctor(String ID) {
		return this.registerDao.selectByDoctorKey(ID);
	}

	public List<Register> getRegisterByCollector(String ID) {
		return this.registerDao.selectByCollectorKey(ID);
	}

	public Integer createRegister(Register r) {
		return this.registerDao.insertSelective(r);
	}

	public Integer updateRegister(Register r) {
		return this.registerDao.updateByPrimaryKeySelective(r);
	}

	public Integer deleteRegister(String ID) {
		return this.registerDao.deleteByPrimaryKey(ID);
	}

}
