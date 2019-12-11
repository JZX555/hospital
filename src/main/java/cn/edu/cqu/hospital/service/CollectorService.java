package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Collector;

public interface CollectorService {
	public Collector getCollectorByID(String ID);
	
	public Integer updateCollector(Collector c);
	public Integer updatePassword(String ID, String password);
}
