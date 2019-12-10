package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.RefundMapper;
import cn.edu.cqu.hospital.pojo.Refund;
import cn.edu.cqu.hospital.service.RefundService;

@Service
public class RefundServiceImpl implements RefundService {
	@Autowired
	private RefundMapper refundDao;
	
	public Refund getRefundByID(String ID) {
		return this.refundDao.selectByPrimaryKey(ID);
	}

	public Refund[] getRefundByPatient(String ID) {
		return this.refundDao.selecctByPatientKey(ID);
	}

	public void createRefund(Refund r) {
		this.refundDao.insertSelective(r);
	}

	public void updateRefund(Refund r) {
		this.refundDao.updateByPrimaryKeySelective(r);
	}

	public void deleteRefund(String ID) {
		this.refundDao.deleteByPrimaryKey(ID);
	}

}
