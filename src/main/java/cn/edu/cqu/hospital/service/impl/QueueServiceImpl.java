package cn.edu.cqu.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.QueueMapper;
import cn.edu.cqu.hospital.pojo.Queue;
import cn.edu.cqu.hospital.service.QueueService;

@Service
public class QueueServiceImpl implements QueueService {
	@Autowired
	private QueueMapper queueDao;
	
	public Queue getQueueByID(String ID) {
		return this.queueDao.selectByPrimaryKey(ID);
	}

	public Integer getCurIndexByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		return queue.getCurIndex();
	}

	public Integer increaseNumsByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		int index = queue.getCurIndex();
		int nums = queue.getCurNums();
		queue.setCurNums(nums + 1);
		
		this.queueDao.updateByPrimaryKeySelective(queue);
		
		return index + nums;
	}

	public boolean isEmptyByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		int nums = queue.getCurNums();	
		
		return nums == 0;
	}

	public void nextIndexByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		int index = queue.getCurIndex();
		int nums = queue.getCurNums();
		queue.setCurIndex(index + 1);
		queue.setCurNums(nums - 1);
		
		this.queueDao.updateByPrimaryKeySelective(queue);
	}

	public void clearQueueByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		
		queue.setCurIndex(1);
		queue.setCurNums(0);
		
		this.queueDao.updateByPrimaryKeySelective(queue);
	}

	public void createQueue(Queue q) {
		this.queueDao.insertSelective(q);
	}

	public void updateQueue(Queue q) {
		this.queueDao.updateByPrimaryKeySelective(q);
	}

	public void deletaQueue(String ID) {
		this.queueDao.deleteByPrimaryKey(ID);
	}

}
