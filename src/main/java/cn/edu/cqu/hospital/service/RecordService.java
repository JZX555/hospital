package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Record;

public interface RecordService {
	public Record getRecordByID(String ID);
	public Record[] getRecordByPatient(String ID);
	public Record[] getRecordByDoctor(String ID);
	
	public void updateIllnessByID(String ID, String illness);
	public void updateHistoryByID(String ID, String history);
	public void updateResultByID(String ID, String result);
	public void updateTreatmentByID(String ID, String treatment);
	
	public void  createRecord(Record r);
	public void updateRecord(Record r);
	public void deleteRecord(String ID);
}
