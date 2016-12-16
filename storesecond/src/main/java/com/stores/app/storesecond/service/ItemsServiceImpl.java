package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stores.app.storesecond.dao.ItemsDao;
import com.stores.app.storesecond.entities.Items;

public class ItemsServiceImpl implements ItemsService{
	@Autowired
	private ItemsDao dao;
	@Override
	public Items findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveItems(Items items) {
		dao.saveItems(items);
		
	}

	@Override
	public void updateItems(Items items) {
		Items entity = dao.findById(items.getIdItems());
		if(entity!=null){
			entity.setNameItems(items.getNameItems());
			entity.setBrands(items.getBrands());
			entity.setColours(items.getColours());
			entity.setDescriptionItems(items.getDescriptionItems());
			entity.setLinkItems(items.getLinkItems());
			
		}
	}

	@Override
	public void deleteItemsById(String iditems) {
		dao.deleteItemsById(iditems);
		
	}

	@Override
	public List<Items> findAllItems() {
		return dao.findAllItems();
	}

	@Override
	public Items findItemsById(String iditems) {
		return dao.findItemsById(iditems);
	}

	@Override
	public boolean isItemsIdUnique(Integer id, String iditems) {
		Items items = findItemsById(iditems);
		return ( items == null || ((id != null) && (items.getIdItems() == id)));
	}

}
