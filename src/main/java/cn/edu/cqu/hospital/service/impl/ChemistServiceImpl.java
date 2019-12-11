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

	public Integer updateChemist(Chemist c) {
		return this.chemistDao.updateByPrimaryKeySelective(c);
	}

	public Integer updatePassword(String ID, String password) {
		Chemist c = new Chemist();
		c.setId(ID);
		c.setPassword(password);
		
		return this.chemistDao.updateByPrimaryKeySelective(c);
	}

}
