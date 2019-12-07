package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Record {
    private String id;

    private String patientId;

    private String docId;

    private Date time;

    public Record(String id, String patientId, String docId, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.docId = docId;
        this.time = time;
    }

    public Record() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}