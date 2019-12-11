package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Register;

public interface RegisterService {
	public Register getRegisterByID(String ID);
	public Register[] getRegisterByPatient(String ID);
	public Register[] getRegisterByDoctor(String ID);
	public Register[] getRegisterByCollector(String ID);
	
	public Integer createRegister(Register r);
	public Integer updateRegister(Register r);
	public Integer deleteRegister(String ID);
}
