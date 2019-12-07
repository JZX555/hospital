package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Reservation {
    private String id;

    private String patientId;

    private String departId;

    private String docId;

    private Integer state;

    private Date time;

    public Reservation(String id, String patientId, String departId, String docId, Integer state, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.departId = departId;
        this.docId = docId;
        this.state = state;
        this.time = time;
    }

    public Reservation() {
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

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId == null ? null : docId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}