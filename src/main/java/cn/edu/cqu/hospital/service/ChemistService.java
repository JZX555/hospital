package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Chemist;

public interface ChemistService {
	public Chemist getChemistByID(String ID);
	
	public void updateChemist(Chemist c);
	public void updatePassword(String ID, String password);
}
