package cn.edu.cqu.hospital.service.impl;

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

	public Payment[] getPaymentByPatient(String ID) {
		return this.paymentDao.selectByPatientKey(ID);
	}

	public void createPayment(Payment p) {
		this.paymentDao.insertSelective(p);
	}

	public void updatePayment(Payment p) {
		this.paymentDao.updateByPrimaryKeySelective(p);
	}

	public void deletaPayment(String ID) {
		this.paymentDao.deleteByPrimaryKey(ID);
	}

}
