package cn.edu.cqu.hospital.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.cqu.hospital.Dao.ItemMapper;
import cn.edu.cqu.hospital.pojo.Item;
import cn.edu.cqu.hospital.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemDao;
	
	public Item getItemByID(String ID) {
		return this.itemDao.selectByPrimaryKey(ID);
	}

	public List<Item> getAllItems() {
		return this.itemDao.selectAllItems();
	}

	public Integer createItem(Item i) {
		return this.itemDao.insertSelective(i);
	}

	public Integer updateItem(Item i) {
		return this.itemDao.updateByPrimaryKey(i);
	}

	public Integer deleteItem(String ID) {
		return this.itemDao.deleteByPrimaryKey(ID);
	}

}
