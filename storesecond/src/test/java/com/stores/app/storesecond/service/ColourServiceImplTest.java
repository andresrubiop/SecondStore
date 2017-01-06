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

import com.stores.app.storesecond.dao.ColourDao;
import com.stores.app.storesecond.model.Colour;

/**
 * @author andre
 *
 */
public class ColourServiceImplTest {
  @Mock
  ColourDao dao;
  @InjectMocks
  ColourServiceImpl colourService;
  
  @Spy
  List<Colour> colours = new ArrayList<Colour>();
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    colours = getColourList();
  }
  

  @Test
  public void findById(){
    Colour col = colours.get(0);
    when(dao.findById(anyInt())).thenReturn(col);
    Assert.assertEquals(colourService.findById(col.getIdColour()),col);
  }

  @Test
  public void saveColour(){
    doNothing().when(dao).saveColour(any(Colour.class));
    colourService.saveColour(any(Colour.class));
    verify(dao, atLeastOnce()).saveColour(any(Colour.class));
  }
  
  @Test
  public void updateColour(){
    Colour col = colours.get(0);
    when(dao.findById(anyInt())).thenReturn(col);
    colourService.updateColour(col);
    verify(dao, atLeastOnce()).findById(anyInt());
  }

  @Test
  public void deleteColourById(){
    doNothing().when(dao).deleteColourById(anyString());
    colourService.deleteColourById(anyString());
    verify(dao, atLeastOnce()).deleteColourById(anyString());
  }
  
  @Test
  public void findAllColours(){
    when(dao.findAllColours()).thenReturn(colours);
    Assert.assertEquals(colourService.findAllColours(), colours);
  }
  
  @Test
  public void findColourById(){
    Colour col = colours.get(0);
    when(dao.findColourById(anyString())).thenReturn(col);
    Assert.assertEquals(colourService.findColourById(anyString()), col);
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
}
