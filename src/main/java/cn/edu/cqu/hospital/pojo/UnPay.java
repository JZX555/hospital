package cn.edu.cqu.hospital.pojo;

public class UnPay {
	private String patient_ID;
	private Integer item;
	private String item_ID;
	private Double price;
	
	public UnPay() {
		super();
	}
	
	public UnPay(String patient_ID, Integer item, String item_ID, Double price) {
		super();
		this.patient_ID = patient_ID;
		this.item = item;
		this.item_ID = item_ID;
		this.price = price;
	}

	public String getPatient_ID() {
		return patient_ID;
	}

	public void setPatient_ID(String patient_ID) {
		this.patient_ID = patient_ID;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
