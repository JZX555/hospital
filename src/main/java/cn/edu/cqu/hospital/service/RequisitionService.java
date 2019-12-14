package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Requisition;

public interface RequisitionService {
	public Requisition getRequisitionByID(String ID);
	public List<Requisition> getRequisitionByPatient(String ID);
	
	public Integer createRequisition(Requisition r);
	public Integer updateRequisition(Requisition r);
	public Integer deleteRequisition(String ID);
}
