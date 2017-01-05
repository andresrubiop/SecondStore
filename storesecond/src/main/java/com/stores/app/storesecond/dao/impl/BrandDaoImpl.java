package com.stores.app.storesecond.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.BrandDao;
import com.stores.app.storesecond.model.Brand;



public class BrandDaoImpl extends AbstractDao<Integer, Brand> implements BrandDao{
 public Brand findById(int id){
  return getByKey(id);
 }

 public void saveBrand(Brand brand){
  persist(brand);
 }

 @SuppressWarnings("unchecked")
 public List<Brand> findAllBrands() {
  Criteria criteria = createEntityCriteria();
  return (List<Brand>) criteria.list();
 }

 public Brand findBrandById(String idBrand) {
  Criteria criteria = createEntityCriteria();
   criteria.add(Restrictions.eq("idBrand", idBrand));
   return (Brand) criteria.uniqueResult();
  }

 //@Override
 public void deleteBrandById(String idBrand) {
  Query query = getSession().createSQLQuery("delete from Brand where idBrand = :idBrand");
   query.setString("idBrand", idBrand);
   query.executeUpdate();
 }
}
