package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.TriageMapper;
import cn.edu.cqu.hospital.pojo.Triage;
import cn.edu.cqu.hospital.service.TriageService;

@Service
public class TriageServiceImpl implements TriageService {
	@Autowired
	private TriageMapper triageDao;
	
	public Triage getTriageByID(String ID) {
		return this.triageDao.selectByPrimaryKey(ID);
	}

	public void createTriage(Triage t) {
		this.triageDao.insertSelective(t);
	}

	public void updateTriage(Triage t) {
		this.triageDao.updateByPrimaryKeySelective(t);
	}

	public void deleteTriage(String ID) {
		this.triageDao.deleteByPrimaryKey(ID);
	}

}
