package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Payment;

public interface PaymentService {
	public Payment getPaymentByID(String ID);
	public Payment[] getPaymentByPatient(String ID);
	
	public Integer createPayment(Payment p);
	public Integer updatePayment(Payment p);
	public Integer deletaPayment(String ID);
}
