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

import com.stores.app.storesecond.dao.ItemDao;
import com.stores.app.storesecond.model.Brand;
import com.stores.app.storesecond.model.Category;
import com.stores.app.storesecond.model.Colour;
import com.stores.app.storesecond.model.Item;

/**
 * @author andre
 *
 */
public class ItemServiceImplTest {
  @Mock
  ItemDao dao;
  @InjectMocks
  ItemServiceImpl itemService;
  
  @Spy
  List<Item> items = new ArrayList<Item>();
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    items = getItemList();
  }
  

  @Test
  public void findById(){
    Item ite = items.get(0);
    when(dao.findById(anyInt())).thenReturn(ite);
    Assert.assertEquals(itemService.findById(ite.getIdItem()),ite);
  }

  @Test
  public void saveItem(){
    doNothing().when(dao).saveItem(any(Item.class));
    itemService.saveItem(any(Item.class));
    verify(dao, atLeastOnce()).saveItem(any(Item.class));
  }
  
  @Test
  public void updateItem(){
    Item ite = items.get(0);
    when(dao.findById(anyInt())).thenReturn(ite);
    itemService.updateItem(ite);
    verify(dao, atLeastOnce()).findById(anyInt());
  }

  @Test
  public void deleteColourById(){
    doNothing().when(dao).deleteItemById(anyString());
    itemService.deleteItemById(anyString());
    verify(dao, atLeastOnce()).deleteItemById(anyString());
  }
  
  @Test
  public void findAllItems(){
    when(dao.findAllItems()).thenReturn(items);
    Assert.assertEquals(itemService.findAllItems(), items);
  }
  
  @Test
  public void findItemById(){
    Item ite = items.get(0);
    when(dao.findItemById(anyString())).thenReturn(ite);
    Assert.assertEquals(itemService.findItemById(anyString()), ite);
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
}


