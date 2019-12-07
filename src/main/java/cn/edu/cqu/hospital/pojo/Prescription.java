package cn.edu.cqu.hospital.pojo;

public class Prescription {
    private String id;

    private String patientId;

    private String docId;

    private String medicineId;

    private Integer num;

    private Double price;

    public Prescription(String id, String patientId, String docId, String medicineId, Integer num, Double price) {
        this.id = id;
        this.patientId = patientId;
        this.docId = docId;
        this.medicineId = medicineId;
        this.num = num;
        this.price = price;
    }

    public Prescription() {
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

    public String getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId == null ? null : medicineId.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}