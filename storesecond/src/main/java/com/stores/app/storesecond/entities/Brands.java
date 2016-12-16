package com.stores.app.storesecond.entities;
// Generated 28 nov. 2016 13:45:51 by Hibernate Tools 5.2.0.Beta1

//import java.util.HashSet;
//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.stores.app.storesecond.dao.BrandsDao;
import com.stores.app.storesecond.dao.impl.BrandsDaoImpl;


 @Entity
 @Table(name = "Brands")
 public class Brands{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idBrands;
	@Column
	private String nameBrands;
	
	
 public Brands(){
	}

	public Brands(int idBrands)
	{
		this.idBrands = idBrands;
	}

	public Brands(int idBrands, String nameBrands) 
	{
		this.idBrands = idBrands;
		this.nameBrands = nameBrands;
		
	}

	public int getIdBrands() 
	{
		return this.idBrands;
	}

	public void setIdBrands(int idBrands) 
	{
		this.idBrands = idBrands;
	}

	public String getNameBrands() 
	{
		return this.nameBrands;
	}

	public void setNameBrands(String nameBrands)
	{
		this.nameBrands = nameBrands;

	}
	
	/*public Set getItemses() {
		return this.itemses;
	}

	public void setItemses(Set itemses) {
		this.itemses = itemses;
	}*/

}
