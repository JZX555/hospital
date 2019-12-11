package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Medicine;

public interface MedicineService {
	public Medicine getMedicineByID(String ID);
	
	public Integer createMedicine(Medicine m);
	public Integer updateMedicine(Medicine m);
	public Integer deletaMedicine(String ID);
	
	public Integer getNumsByID(String ID);
	public Integer addNumsByID(String ID, int nums);
}
