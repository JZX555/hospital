package cn.edu.cqu.hospital.service.impl;

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

	public void createRequisition(Requisition r) {
		this.requisitionDao.insertSelective(r);
	}

	public void updateRequisition(Requisition r) {
		this.requisitionDao.updateByPrimaryKeySelective(r);
	}

	public void deleteRequisition(String ID) {
		this.requisitionDao.deleteByPrimaryKey(ID);
	}
}
