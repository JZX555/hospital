package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.CollectorMapper;
import cn.edu.cqu.hospital.pojo.Collector;
import cn.edu.cqu.hospital.service.CollectorService;

@Service
public class CollectorServiceImpl implements CollectorService {
	@Autowired
	private CollectorMapper collectorDao;
	
	public Collector getCollectorByID(String ID) {
		return this.collectorDao.selectByPrimaryKey(ID);
	}

	public Integer updateCollector(Collector c) {
		return this.collectorDao.updateByPrimaryKeySelective(c);
	}

	public Integer updatePassword(String ID, String password) {
		Collector c = new Collector();
		c.setId(ID);
		c.setPassword(password);
		return this.collectorDao.updateByPrimaryKeySelective(c);
	}

}
