package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Record;
import cn.edu.cqu.hospital.pojo.RecordWithBLOBs;

public interface RecordService {
	public RecordWithBLOBs getRecordByID(String ID);
	public RecordWithBLOBs[] getRecordByPatient(String ID);
	public RecordWithBLOBs[] getRecordByDoctor(String ID);
	
	public void updateIllnessByID(String ID, String illness);
	public void updateHistoryByID(String ID, String history);
	public void updateResultByID(String ID, String result);
	public void updateTreatmentByID(String ID, String treatment);
	
	public void  createRecord(RecordWithBLOBs r);
	public void updateRecord(RecordWithBLOBs r);
	public void deleteRecord(String ID);
}
