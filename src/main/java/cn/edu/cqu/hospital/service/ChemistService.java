package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Chemist;

public interface ChemistService {
	public Chemist getChemistByID(String ID);
	
	public Integer updateChemist(Chemist c);
	public Integer updatePassword(String ID, String password);
}
