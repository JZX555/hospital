package cn.edu.cqu.hospital.pojo;

public class TriageWithQueue {
	private Queue queue;
	private Triage triage;
	
	public TriageWithQueue() {
		super();
	}
	
	public TriageWithQueue(Queue queue, Triage triage) {
		super();
		
		this.queue = queue;
		this.triage = triage;
	}
	
	public Queue getQueue() {
		return queue;
	}
	public void setQueue(Queue queue) {
		this.queue = queue;
	}
	public Triage getTriage() {
		return triage;
	}
	public void setTriage(Triage triage) {
		this.triage = triage;
	}
}
