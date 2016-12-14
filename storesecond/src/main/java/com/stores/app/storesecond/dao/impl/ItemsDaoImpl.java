package com.stores.app.storesecond.dao.impl;


import com.stores.app.storesecond.dao.ItemsDao;
import com.stores.app.storesecond.entities.Items;

import rest.lets.dao.impl.GenericDaoImpl;
public class ItemsDaoImpl extends GenericDaoImpl implements ItemsDao 
{
	private static Class<?>[] annotatedClasses = {Items.class};		
	public ItemsDaoImpl() 
	{	
		super(Items.class, annotatedClasses, "hibernate.cfg.xml");
	}

}
