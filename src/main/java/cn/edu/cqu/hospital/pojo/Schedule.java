package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Schedule {
    private String id;

    private String patientId;

    private String prescriptionId;

    private Integer state;

    private Date time;

    public Schedule(String id, String patientId, String prescriptionId, Integer state, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.prescriptionId = prescriptionId;
        this.state = state;
        this.time = time;
    }

    public Schedule() {
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

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId == null ? null : prescriptionId.trim();
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