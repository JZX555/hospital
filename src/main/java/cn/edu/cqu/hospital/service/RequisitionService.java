package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Requisition;

public interface RequisitionService {
	public Requisition getRequisitionByID(String ID);
	
	public void createRequisition(Requisition r);
	public void updateRequisition(Requisition r);
	public void deleteRequisition(String ID);
}
