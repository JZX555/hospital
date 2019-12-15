package cn.edu.cqu.hospital.pojo;

public class Settlement {
	private Double payment;
	private Double refund;
	private Double all;
	private String date;
	
	public Settlement() {
		super();
	}
	
	public Settlement(Double payment, Double refund, Double all, String date) {
		super();
		this.payment = payment;
		this.refund = refund;
		this.all = all;
		this.date = date;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getRefund() {
		return refund;
	}

	public void setRefund(Double refund) {
		this.refund = refund;
	}

	public Double getAll() {
		return all;
	}

	public void setAll(Double all) {
		this.all = all;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
