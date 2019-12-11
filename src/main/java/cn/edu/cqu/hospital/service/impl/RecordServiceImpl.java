package cn.edu.cqu.hospital.service.impl;

import java.util.List;

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

	public List<RecordWithBLOBs> getRecordByPatient(String ID) {
		return this.recordDao.selectByPatientKey(ID);
	}

	public List<RecordWithBLOBs> getRecordByDoctor(String ID) {
		return this.recordDao.selectByDoctorKey(ID);
	}

	public Integer updateIllnessByID(String ID, String illness) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setIllness(illness);
		
		return this.recordDao.updateByPrimaryKeySelective(record);
	}

	public Integer updateHistoryByID(String ID, String history) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setHistory(history);
		
		return this.recordDao.updateByPrimaryKeySelective(record);
	}

	public Integer updateResultByID(String ID, String result) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setResult(result);
		
		return this.recordDao.updateByPrimaryKeySelective(record);
	}

	public Integer updateTreatmentByID(String ID, String treatment) {
		RecordWithBLOBs record = this.recordDao.selectByPrimaryKey(ID);
		record.setTreatment(treatment);
		
		return this.recordDao.updateByPrimaryKeySelective(record);
	}

	public Integer createRecord(RecordWithBLOBs r) {
		return this.recordDao.insertSelective(r);
	}

	public Integer updateRecord(RecordWithBLOBs r) {
		return this.recordDao.updateByPrimaryKeySelective(r);
	}

	public Integer deleteRecord(String ID) {
		return this.recordDao.deleteByPrimaryKey(ID);
	}

}
