package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Medicine;

public interface MedicineService {
	public Medicine getMedicineByID(String ID);
	
	public void updateMedicine(Medicine m);
	
	public Integer getNumsByID(String ID);
	public void addNumsByID(String ID, int nums);
}
