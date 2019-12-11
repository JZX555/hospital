package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Refund;

public interface RefundService {
	public Refund getRefundByID(String ID);
	public Refund[] getRefundByPatient(String ID);
	
	public Integer createRefund(Refund r);
	public Integer updateRefund(Refund r);
	public Integer deleteRefund(String ID);
}
