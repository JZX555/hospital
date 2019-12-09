package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.MedicineMapper;
import cn.edu.cqu.hospital.pojo.Medicine;
import cn.edu.cqu.hospital.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {
	@Autowired
	private MedicineMapper medicineDao;
	
	public Medicine getMedicineByID(String ID) {
		return this.medicineDao.selectByPrimaryKey(ID);
	}

	public void updateMedicine(Medicine m) {
		this.medicineDao.updateByPrimaryKeySelective(m);
	}

	public void createMedicine(Medicine m) {
		this.medicineDao.insertSelective(m);
	}

	public void deletaMedicine(String ID) {
		this.medicineDao.deleteByPrimaryKey(ID);
	}

	public Integer getNumsByID(String ID) {
		Medicine m = this.medicineDao.selectByPrimaryKey(ID);
		return m.getNums();
	}

	public void addNumsByID(String ID, int nums) {
		Medicine m = this.medicineDao.selectByPrimaryKey(ID);
		m.setNums(m.getNums() + nums);
		this.medicineDao.updateByPrimaryKeySelective(m);
	}

}
