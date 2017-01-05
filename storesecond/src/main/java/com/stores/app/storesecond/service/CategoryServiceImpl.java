package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.CategoryDao;

import com.stores.app.storesecond.model.Category;

@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
  @Autowired
  private CategoryDao dao;
  public Category findById(int id) {
    return dao.findById(id);
  }

  public void saveCategory(Category category) {
    dao.saveCategory(category);
    
  }

  public void updateCategory(Category category) {
    Category entity = dao.findById(category.getIdCategory());
    if(entity!=null){
      entity.setNameCategory(category.getNameCategory());
    }
  }

  public void deleteCategoryById(String idCategory) {
    dao.deleteCategoryById(idCategory);
    
  }

  public List<Category> findAllCategories() {
    return dao.findAllCategories();
  }

  public Category findCategoryById(String idCategory) {
    return dao.findCategoryById(idCategory);
  }

  public boolean isCategoryIdUnique(Integer id, String idCategory) {
    Category category = findCategoryById(idCategory);
    return ( category == null || ((id != null) && (category.getIdCategory() == id)));
  }

}
