package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.ChemistMapper;
import cn.edu.cqu.hospital.pojo.Chemist;
import cn.edu.cqu.hospital.service.ChemistService;

@Service
public class ChemistServiceImpl implements ChemistService {
	@Autowired
	private ChemistMapper chemistDao;
	
	public Chemist getChemistByID(String ID) {
		return this.chemistDao.selectByPrimaryKey(ID);
	}

	public void updateChemist(Chemist c) {
		this.chemistDao.updateByPrimaryKeySelective(c);
	}

	public void updatePassword(String ID, String password) {
		Chemist c = new Chemist();
		c.setId(ID);
		c.setPassword(password);
		this.chemistDao.updateByPrimaryKeySelective(c);
	}

}
