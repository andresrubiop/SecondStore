package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.model.Brand;



public interface BrandDao {
	Brand findById(int id);

	void saveBrand(Brand brand);
	
	void deleteBrandById(String idBrand);
	
	List<Brand> findAllBrands();

	Brand findBrandById(String idBrand);

}
