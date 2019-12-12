package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageService {
	public Triage getTriageByID(String ID);
	public Triage getByQueueAndIndex(String q, Integer i);
	
	public Integer createTriage(Triage t);
	public Integer updateTriage(Triage t);
	public Integer deleteTriage(String ID);
}
