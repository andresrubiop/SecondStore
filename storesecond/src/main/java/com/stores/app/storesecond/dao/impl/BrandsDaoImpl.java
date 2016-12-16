package com.stores.app.storesecond.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.BrandsDao;

import com.stores.app.storesecond.entities.Brands;



public class BrandsDaoImpl extends AbstractDao<Integer, Brands> implements BrandsDao 
{
	
	public Brands findById(int id) {
		return getByKey(id);
	}

	public void saveBrands(Brands brand) {
		persist(brand);
	}

	
	@SuppressWarnings("unchecked")
	public List<Brands> findAllBrands() {
		Criteria criteria = createEntityCriteria();
		return (List<Brands>) criteria.list();
	}

	public Brands findBrandsById(String idbrands) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("idbrands", idbrands));
		return (Brands) criteria.uniqueResult();
	}

	@Override
	public void deleteBrandsById(String idbrands) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Brands where idbrands = :idbrands");
		query.setString("idbrands", idbrands);
		query.executeUpdate();
		
	}

	
	

}
