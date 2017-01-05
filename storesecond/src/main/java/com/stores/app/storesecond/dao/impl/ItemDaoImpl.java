package com.stores.app.storesecond.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.ItemDao;
import com.stores.app.storesecond.model.Item;


public class ItemDaoImpl extends AbstractDao<Integer, Item> implements ItemDao 
{
	public Item findById(int id) {
		return getByKey(id);
	}

	public void saveItem(Item item) {
		persist(item);
	}

	
	@SuppressWarnings("unchecked")
	public List<Item> findAllItems() {
		Criteria criteria = createEntityCriteria();
		return (List<Item>) criteria.list();
	}

	
	//@Override
	public void deleteItemById(String idItem) {
		// TODO Auto-generated method stub
				Query query = getSession().createSQLQuery("delete from Item where idItem = :idItem");
				query.setString("idItem", idItem);
				query.executeUpdate();
		
	}

	//@Override
	public Item findItemById(String idItem) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idItem", idItem));
		return (Item) criteria.uniqueResult();
	}

}
