package cn.edu.cqu.hospital.pojo;

import java.util.Date;

public class Refund {
    private String id;

    private String patientId;

    private Integer item;

    private String itemId;

    private Double price;

    private Date time;

    public Refund(String id, String patientId, Integer item, String itemId, Double price, Date time) {
        this.id = id;
        this.patientId = patientId;
        this.item = item;
        this.itemId = itemId;
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
}