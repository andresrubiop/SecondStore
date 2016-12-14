package com.stores.app.storesecond.dao.impl;



import com.stores.app.storesecond.dao.ColoursDao;
import com.stores.app.storesecond.entities.Colours;

import rest.lets.dao.impl.GenericDaoImpl;

public class ColoursDaoImpl extends GenericDaoImpl implements ColoursDao
{

	private static Class<?>[] annotatedClasses = {Colours.class};		
	public ColoursDaoImpl() 
	{	
		super(Colours.class, annotatedClasses, "hibernate.cfg.xml");
	}

}
