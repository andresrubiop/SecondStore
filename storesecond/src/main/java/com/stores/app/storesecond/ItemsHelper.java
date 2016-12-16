package com.stores.app.storesecond;

import com.stores.app.storesecond.dao.BrandsDao;
import com.stores.app.storesecond.dao.impl.BrandsDaoImpl;
import com.stores.app.storesecond.entities.Brands;
import com.stores.app.storesecond.dao.ColoursDao;
import com.stores.app.storesecond.dao.impl.ColoursDaoImpl;
import com.stores.app.storesecond.entities.Colours;
import com.stores.app.storesecond.dao.ItemsDao;
import com.stores.app.storesecond.dao.impl.ItemsDaoImpl;
import com.stores.app.storesecond.entities.Items;

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
	public void updateBrand(int brandId, String nameBrands)
	{
		BrandsDao brand = new BrandsDaoImpl();
		Brands b = new Brands();
		b.setIdBrands(brandId);
		b.setNameBrands(nameBrands);
		brand.update(b);
		
	}
	public void deleteBrand(int brandId)
	{
		BrandsDao brand = new BrandsDaoImpl();
		Brands b = new Brands();
		b.setIdBrands(brandId);
		brand.delete(b);
		
	}
	public void addColour(String nameColours)
	{
		 ColoursDao colour = new ColoursDaoImpl();
		 Colours c = new Colours();
		 c.setNameColours(nameColours);
		 colour.create(c);
	}
	public void updateColour(int colourId,String nameColours)
	{
		 ColoursDao colour = new ColoursDaoImpl();
		 Colours c = new Colours();
		 c.setIdColours(colourId);
		 c.setNameColours(nameColours);
		 colour.create(c);
	}
	public void deleteColour(int colourId)
	{
		 ColoursDao colour = new ColoursDaoImpl();
		 Colours c = new Colours();
		 c.setIdColours(colourId);
		 colour.delete(c);
	}
	public void addItem(String nameItems, Colours colourC, Brands brandC, String description,String linkItem)
	{
		ItemsDao item= new ItemsDaoImpl();
		Items i=new Items();
		i.setNameItems(nameItems);
		i.setBrands(brandC);
		i.setColours(colourC);
		i.setDescriptionItems(description);
		i.setLinkItems(linkItem);
		item.create(i);
	}
	public void updateItem(int itemId,String nameItems, Colours colourC, Brands brandC, String description,String linkItem)
	{
		ItemsDao item= new ItemsDaoImpl();
		Items i=new Items();
		i.setIdItems(itemId);
		i.setNameItems(nameItems);
		i.setBrands(brandC);
		i.setColours(colourC);
		i.setDescriptionItems(description);
		i.setLinkItems(linkItem);
		item.update(i);
	}
	public void addItem(int itemId)
	{
		ItemsDao item= new ItemsDaoImpl();
		Items i=new Items();
		i.setIdItems(itemId);
		item.delete(i);
	}
	
	
	
	

}
