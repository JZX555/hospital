package cn.edu.cqu.hospital.pojo;

public class PatientWithRecord {
	private Patient patient;
	
	private RecordWithBLOBs recordWithBLOBs;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public RecordWithBLOBs getRecordWithBLOBs() {
		return recordWithBLOBs;
	}
	public void setRecordWithBLOBs(RecordWithBLOBs recordWithBLOBs) {
		this.recordWithBLOBs = recordWithBLOBs;
	}
}
