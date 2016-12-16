package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.entities.Brands;



public interface BrandsDao {
	Brands findById(int id);

	void saveBrands(Brands colours);
	
	void deleteBrandsById(String idbrands);
	
	List<Brands> findAllBrands();

	Brands findBrandsById(String idbrands);

}
