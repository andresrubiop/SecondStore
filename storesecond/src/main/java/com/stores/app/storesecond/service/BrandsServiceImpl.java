package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.BrandsDao;
import com.stores.app.storesecond.entities.Brands;



@Service("brandsService")
@Transactional
public class BrandsServiceImpl implements BrandsService {
	@Autowired
	private BrandsDao dao;
	
	public Brands findById(int id) {
		return dao.findById(id);
	}

	public void saveBrands(Brands brands) {
		dao.saveBrands(brands);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateBrands(Brands brands) {
		Brands entity = dao.findById(brands.getIdBrands());
		if(entity!=null){
			entity.setNameBrands(brands.getNameBrands());
			
		}
	}

	public void deleteBrandsById(String idbrands) {
		dao.deleteBrandsById(idbrands);
	}
	
	public List<Brands> findAllBrands() {
		return dao.findAllBrands();
	}

	public Brands findBrandsById(String idbrands) {
		return dao.findBrandsById(idbrands);
	}

	public boolean isBrandsIdUnique(Integer id, String idbrands) {
		Brands brands = findBrandsById(idbrands);
		return ( brands == null || ((id != null) && (brands.getIdBrands() == id)));
	}

}
