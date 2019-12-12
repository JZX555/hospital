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

	public Triage getByQueueAndIndex(String q, Integer i) {
		return this.triageDao.selectByQueueAndIndex(q, i);
	}

	public Integer createTriage(Triage t) {
		return this.triageDao.insertSelective(t);
	}

	public Integer updateTriage(Triage t) {
		return this.triageDao.updateByPrimaryKeySelective(t);
	}

	public Integer deleteTriage(String ID) {
		return this.triageDao.deleteByPrimaryKey(ID);
	}

}
