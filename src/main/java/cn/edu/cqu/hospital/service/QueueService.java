package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Queue;

public interface QueueService {
	public Queue getQueueByID(String ID);
	
	public Integer getCurIndexByID(String ID);
	public Integer increaseNumsByID(String ID);
	
	public boolean isEmptyByID(String ID);
	public Integer nextIndexByID(String ID);
	public Integer clearQueueByID(String ID);
	
	public Integer createQueue(Queue q);
	public Integer updateQueue(Queue q);
	public Integer deletaQueue(String ID);
}
