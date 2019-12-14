package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageService {
	public Triage getTriageByID(String ID);
	public Triage getByQueueAndIndex(String q, Integer i);
	public List<Triage>  getTriagesByPatient(String ID);
	
	public Integer createTriage(Triage t);
	public Integer updateTriage(Triage t);
	public Integer deleteTriage(String ID);
}
