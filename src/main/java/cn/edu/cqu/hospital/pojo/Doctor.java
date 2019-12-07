package cn.edu.cqu.hospital.pojo;

public class Doctor {
    private String id;

    private Integer level;

    private String departId;

    private Integer max;

    private String queue;

    private String prioQueue;

    private String password;

    public Doctor(String id, Integer level, String departId, Integer max, String queue, String prioQueue, String password) {
        this.id = id;
        this.level = level;
        this.departId = departId;
        this.max = max;
        this.queue = queue;
        this.prioQueue = prioQueue;
        this.password = password;
    }

    public Doctor() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue == null ? null : queue.trim();
    }

    public String getPrioQueue() {
        return prioQueue;
    }

    public void setPrioQueue(String prioQueue) {
        this.prioQueue = prioQueue == null ? null : prioQueue.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}