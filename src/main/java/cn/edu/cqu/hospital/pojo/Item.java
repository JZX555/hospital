package cn.edu.cqu.hospital.pojo;

public class Item {
    private String id;

    private String name;

    private Double price;

    public Item(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}