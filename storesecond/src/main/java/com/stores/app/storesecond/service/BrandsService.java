package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.entities.Brands;



public interface BrandsService {
	Brands findById(int id);
	
	void saveBrands(Brands brands);
	
	void updateBrands(Brands brands);
	
	void deleteBrandsById(String idbrands);

	List<Brands> findAllBrands(); 
	
	Brands findBrandsById(String idbrands);

	boolean isBrandsIdUnique(Integer id, String idbrands);
	
}


