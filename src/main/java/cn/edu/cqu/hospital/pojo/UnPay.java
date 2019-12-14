package cn.edu.cqu.hospital.pojo;

public class UnPay {
	private Integer item;
	private String item_ID;
	private String date;
	private Double price;
	
	public UnPay() {
		super();
	}
	
	public UnPay(Integer item, String item_ID, String date, Double price) {
		super();
		this.item = item;
		this.item_ID = item_ID;
		this.date = date;
		this.price = price;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getItem_ID() {
		return item_ID;
	}

	public void setItem_ID(String item_ID) {
		this.item_ID = item_ID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
