package cn.edu.cqu.hospital.service.impl;

import java.util.List;

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

	public List<Refund> getRefundByPatient(String ID) {
		return this.refundDao.selecctByPatientKey(ID);
	}

	public Integer createRefund(Refund r) {
		return this.refundDao.insertSelective(r);
	}

	public Integer updateRefund(Refund r) {
		return this.refundDao.updateByPrimaryKeySelective(r);
	}

	public Integer deleteRefund(String ID) {
		return this.refundDao.deleteByPrimaryKey(ID);
	}

}
