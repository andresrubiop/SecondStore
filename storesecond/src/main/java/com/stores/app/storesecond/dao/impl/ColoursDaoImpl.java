package com.stores.app.storesecond.dao.impl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.ColoursDao;

import com.stores.app.storesecond.entities.Colours;


public class ColoursDaoImpl extends AbstractDao<Integer, Colours> implements ColoursDao
{
	public Colours findById(int id) {
		return getByKey(id);
	}

	public void saveColours(Colours colour) {
		persist(colour);
	}

	
	@SuppressWarnings("unchecked")
	public List<Colours> findAllColours() {
		Criteria criteria = createEntityCriteria();
		return (List<Colours>) criteria.list();
	}

	public Colours findColoursById(String idcolours) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idcolours", idcolours));
		return (Colours) criteria.uniqueResult();
	}

	@Override
	public void deleteColoursById(String idcolours) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Colours where idcolours = :idcolours");
		query.setString("idcolours", idcolours);
		query.executeUpdate();
		
	}
	

	

}
