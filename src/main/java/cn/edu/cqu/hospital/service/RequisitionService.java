package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Requisition;

public interface RequisitionService {
	public Requisition getRequisitionByID(String ID);
	
	public Integer createRequisition(Requisition r);
	public Integer updateRequisition(Requisition r);
	public Integer deleteRequisition(String ID);
}
