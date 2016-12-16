package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.entities.Items;

public interface ItemsDao
{
	Items findById(int id);

	void saveItems(Items items);
	
	void deleteItemsById(String iditems);
	
	List<Items> findAllItems();

	Items findItemsById(String iditems);

}
