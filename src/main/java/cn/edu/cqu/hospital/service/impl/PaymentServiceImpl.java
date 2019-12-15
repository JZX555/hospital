package cn.edu.cqu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.PaymentMapper;
import cn.edu.cqu.hospital.pojo.Payment;
import cn.edu.cqu.hospital.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentMapper paymentDao;

	public Payment getPaymentByID(String ID) {
		return this.paymentDao.selectByPrimaryKey(ID);
	}

	public List<Payment> getPaymentByPatient(String ID) {
		return this.paymentDao.selectByPatientKey(ID);
	}

	public List<Payment> getPaymentByDate(String date) {
		return this.paymentDao.selectByDate(date);
	}

	public Integer createPayment(Payment p) {
		return this.paymentDao.insertSelective(p);
	}

	public Integer updatePayment(Payment p) {
		return this.paymentDao.updateByPrimaryKeySelective(p);
	}

	public Integer deletaPayment(String ID) {
		return this.paymentDao.deleteByPrimaryKey(ID);
	}

}
