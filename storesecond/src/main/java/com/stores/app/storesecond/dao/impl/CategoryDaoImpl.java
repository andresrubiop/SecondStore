package com.stores.app.storesecond.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.CategoryDao;

import com.stores.app.storesecond.model.Category;

public class CategoryDaoImpl extends AbstractDao<Integer, Category> implements CategoryDao{

  public Category findById(int id) {
    return getByKey(id);
  }

  public void saveCategory(Category category) {
    persist(category);
    
  }

  public void deleteCategoryById(String idCategory) {
    Query query = getSession().createSQLQuery("delete from Category where idCategory = :idCategory");
    query.setString("idCategory", idCategory);
    query.executeUpdate();
    
  }

  @SuppressWarnings("unchecked")
  public List<Category> findAllCategories() {
    Criteria criteria = createEntityCriteria();
    return (List<Category>) criteria.list();
  }

  public Category findCategoryById(String idCategory) {
    Criteria criteria = createEntityCriteria();
    criteria.add(Restrictions.eq("idCategory", idCategory));
    return (Category) criteria.uniqueResult();
   }
  }


