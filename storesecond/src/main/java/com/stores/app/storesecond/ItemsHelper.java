package com.stores.app.storesecond;

import com.stores.app.storesecond.dao.BrandsDao;
import com.stores.app.storesecond.dao.impl.BrandsDaoImpl;
import com.stores.app.storesecond.entities.Brands;
import com.stores.app.storesecond.dao.ColoursDao;
import com.stores.app.storesecond.dao.impl.ColoursDaoImpl;
import com.stores.app.storesecond.entities.Colours;

public class ItemsHelper {
	
	public ItemsHelper(){
		
	}
	public void addBrand(String nameBrands)
	{
		 BrandsDao brand = new BrandsDaoImpl();
		 Brands b = new Brands();
		 b.setNameBrands(nameBrands);
		 brand.create(b);
	}
	public void addColour(String nameColours)
	{
		 ColoursDao colour = new ColoursDaoImpl();
		 Colours c = new Colours();
		 c.setNameColours(nameColours);
		 colour.create(c);
	}

}
