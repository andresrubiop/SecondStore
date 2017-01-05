package com.stores.app.storesecond.dao.impl;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.ColourDao;
import com.stores.app.storesecond.model.Colour;


public class ColourDaoImpl extends AbstractDao<Integer, Colour> implements ColourDao
{
	public Colour findById(int id) {
		return getByKey(id);
	}

	public void saveColour(Colour colour) {
		persist(colour);
	}

	
	@SuppressWarnings("unchecked")
	public List<Colour> findAllColours() {
		Criteria criteria = createEntityCriteria();
		return (List<Colour>) criteria.list();
	}

	public Colour findColourById(String idColour) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idColour", idColour));
		return (Colour) criteria.uniqueResult();
	}

	//@Override
	public void deleteColourById(String idColour) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Colour where idColours = :idColour");
		query.setString("idColour", idColour);
		query.executeUpdate();
		
	}
	

	

}
