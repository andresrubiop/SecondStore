package com.stores.app.storesecond;

import com.stores.app.storesecond.dao.BrandsDao;
import com.stores.app.storesecond.dao.ColoursDao;
import com.stores.app.storesecond.dao.impl.BrandsDaoImpl;
import com.stores.app.storesecond.dao.impl.ColoursDaoImpl;
import com.stores.app.storesecond.entities.Brands;
import com.stores.app.storesecond.entities.Colours;

/**
 * Hello world!
 *Andresrubio
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        BrandsDao brand = new BrandsDaoImpl();
		Brands b = new Brands();
		
		b.setNameBrands("Adidas");
		
		brand.create(b);
		brand.
		
		ColoursDao colour = new ColoursDaoImpl();
		Colours c = new Colours();
		
		c.setNameColours("White");
		
		colour.create(c);
    }
}
