package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Dispenser;

public interface DispenserService {
	public Dispenser getDispenserByID(String ID);
	
	public void updateDispenser(Dispenser d);
	public void updatePassword(String ID, String password);
}
