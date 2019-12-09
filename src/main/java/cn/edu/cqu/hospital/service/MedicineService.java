package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Medicine;

public interface MedicineService {
	public Medicine getMedicineByID(String ID);
	
	public void createMedicine(Medicine m);
	public void updateMedicine(Medicine m);
	public void deletaMedicine(String ID);
	
	public Integer getNumsByID(String ID);
	public void addNumsByID(String ID, int nums);
}
