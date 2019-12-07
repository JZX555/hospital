package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Refund {
    private String id;

    private String patientId;

    private Integer item;

    private String requisitionId;

    private Double price;

    private Date time;

    public Refund(String id, String patientId, Integer item, String requisitionId, Double price, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.item = item;
        this.requisitionId = requisitionId;
        this.price = price;
        this.time = time;
    }

    public Refund() {
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

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public String getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(String requisitionId) {
        this.requisitionId = requisitionId == null ? null : requisitionId.trim();
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
}