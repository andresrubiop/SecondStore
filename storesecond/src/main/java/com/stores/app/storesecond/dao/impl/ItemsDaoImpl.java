package com.stores.app.storesecond.dao.impl;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.ItemsDao;

import com.stores.app.storesecond.entities.Items;


public class ItemsDaoImpl extends AbstractDao<Integer, Items> implements ItemsDao 
{
	public Items findById(int id) {
		return getByKey(id);
	}

	public void saveItems(Items item) {
		persist(item);
	}

	
	@SuppressWarnings("unchecked")
	public List<Items> findAllItems() {
		Criteria criteria = createEntityCriteria();
		return (List<Items>) criteria.list();
	}

	
	@Override
	public void deleteItemsById(String iditems) {
		// TODO Auto-generated method stub
				Query query = getSession().createSQLQuery("delete from Items where iditems = :iditems");
				query.setString("iditems", iditems);
				query.executeUpdate();
		
	}

	@Override
	public Items findItemsById(String iditems) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("iditems", iditems));
		return (Items) criteria.uniqueResult();
	}

}
