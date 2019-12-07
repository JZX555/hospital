package cn.edu.cqu.hospital.pojo;

public class Queue {
    private String id;

    private Integer max;

    private Integer curNums;

    private Integer curIndex;

    public Queue(String id, Integer max, Integer curNums, Integer curIndex) {
        this.id = id;
        this.max = max;
        this.curNums = curNums;
        this.curIndex = curIndex;
    }

    public Queue() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getCurNums() {
        return curNums;
    }

    public void setCurNums(Integer curNums) {
        this.curNums = curNums;
    }

    public Integer getCurIndex() {
        return curIndex;
    }

    public void setCurIndex(Integer curIndex) {
        this.curIndex = curIndex;
    }
}