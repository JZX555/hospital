package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Payment;

public interface PaymentService {
	public Payment getPaymentByID(String ID);
	public Payment[] getPaymentByPatient(String ID);
	
	public void createPayment(Payment p);
	public void updatePayment(Payment p);
	public void deletaPayment(String ID);
}
