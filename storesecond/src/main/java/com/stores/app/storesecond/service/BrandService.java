package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.model.Brand;



public interface BrandService {
	Brand findById(int id);
	
	void saveBrand(Brand brand);
	
	void updateBrand(Brand brand);
	
	void deleteBrandById(String idBrand);

	List<Brand> findAllBrands(); 
	
	Brand findBrandById(String idBrand);

	
	
}


