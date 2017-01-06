package com.stores.app.storesecond.service;

import java.util.List;

import com.stores.app.storesecond.model.Category;

public interface CategoryService {
  Category findById(int id);
  
  void saveCategory(Category category);
  
  void updateCategory(Category category);
  
  void deleteCategoryById(String idCategory);

  List<Category> findAllCategories(); 
  
  Category findCategoryById(String idCategory);

 
}
