package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.model.Item;

public interface ItemDao
{
	Item findById(int id);

	void saveItem(Item item);
	
	void deleteItemById(String idItem);
	
	List<Item> findAllItems();

	Item findItemById(String idItem);

}
