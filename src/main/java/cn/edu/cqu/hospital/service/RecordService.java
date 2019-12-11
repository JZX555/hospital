package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;

public interface RecordService {
	public RecordWithBLOBs getRecordByID(String ID);
	public RecordWithBLOBs[] getRecordByPatient(String ID);
	public RecordWithBLOBs[] getRecordByDoctor(String ID);
	
	public Integer updateIllnessByID(String ID, String illness);
	public Integer updateHistoryByID(String ID, String history);
	public Integer updateResultByID(String ID, String result);
	public Integer updateTreatmentByID(String ID, String treatment);
	
	public Integer  createRecord(RecordWithBLOBs r);
	public Integer updateRecord(RecordWithBLOBs r);
	public Integer deleteRecord(String ID);
}
