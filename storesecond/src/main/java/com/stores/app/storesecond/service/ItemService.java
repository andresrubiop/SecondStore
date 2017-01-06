package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.model.Item;

public interface ItemService {
	Item findById(int id);
	
	void saveItem(Item item);
	
	void updateItem(Item item);
	
	void deleteItemById(String idItem);

	List<Item> findAllItems(); 
	
	Item findItemById(String idItem);

	

}
