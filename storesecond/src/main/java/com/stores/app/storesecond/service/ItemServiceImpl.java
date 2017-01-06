package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.ItemDao;
import com.stores.app.storesecond.model.Item;
@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDao dao;
	//@Override
	public Item findById(int id) {
		return dao.findById(id);
	}

	//@Override
	public void saveItem(Item item) {
		dao.saveItem(item);
		
	}

	//@Override
	public void updateItem(Item item) {
		Item entity = dao.findById(item.getIdItem());
		if(entity!=null){
			entity.setNameItem(item.getNameItem());
			entity.setBrand(item.getBrand());
			entity.setColour(item.getColour());
			entity.setDescriptionItem(item.getDescriptionItem());
			entity.setLinkItem(item.getLinkItem());
			
		}
	}

	//@Override
	public void deleteItemById(String idItem) {
		dao.deleteItemById(idItem);
		
	}

	//@Override
	public List<Item> findAllItems() {
		return dao.findAllItems();
	}

	//@Override
	public Item findItemById(String idItem) {
		return dao.findItemById(idItem);
	}

	
	

}
