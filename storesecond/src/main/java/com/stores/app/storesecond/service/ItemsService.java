package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.entities.Items;

public interface ItemsService {
	Items findById(int id);
	
	void saveItems(Items items);
	
	void updateItems(Items items);
	
	void deleteItemsById(String iditems);

	List<Items> findAllItems(); 
	
	Items findItemsById(String iditems);

	boolean isItemsIdUnique(Integer id, String iditems);

}
