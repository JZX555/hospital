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

	public Integer nextIndexByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		int index = queue.getCurIndex();
		int nums = queue.getCurNums();
		
		if(nums == 0)
			return 0;
		
		queue.setCurIndex(index + 1);
		queue.setCurNums(nums - 1);
		
		this.queueDao.updateByPrimaryKeySelective(queue);
		
		return index;
	}

	public Integer clearQueueByID(String ID) {
		Queue queue = this.queueDao.selectByPrimaryKey(ID);
		
		queue.setCurIndex(1);
		queue.setCurNums(0);
		
		return this.queueDao.updateByPrimaryKeySelective(queue);
	}

	public Integer createQueue(Queue q) {
		return this.queueDao.insertSelective(q);
	}

	public Integer updateQueue(Queue q) {
		return this.queueDao.updateByPrimaryKeySelective(q);
	}

	public Integer deletaQueue(String ID) {
		return this.queueDao.deleteByPrimaryKey(ID);
	}

}
