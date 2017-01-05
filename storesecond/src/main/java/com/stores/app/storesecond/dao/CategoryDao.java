package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.model.Category;

public interface CategoryDao {
  Category findById(int id);

  void saveCategory(Category category);
  
  void deleteCategoryById(String idCategory);
  
  List<Category> findAllCategories();

  Category findCategoryById(String idCategory);

}
