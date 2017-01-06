/**
 * 
 */
package com.stores.app.storesecond.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stores.app.storesecond.dao.CategoryDao;
import com.stores.app.storesecond.model.Category;

/**
 * @author andre
 *
 */
public class CategoryServiceImplTest {
  @Mock
  CategoryDao dao;
  @InjectMocks
  CategoryServiceImpl categoryService;
  
  @Spy
  List<Category> categories = new ArrayList<Category>();
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    categories = getCategoryList();
  }

  @Test
  public void findById(){
    Category cat = categories.get(0);
    when(dao.findById(anyInt())).thenReturn(cat);
    Assert.assertEquals(categoryService.findById(cat.getIdCategory()),cat);
  }

  @Test
  public void saveCategory(){
    doNothing().when(dao).saveCategory(any(Category.class));
    categoryService.saveCategory(any(Category.class));
    verify(dao, atLeastOnce()).saveCategory(any(Category.class));
  }
  
  @Test
  public void updateCategory(){
    Category cat = categories.get(0);
    when(dao.findById(anyInt())).thenReturn(cat);
    categoryService.updateCategory(cat);
    verify(dao, atLeastOnce()).findById(anyInt());
  }

  @Test
  public void deleteBrandById(){
    doNothing().when(dao).deleteCategoryById(anyString());
    categoryService.deleteCategoryById(anyString());
    verify(dao, atLeastOnce()).deleteCategoryById(anyString());
  }
  
  @Test
  public void findAllCategories(){
    when(dao.findAllCategories()).thenReturn(categories);
    Assert.assertEquals(categoryService.findAllCategories(), categories);
  }
  
  @Test
  public void findCategoryById(){
    Category cat = categories.get(0);
    when(dao.findCategoryById(anyString())).thenReturn(cat);
    Assert.assertEquals(categoryService.findCategoryById(anyString()), cat);
  }

   
  public List<Category> getCategoryList(){
    Category c1 = new Category();
    c1.setIdCategory(1);
    c1.setNameCategory("TestCategory1");
    
    Category c2 = new Category();
    c2.setIdCategory(1);
    c2.setNameCategory("TestCategory2");
   
    
   
    
    categories.add(c1);
    categories.add(c2);
    return categories;
  }
}