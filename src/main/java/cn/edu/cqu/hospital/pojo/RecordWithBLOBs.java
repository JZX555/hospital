package cn.edu.cqu.hospital.pojo;

import java.sql.Date;

public class RecordWithBLOBs extends Record {
    private String illness;

    private String history;

    private String result;

    private String treatment;

    public RecordWithBLOBs(String id, String patientId, String docId, Date time, String illness, String history, String result, String treatment) {
        super(id, patientId, docId, time);
        this.illness = illness;
        this.history = history;
        this.result = result;
        this.treatment = treatment;
    }

    public RecordWithBLOBs() {
        super();
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness == null ? null : illness.trim();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history == null ? null : history.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment == null ? null : treatment.trim();
    }
}