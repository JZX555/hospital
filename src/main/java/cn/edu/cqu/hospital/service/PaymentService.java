package cn.edu.cqu.hospital.service;

import java.util.List;

import cn.edu.cqu.hospital.pojo.Payment;

public interface PaymentService {
	public Payment getPaymentByID(String ID);
	public List<Payment> getPaymentByPatient(String ID);
	public List<Payment> getPaymentByDate(String date);
	
	public Integer createPayment(Payment p);
	public Integer updatePayment(Payment p);
	public Integer deletaPayment(String ID);
}
