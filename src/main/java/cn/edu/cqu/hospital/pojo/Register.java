package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Register {
    private String id;

    private String patientId;

    private String collectorId;

    private String departId;

    private String docId;

    private Integer type;

    private Integer state;

    private Date time;

    public Register(String id, String patientId, String collectorId, String departId, String docId, Integer type, Integer state, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.collectorId = collectorId;
        this.departId = departId;
        this.docId = docId;
        this.type = type;
        this.state = state;
        this.time = time;
    }

    public Register() {
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

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId == null ? null : collectorId.trim();
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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