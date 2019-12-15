package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Requisition {
    private String id;

    private String patientId;

    private String docId;

    private String recordId;

    private String itemId;

    private Double price;

    private Date time;

    private Integer state;

    public Requisition(String id, String patientId, String docId, String recordId, String itemId, Double price, Date time, Integer state) {
        this.id = id;
        this.patientId = patientId;
        this.docId = docId;
        this.recordId = recordId;
        this.itemId = itemId;
        this.price = price;
        this.time = time;
        this.state = state;
    }

    public Requisition() {
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

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}