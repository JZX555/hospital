package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Register;

public interface RegisterService {
	public Register getRegisterByID(String ID);
	public List<Register> getRegisterByPatient(String ID);
	public List<Register> getRegisterByDoctor(String ID);
	public List<Register> getRegisterByCollector(String ID);
	
	public Integer createRegister(Register r);
	public Integer updateRegister(Register r);
	public Integer deleteRegister(String ID);
}
