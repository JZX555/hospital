package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Register;

public interface RegisterService {
	public Register getRegisterByID(String ID);
	public Register[] getRegisterByPatient(String ID);
	public Register[] getRegisterByDoctor(String ID);
	public Register[] getRegisterByCollector(String ID);
	
	public void createRegister(Register r);
	public void updateRegister(Register r);
	public void deleteRegister(String ID);
}
