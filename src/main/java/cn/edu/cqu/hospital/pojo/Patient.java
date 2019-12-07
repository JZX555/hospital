package cn.edu.cqu.hospital.pojo;

public class Patient {
    private String id;

    private String name;

    private Integer sex;

    private String phone;

    private Integer age;

    private String password;

    private Integer canceltime;

    public Patient(String id, String name, Integer sex, String phone, Integer age, String password, Integer canceltime) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.age = age;
        this.password = password;
        this.canceltime = canceltime;
    }

    public Patient() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getCanceltime() {
        return canceltime;
    }

    public void setCanceltime(Integer canceltime) {
        this.canceltime = canceltime;
    }
}