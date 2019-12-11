package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Dispenser;

public interface DispenserService {
	public Dispenser getDispenserByID(String ID);
	
	public Integer updateDispenser(Dispenser d);
	public Integer updatePassword(String ID, String password);
}
