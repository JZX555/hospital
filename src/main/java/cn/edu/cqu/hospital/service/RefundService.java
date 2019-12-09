package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Refund;

public interface RefundService {
	public Refund getRefundByID(String ID);
	public Refund[] getRefundByPatient(String ID);
	
	public void createRefund(Refund r);
	public void updateRefund(Refund r);
	public void deleteRefund(String r);
}
