package cn.edu.cqu.hospital.pojo;

public class Triage {
    private String id;

    private String patientId;

    private String registerId;

    private String queue;

    private Integer index;

    public Triage(String id, String patientId, String registerId, String queue, Integer index) {
        this.id = id;
        this.patientId = patientId;
        this.registerId = registerId;
        this.queue = queue;
        this.index = index;
    }

    public Triage() {
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

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId == null ? null : registerId.trim();
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}