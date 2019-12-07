package cn.edu.cqu.hospital.pojo;

public class Dispenser {
    private String id;

    private String password;

    public Dispenser(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Dispenser() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}