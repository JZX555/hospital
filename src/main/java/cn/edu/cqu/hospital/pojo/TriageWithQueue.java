package cn.edu.cqu.hospital.pojo;

public class TriageWithQueue {
	private String queue_ID;
	private String register_ID;
	private String doc_ID;
	private String depart_ID;
	private Integer index;
	private Integer remained;
	
	public TriageWithQueue() {
		super();
	}
	
	public TriageWithQueue(String queue_ID, String register_ID, String doc_ID, String depart_ID, Integer index,
			Integer remained) {
		super();
		this.queue_ID = queue_ID;
		this.register_ID = register_ID;
		this.doc_ID = doc_ID;
		this.depart_ID = depart_ID;
		this.index = index;
		this.remained = remained;
	}

	public String getQueue_ID() {
		return queue_ID;
	}

	public void setQueue_ID(String queue_ID) {
		this.queue_ID = queue_ID;
	}

	public String getRegister_ID() {
		return register_ID;
	}

	public void setRegister_ID(String register_ID) {
		this.register_ID = register_ID;
	}

	public String getDoc_ID() {
		return doc_ID;
	}

	public void setDoc_ID(String doc_ID) {
		this.doc_ID = doc_ID;
	}

	public String getDepart_ID() {
		return depart_ID;
	}

	public void setDepart_ID(String depart_ID) {
		this.depart_ID = depart_ID;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getRemained() {
		return remained;
	}

	public void setRemained(Integer remained) {
		this.remained = remained;
	}
}
