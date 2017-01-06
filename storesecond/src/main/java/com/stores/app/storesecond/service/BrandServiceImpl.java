package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.BrandDao;
import com.stores.app.storesecond.model.Brand;



@Service("brandService")
@Transactional
public class BrandServiceImpl implements BrandService {
	@Autowired
	private BrandDao dao;
	
	public Brand findById(int id) {
		return dao.findById(id);
	}

	public void saveBrand(Brand brand) {
		dao.saveBrand(brand);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateBrand(Brand brand) {
		Brand entity = dao.findById(brand.getIdBrand());
		if(entity!=null){
			entity.setNameBrand(brand.getNameBrand());
			
		}
	}

	public void deleteBrandById(String idBrand) {
		dao.deleteBrandById(idBrand);
	}
	
	public List<Brand> findAllBrands() {
		return dao.findAllBrands();
	}

	public Brand findBrandById(String idBrand) {
		return dao.findBrandById(idBrand);
	}

	

}
