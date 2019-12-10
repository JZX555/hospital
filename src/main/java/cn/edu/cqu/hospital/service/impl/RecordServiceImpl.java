package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.RecordMapper;
import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;
import cn.edu.cqu.hospital.service.RecordService;

@Service
public class RecordServiceImpl implements RecordService {
	@Autowired
	private RecordMapper recordDao;
	
	public RecordWithBLOBs getRecordByID(String ID) {
		return this.recordDao.selectByPrimaryKey(ID);
	}

	public RecordWithBLOBs[] getRecordByPatient(String ID) {
		return this.recordDao.selectByPatientKey(ID);
	}

	public RecordWithBLOBs[] getRecordByDoctor(String ID) {
		return this.recordDao.selectByDoctorKey(ID);
	}

	public void updateIllnessByID(String ID, String illness) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setIllness(illness);
		
		this.recordDao.updateByPrimaryKeySelective(record);
	}

	public void updateHistoryByID(String ID, String history) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setHistory(history);
		
		this.recordDao.updateByPrimaryKeySelective(record);
	}

	public void updateResultByID(String ID, String result) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setResult(result);
		
		this.recordDao.updateByPrimaryKeySelective(record);
	}

	public void updateTreatmentByID(String ID, String treatment) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setTreatment(treatment);
		
		this.recordDao.updateByPrimaryKeySelective(record);
	}

	public void createRecord(RecordWithBLOBs r) {
		this.recordDao.insertSelective(r);
	}

	public void updateRecord(RecordWithBLOBs r) {
		this.recordDao.updateByPrimaryKeySelective(r);
	}

	public void deleteRecord(String ID) {
		this.recordDao.deleteByPrimaryKey(ID);
	}

}
