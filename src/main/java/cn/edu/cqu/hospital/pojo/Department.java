package cn.edu.cqu.hospital.pojo;

public class Department {
    private String id;

    private String type;

    private String queue;

    private String prioQueue;

    public Department(String id, String type, String queue, String prioQueue) {
        this.id = id;
        this.type = type;
        this.queue = queue;
        this.prioQueue = prioQueue;
    }

    public Department() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
}