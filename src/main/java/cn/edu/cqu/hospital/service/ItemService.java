package cn.edu.cqu.hospital.service;

import cn.edu.cqu.hospital.pojo.Item;

public interface ItemService {
	public Item getItemByID(String ID);
	
	public void createItem(Item i);
	public void updateItem(Item i);
	public void deleteItem(String ID);
}
