/**
 * 
 */
package com.stores.app.storesecond.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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



/**
 * @author andre
 *
 */
@Controller
@RequestMapping("/")
public class AppController {

  @Autowired
  BrandService brandService;
  
  @Autowired
  CategoryService categoryService;
  
  @Autowired
  ColourService colourService;
  
  @Autowired
  ItemService itemService;
  
  @Autowired
  UserService userService;
  
  @Autowired
  MessageSource messageSource;

  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String listBrands(ModelMap model) {

    List<Brand> brands = brandService.findAllBrands();
    model.addAttribute("brands", brands);
    return "allbrands";
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
  public String newBrand(ModelMap model) {
    Brand brand = new Brand();
    model.addAttribute("brand", brand);
    model.addAttribute("edit", false);
    return "registration";
  }

  /*
   * This method will be called on form submission, handling POST request for
   * saving employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
  public String saveBrand(@Valid Brand brand, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return "registration";
    }

    /*
     * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
     * and applying it on field [ssn] of Model class [Employee].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
     * framework as well while still using internationalized messages.
     * 
     */
    
    
    brandService.saveBrand(brand);

    model.addAttribute("success", "Brand " + brand.getNameBrand() + " registered successfully");
    return "success";
  }


  /*
   * This method will provide the medium to update an existing employee.
   */
  @RequestMapping(value = { "/edit-{idBrand}-brand" }, method = RequestMethod.GET)
  public String editBrand(@PathVariable String idBrand, ModelMap model) {
    Brand brand = brandService.findBrandById(idBrand);
    model.addAttribute("brand", brand);
    model.addAttribute("edit", true);
    return "registration";
  }
  
  /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit-{idBrand}-brand" }, method = RequestMethod.POST)
  public String updateBrand(@Valid Brand brand, BindingResult result,
      ModelMap model, @PathVariable String idBrand) {

    if (result.hasErrors()) {
      return "registration";
    }

    

    brandService.updateBrand(brand);

    model.addAttribute("success", "Brand " + brand.getNameBrand()  + " updated successfully");
    return "success";
  }

  
  /*
   * This method will delete an brand by it's id value.
   */
  @RequestMapping(value = { "/delete-{idBrand}-brand" }, method = RequestMethod.GET)
  public String deleteBrand(@PathVariable String idBrand) {
    brandService.deleteBrandById(idBrand);
    return "redirect:/list";
  }
  
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String listCategories(ModelMap model) {

    List<Category> categories = categoryService.findAllCategories();
    model.addAttribute("categories", categories);
    return "allcategories";
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
  public String newCategory(ModelMap model) {
    Category category = new Category();
    model.addAttribute("category", category);
    model.addAttribute("edit", false);
    return "registration";
  }

  /*
   * This method will be called on form submission, handling POST request for
   * saving employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
  public String saveCategory(@Valid Category category, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return "registration";
    }

    /*
     * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
     * and applying it on field [ssn] of Model class [Employee].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
     * framework as well while still using internationalized messages.
     * 
     */
    
    
    categoryService.saveCategory(category);

    model.addAttribute("success", "Category " + category.getNameCategory() + " registered successfully");
    return "success";
  }


  /*
   * This method will provide the medium to update an existing employee.
   */
  @RequestMapping(value = { "/edit-{idCategory}-category" }, method = RequestMethod.GET)
  public String editCategory(@PathVariable String idCategory, ModelMap model) {
    Category category = categoryService.findCategoryById(idCategory);
    model.addAttribute("category", category);
    model.addAttribute("edit", true);
    return "registration";
  }
  
  /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit-{idCategory}-category" }, method = RequestMethod.POST)
  public String updateCategory(@Valid Category category, BindingResult result,
      ModelMap model, @PathVariable String idCategory) {

    if (result.hasErrors()) {
      return "registration";
    }

    

    categoryService.updateCategory(category);

    model.addAttribute("success", "Category " + category.getNameCategory()  + " updated successfully");
    return "success";
  }

  
  /*
   * This method will delete an brand by it's id value.
   */
  @RequestMapping(value = { "/delete-{idCategory}-category" }, method = RequestMethod.GET)
  public String deleteCategory(@PathVariable String idCategory) {
    categoryService.deleteCategoryById(idCategory);
    return "redirect:/list";
  }
  
  ///COLOUR
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String listColours(ModelMap model) {

    List<Colour> colours = colourService.findAllColours();
    model.addAttribute("colours", colours);
    return "allcolours";
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
  public String newColour(ModelMap model) {
    Colour colour = new Colour();
    model.addAttribute("colour", colour);
    model.addAttribute("edit", false);
    return "registration";
  }

  /*
   * This method will be called on form submission, handling POST request for
   * saving employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
  public String saveColour(@Valid Colour colour, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return "registration";
    }

    /*
     * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
     * and applying it on field [ssn] of Model class [Employee].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
     * framework as well while still using internationalized messages.
     * 
     */
    
    
    colourService.saveColour(colour);

    model.addAttribute("success", "Colour " + colour.getNameColour() + " registered successfully");
    return "success";
  }


