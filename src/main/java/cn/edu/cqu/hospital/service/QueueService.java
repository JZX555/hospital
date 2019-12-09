package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Queue;

public interface QueueService {
	public Queue getQueueByID(String ID);
	
	public Integer getCurIndexByID(String ID);
	public void increaseIndexByID(String ID);
	public void nextIndexByID(String ID);
	public void clearQueueByID(String ID);
	
	public void createQueue(Queue q);
	public void updateQueue(Queue q);
	public void deletaQueue(String ID);
}
