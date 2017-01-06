/**
 * 
 */
package com.stores.app.storesecond.controller;



import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.mockito.Mockito.atLeastOnce;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stores.app.storesecond.model.Brand;
import com.stores.app.storesecond.model.Category;
import com.stores.app.storesecond.model.Colour;
import com.stores.app.storesecond.model.Item;
import com.stores.app.storesecond.model.User;
import com.stores.app.storesecond.service.BrandService;
import com.stores.app.storesecond.service.CategoryService;
import com.stores.app.storesecond.service.ColourService;
import com.stores.app.storesecond.service.ItemService;
import com.stores.app.storesecond.service.UserService;




public class AppControllerTest {

  @Mock
  BrandService brandService;
  
  @Mock
  CategoryService categoryService;
  
  @Mock
  ColourService colourService;
  
  @Mock
  ItemService itemService;
  
  @Mock
  UserService userService;
  
  @Mock
  MessageSource message;
  
  @InjectMocks
  AppController appController;
  
  @Spy
  List<Brand> brands = new ArrayList<Brand>();
  
  @Spy
  List<Category> categories = new ArrayList<Category>();
  
  @Spy
  List<Colour> colours = new ArrayList<Colour>();
  
  @Spy
  List<User> users = new ArrayList<User>();
  
  @Spy
  List<Item> items = new ArrayList<Item>();

  @Spy
  ModelMap model;
  
