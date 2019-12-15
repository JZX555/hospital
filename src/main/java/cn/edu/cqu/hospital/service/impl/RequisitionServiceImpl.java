package cn.edu.cqu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.RequisitionMapper;
import cn.edu.cqu.hospital.pojo.Requisition;
import cn.edu.cqu.hospital.service.RequisitionService;

@Service
public class RequisitionServiceImpl implements RequisitionService {
	@Autowired
	private RequisitionMapper requisitionDao;
	
	public Requisition getRequisitionByID(String ID) {
		return this.requisitionDao.selectByPrimaryKey(ID);
	}

	public List<Requisition> getRequisitionByPatient(String ID) {
		return this.requisitionDao.selectByPatientKey(ID);
	}

	public List<Requisition> getRequisitionByRecord(String ID) {
		return this.requisitionDao.selectByRecordKey(ID);
	}

	public Integer createRequisition(Requisition r) {
		return this.requisitionDao.insertSelective(r);
	}

	public Integer updateRequisition(Requisition r) {
		return this.requisitionDao.updateByPrimaryKeySelective(r);
	}

	public Integer deleteRequisition(String ID) {
		return this.requisitionDao.deleteByPrimaryKey(ID);
	}
}
