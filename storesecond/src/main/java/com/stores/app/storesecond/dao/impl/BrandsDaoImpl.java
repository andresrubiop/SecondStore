package com.stores.app.storesecond.dao.impl;

import com.stores.app.storesecond.dao.BrandsDao;

import com.stores.app.storesecond.entities.Brands;

import rest.lets.dao.impl.GenericDaoImpl;

public class BrandsDaoImpl extends GenericDaoImpl implements BrandsDao 
{
	
	private static Class<?>[] annotatedClasses = {Brands.class};		
	public BrandsDaoImpl()
	{	
		super(Brands.class, annotatedClasses, "hibernate.cfg.xml");
	}

}
