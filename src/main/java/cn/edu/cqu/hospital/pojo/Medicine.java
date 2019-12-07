package cn.edu.cqu.hospital.pojo;

public class Medicine {
    private String id;

    private String name;

    private Integer nums;

    private Double price;

    public Medicine(String id, String name, Integer nums, Double price) {
        this.id = id;
        this.name = name;
        this.nums = nums;
        this.price = price;
    }

    public Medicine() {
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

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}