  /*
   * This method will provide the medium to update an existing employee.
   */
  @RequestMapping(value = { "/edit-{idColour}-colour" }, method = RequestMethod.GET)
  public String editColour(@PathVariable String idColour, ModelMap model) {
    Colour colour = colourService.findColourById(idColour);
    model.addAttribute("colour", colour);
    model.addAttribute("edit", true);
    return "registration";
  }
  
  /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit-{idColour}-colour" }, method = RequestMethod.POST)
  public String updateColour(@Valid Colour colour, BindingResult result,
      ModelMap model, @PathVariable String idColour) {

    if (result.hasErrors()) {
      return "registration";
    }

    

    colourService.updateColour(colour);

    model.addAttribute("success", "Colour " + colour.getNameColour()  + " updated successfully");
    return "success";
  }

  
  /*
   * This method will delete an brand by it's id value.
   */
  @RequestMapping(value = { "/delete-{idColour}-colour" }, method = RequestMethod.GET)
  public String deleteColour(@PathVariable String idColour) {
    colourService.deleteColourById(idColour);
    return "redirect:/list";
  }
  
///Item
  
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String listItems(ModelMap model) {

    List<Item> items = itemService.findAllItems();
    model.addAttribute("items", items);
    return "allitems";
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
  public String newItem(ModelMap model) {
    Item item = new Item();
    model.addAttribute("item", item);
    model.addAttribute("edit", false);
    return "registration";
  }

  /*
   * This method will be called on form submission, handling POST request for
   * saving employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
  public String saveItem(@Valid Item item, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return "registration";
    }

    /*
     * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
     * and applying it on field [ssn] of Model class [Employee].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
     * framework as well while still using internationalized messages.
     * 
     */
    
    
    itemService.saveItem(item);

    model.addAttribute("success", "Item " + item.getNameItem() + " registered successfully");
    return "success";
  }


  /*
   * This method will provide the medium to update an existing employee.
   */
  @RequestMapping(value = { "/edit-{idItem}-item" }, method = RequestMethod.GET)
  public String editItem(@PathVariable String idItem, ModelMap model) {
    Item item = itemService.findItemById(idItem);
    model.addAttribute("item", item);
    model.addAttribute("edit", true);
    return "registration";
  }
  
  /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit-{idItem}-item" }, method = RequestMethod.POST)
  public String updateItem(@Valid Item item, BindingResult result,
      ModelMap model, @PathVariable String idItem) {

    if (result.hasErrors()) {
      return "registration";
    }

    

    itemService.updateItem(item);

    model.addAttribute("success", "Item " + item.getNameItem()  + " updated successfully");
    return "success";
  }

  
  /*
   * This method will delete an brand by it's id value.
   */
  @RequestMapping(value = { "/delete-{idItem}-item" }, method = RequestMethod.GET)
  public String deleteItem(@PathVariable String idItem) {
    itemService.deleteItemById(idItem);
    return "redirect:/list";
  }
  
///USER
  
  /*
   * This method will list all existing employees.
   */
  @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
  public String listUsers(ModelMap model) {

    List<User> users = userService.findAllUsers();
    model.addAttribute("users", users);
    return "allusers";
  }

  /*
   * This method will provide the medium to add a new employee.
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.GET)
  public String newUser(ModelMap model) {
    User user = new User();
    model.addAttribute("user", user);
    model.addAttribute("edit", false);
    return "registration";
  }

  /*
   * This method will be called on form submission, handling POST request for
   * saving employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/new" }, method = RequestMethod.POST)
  public String saveUser(@Valid User user, BindingResult result,
      ModelMap model) {

    if (result.hasErrors()) {
      return "registration";
    }

    /*
     * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
     * and applying it on field [ssn] of Model class [Employee].
     * 
     * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
     * framework as well while still using internationalized messages.
     * 
     */
    
    
    userService.saveUser(user);

    model.addAttribute("success", "User " + user.getUserName()+" "+user.getUserName()  + " registered successfully");
    return "success";
  }


  /*
   * This method will provide the medium to update an existing employee.
   */
  @RequestMapping(value = { "/edit-{idUser}-user" }, method = RequestMethod.GET)
  public String editUser(@PathVariable String idUser, ModelMap model) {
    User user = userService.findUserById(idUser);
    model.addAttribute("user", user);
    model.addAttribute("edit", true);
    return "registration";
  }
  
  /*
   * This method will be called on form submission, handling POST request for
   * updating employee in database. It also validates the user input
   */
  @RequestMapping(value = { "/edit-{idUser}-user" }, method = RequestMethod.POST)
  public String updateUser(@Valid User user, BindingResult result,
      ModelMap model, @PathVariable String idUser) {

    if (result.hasErrors()) {
      return "registration";
    }

    

    userService.updateUser(user);

    model.addAttribute("success", "User " + user.getUserName() +" "+user.getUserLastName() + " updated successfully");
    return "success";
  }

  
  /*
   * This method will delete an brand by it's id value.
   */
  @RequestMapping(value = { "/delete-{idUser}-user" }, method = RequestMethod.GET)
  public String deleteUser(@PathVariable String idUser) {
    userService.deleteUserById(idUser);
    return "redirect:/list";
  }

}