package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Refund;

public interface RefundService {
	public Refund getRefundByID(String ID);
	public List<Refund> getRefundByPatient(String ID);
	public List<Refund> getRefundByDate(String date);
	
	public Integer createRefund(Refund r);
	public Integer updateRefund(Refund r);
	public Integer deleteRefund(String ID);
}
