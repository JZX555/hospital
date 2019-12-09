package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.DispenserMapper;
import cn.edu.cqu.hospital.pojo.Dispenser;
import cn.edu.cqu.hospital.service.DispenserService;

@Service
public class DispenserServiceImpl implements DispenserService {
	@Autowired
	private DispenserMapper dispenserDao;
	
	public Dispenser getDispenserByID(String ID) {
		return this.dispenserDao.selectByPrimaryKey(ID);
	}

	public void updateDispenser(Dispenser d) {
		this.dispenserDao.updateByPrimaryKeySelective(d);
	}

	public void updatePassword(String ID, String password) {
		Dispenser d = new Dispenser();
		d.setId(ID);
		d.setPassword(password);
		this.dispenserDao.updateByPrimaryKeySelective(d);
	}

}
