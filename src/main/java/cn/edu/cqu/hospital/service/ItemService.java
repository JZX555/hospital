package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Item;

public interface ItemService {
	public Item getItemByID(String ID);
	
	public Integer createItem(Item i);
	public Integer updateItem(Item i);
	public Integer deleteItem(String ID);
}
