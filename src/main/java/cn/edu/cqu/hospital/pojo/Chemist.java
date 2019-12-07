package cn.edu.cqu.hospital.pojo;

public class Chemist {
    private String id;

    private String password;

    public Chemist(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public Chemist() {
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