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

	public Integer updateMedicine(Medicine m) {
		return this.medicineDao.updateByPrimaryKeySelective(m);
	}

	public Integer createMedicine(Medicine m) {
		return this.medicineDao.insertSelective(m);
	}

	public Integer deletaMedicine(String ID) {
		return this.medicineDao.deleteByPrimaryKey(ID);
	}

	public Integer getNumsByID(String ID) {
		Medicine m = this.medicineDao.selectByPrimaryKey(ID);
		return m.getNums();
	}

	public Integer addNumsByID(String ID, int nums) {
		Medicine m = this.medicineDao.selectByPrimaryKey(ID);
		m.setNums(m.getNums() + nums);
		
		return this.medicineDao.updateByPrimaryKeySelective(m);
	}

}