  @Mock
  BindingResult result;
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    brands = getBrandList();
    categories = getCategoryList();
    items = getItemList();
    colours = getColourList();
    users = getUserList();
  }
  
  @Test
  public void listBrands(){
    when(brandService.findAllBrands()).thenReturn(brands);
    Assert.assertEquals(appController.listBrands(model), "allbrands");
    Assert.assertEquals(model.get("brands"), brands);
    verify(brandService, atLeastOnce()).findAllBrands();
  }
  
  @Test
  public void listCategories(){
    when(categoryService.findAllCategories()).thenReturn(categories);
    Assert.assertEquals(appController.listCategories(model), "allcategories");
    Assert.assertEquals(model.get("categories"), categories);
    verify(categoryService, atLeastOnce()).findAllCategories();
  }
  
  @Test
  public void listColours(){
    when(colourService.findAllColours()).thenReturn(colours);
    Assert.assertEquals(appController.listColours(model), "allcolours");
    Assert.assertEquals(model.get("colours"), colours);
    verify(colourService, atLeastOnce()).findAllColours();
  }
  
  @Test
  public void listItems(){
    when(itemService.findAllItems()).thenReturn(items);
    Assert.assertEquals(appController.listItems(model), "allitems");
    Assert.assertEquals(model.get("items"), items);
    verify(itemService, atLeastOnce()).findAllItems();
  }
  
  @Test
  public void listUsers(){
    when(userService.findAllUsers()).thenReturn(users);
    Assert.assertEquals(appController.listUsers(model), "allusers");
    Assert.assertEquals(model.get("users"), users);
    verify(userService, atLeastOnce()).findAllUsers();
  }
  
  @Test
  public void newBrand(){
    Assert.assertEquals(appController.newBrand(model), "registration");
    Assert.assertNotNull(model.get("brand"));
    Assert.assertFalse((Boolean)model.get("edit"));
    Assert.assertEquals(((Brand)model.get("brand")).getIdBrand(), 0);
  }
  @Test
  public void newCategory(){
    Assert.assertEquals(appController.newCategory(model), "registration");
    Assert.assertNotNull(model.get("category"));
    Assert.assertFalse((Boolean)model.get("edit"));
    Assert.assertEquals(((Category)model.get("category")).getIdCategory(), 0);
  }
  @Test
  public void newColour(){
    Assert.assertEquals(appController.newColour(model), "registration");
    Assert.assertNotNull(model.get("colour"));
    Assert.assertFalse((Boolean)model.get("edit"));
    Assert.assertEquals(((Colour)model.get("colour")).getIdColour(), 0);
  }
  @Test
  public void newItem(){
    Assert.assertEquals(appController.newItem(model), "registration");
    Assert.assertNotNull(model.get("item"));
    Assert.assertFalse((Boolean)model.get("edit"));
    Assert.assertEquals(((Item)model.get("item")).getIdItem(), 0);
  }
  @Test
  public void newUser(){
    Assert.assertEquals(appController.newUser(model), "registration");
    Assert.assertNotNull(model.get("user"));
    Assert.assertFalse((Boolean)model.get("edit"));
    Assert.assertEquals(((User)model.get("user")).getIdUser(), 0);
  }


  @Test
  public void saveBrandWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(brandService).saveBrand(any(Brand.class));
    Assert.assertEquals(appController.saveBrand(brands.get(0), result, model), "registration");
  }
  
  @Test
  public void saveColourWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(colourService).saveColour(any(Colour.class));
    Assert.assertEquals(appController.saveColour(colours.get(0), result, model), "registration");
  }
  
  @Test
  public void saveCategoryWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(categoryService).saveCategory(any(Category.class));
    Assert.assertEquals(appController.saveCategory(categories.get(0), result, model), "registration");
  }
  
  @Test
  public void saveItemWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(itemService).saveItem(any(Item.class));
    Assert.assertEquals(appController.saveItem(items.get(0), result, model), "registration");
  }
  
  @Test
  public void saveUserWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(userService).saveUser(any(User.class));
    Assert.assertEquals(appController.saveUser(users.get(0), result, model), "registration");
  }

  
  
  @Test
  public void editBrand(){
    Brand bra = brands.get(0);
    when(brandService.findBrandById(anyString())).thenReturn(bra);
    Assert.assertEquals(appController.editBrand(anyString(), model), "registration");
    Assert.assertNotNull(model.get("brand"));
    Assert.assertTrue((Boolean)model.get("edit"));
    Assert.assertEquals(((Brand)model.get("brand")).getIdBrand(), 1);
  }
  
  @Test
  public void editColour(){
    Colour col = colours.get(0);
    when(colourService.findColourById(anyString())).thenReturn(col);
    Assert.assertEquals(appController.editColour(anyString(), model), "registration");
    Assert.assertNotNull(model.get("colour"));
    Assert.assertTrue((Boolean)model.get("edit"));
    Assert.assertEquals(((Colour)model.get("colour")).getIdColour(), 1);
  }
  
  @Test
  public void editCategory(){
    Category cat = categories.get(0);
    when(categoryService.findCategoryById(anyString())).thenReturn(cat);
    Assert.assertEquals(appController.editCategory(anyString(), model), "registration");
    Assert.assertNotNull(model.get("category"));
    Assert.assertTrue((Boolean)model.get("edit"));
    Assert.assertEquals(((Category)model.get("category")).getIdCategory(), 1);
  }
  
  @Test
  public void editItem(){
    Item ite = items.get(0);
    when(itemService.findItemById(anyString())).thenReturn(ite);
    Assert.assertEquals(appController.editItem(anyString(), model), "registration");
    Assert.assertNotNull(model.get("item"));
    Assert.assertTrue((Boolean)model.get("edit"));
    Assert.assertEquals(((Item)model.get("item")).getIdItem(), 1);
  }
  
  @Test
  public void editUser(){
    User use = users.get(0);
    when(userService.findUserById(anyString())).thenReturn(use);
    Assert.assertEquals(appController.editUser(anyString(), model), "registration");
    Assert.assertNotNull(model.get("user"));
    Assert.assertTrue((Boolean)model.get("edit"));
    Assert.assertEquals(((User)model.get("user")).getIdUser(), 1);
  }

  @Test
  public void updateBrandWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(brandService).updateBrand(any(Brand.class));
    Assert.assertEquals(appController.updateBrand(brands.get(0), result, model,""), "registration");
  }
  
  @Test
  public void updateColourWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(colourService).updateColour(any(Colour.class));
    Assert.assertEquals(appController.updateColour(colours.get(0), result, model,""), "registration");
  }
  
  @Test
  public void updateCategoryWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(categoryService).updateCategory(any(Category.class));
    Assert.assertEquals(appController.updateCategory(categories.get(0), result, model,""), "registration");
  }
  
  @Test
  public void updateItemWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(itemService).updateItem(any(Item.class));
    Assert.assertEquals(appController.updateItem(items.get(0), result, model,""), "registration");
  }
  
  @Test
  public void updateUserWithValidationError(){
    when(result.hasErrors()).thenReturn(true);
    doNothing().when(userService).updateUser(any(User.class));
    Assert.assertEquals(appController.updateUser(users.get(0), result, model,""), "registration");
  }

  
  
  @Test
  public void deleteBrand(){
    doNothing().when(brandService).deleteBrandById(anyString());
    Assert.assertEquals(appController.deleteBrand("123"), "redirect:/list");
  }
  
  @Test
  public void deleteColour(){
    doNothing().when(colourService).deleteColourById(anyString());
    Assert.assertEquals(appController.deleteColour("123"), "redirect:/list");
  }
  
  @Test
  public void deleteCategory(){
    doNothing().when(categoryService).deleteCategoryById(anyString());
    Assert.assertEquals(appController.deleteCategory("123"), "redirect:/list");
  }
  
  @Test
  public void deleteItem(){
    doNothing().when(itemService).deleteItemById(anyString());
    Assert.assertEquals(appController.deleteItem("123"), "redirect:/list");
  }
  
  @Test
  public void deleteUser(){
    doNothing().when(userService).deleteUserById(anyString());
    Assert.assertEquals(appController.deleteUser("123"), "redirect:/list");
  }
  public List<Item> getItemList(){
    Category ca1 = new Category();
    ca1.setIdCategory(1);
    ca1.setNameCategory("TestCategory1");
    Brand b1 = new Brand();
    b1.setIdBrand(1);
    b1.setNameBrand("TestBrand1");
    Colour c1 = new Colour();
    c1.setIdColour(1);
    c1.setNameColour("TestColour1");
    c1.setValueColour("FFF");
    Item i1 = new Item();
    i1.setIdItem(1);
    i1.setNameItem("TestItem1");
    i1.setLinkItem("itemLink.algo");
    i1.setDescriptionItem("descripcionItem");
    i1.setColour(c1);
    i1.setBrand(b1);
    i1.setCategory(ca1);
   
    
    
    items.add(i1);
    
    return items;
  }
  public List<User> getUserList(){
    User u1 = new User();
    u1.setIdUser(1);
    u1.setUserName("NameUser");
    u1.setUserLastName("LastNameUser");
    u1.setUserEmail("EmailUser");
    u1.setUserPassword("keyUser");
    u1.setUserSecurityQuestion1("answer1");
    u1.setUserSecurityQuestion1("answer2");
    
    
    users.add(u1);
    
    return users;
  }
  
  public List<Colour> getColourList(){
    Colour c1 = new Colour();
    c1.setIdColour(1);
    c1.setNameColour("TestColour1");
    c1.setValueColour("FFF");
   
    Colour c2 = new Colour();
    c2.setIdColour(2);
    c2.setNameColour("TestColour2");
    c2.setValueColour("FFA");
    
    colours.add(c1);
    colours.add(c2);
    return colours;
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
    
    public List<Brand> getBrandList(){
      Brand b1 = new Brand();
      b1.setIdBrand(1);
      b1.setNameBrand("TestBrand1");
     
      
      Brand b2 = new Brand();
      b2.setIdBrand(1);
      b2.setNameBrand("TestBrand2");
      
      
      brands.add(b1);
      brands.add(b2);
      return brands;
  }
}