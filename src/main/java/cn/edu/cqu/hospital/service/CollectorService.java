package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Collector;

public interface CollectorService {
	public Collector getCollectorByID(String ID);
	
	public void updateCollector(Collector c);
	public void updatePassword(String ID, String password);
}
