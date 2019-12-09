package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Triage;

public interface TriageService {
	public Triage getTriageByID(String ID);
	
	public void createTriage(Triage t);
	public void updateTriage(Triage t);
	public void deleteTriage(String ID);
}
