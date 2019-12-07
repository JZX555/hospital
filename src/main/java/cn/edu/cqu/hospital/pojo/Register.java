package cn.edu.cqu.hospital.pojo;

public class Register {
    private String id;

    private String patientId;

    private String collectorId;

    private String departId;

    private String doctorId;

    private Integer type;

    public Register(String id, String patientId, String collectorId, String departId, String doctorId, Integer type) {
        this.id = id;
        this.patientId = patientId;
        this.collectorId = collectorId;
        this.departId = departId;
        this.doctorId = doctorId;
        this.type = type;
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}