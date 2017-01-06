package com.stores.app.storesecond.service;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.stores.app.storesecond.dao.BrandDao;
import com.stores.app.storesecond.model.Brand;



public class BrandServiceImplTest {
  @Mock
  BrandDao dao;
  @InjectMocks
  BrandServiceImpl brandService;
  
  @Spy
  List<Brand> brands = new ArrayList<Brand>();
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    brands = getBrandList();
  }

  @Test
  public void findById(){
    Brand bra = brands.get(0);
    when(dao.findById(anyInt())).thenReturn(bra);
    Assert.assertEquals(brandService.findById(bra.getIdBrand()),bra);
  }

  @Test
  public void saveBrand(){
    doNothing().when(dao).saveBrand(any(Brand.class));
    brandService.saveBrand(any(Brand.class));
    verify(dao, atLeastOnce()).saveBrand(any(Brand.class));
  }
  
  @Test
  public void updateBrand(){
    Brand bra = brands.get(0);
    when(dao.findById(anyInt())).thenReturn(bra);
    brandService.updateBrand(bra);
    verify(dao, atLeastOnce()).findById(anyInt());
  }

  @Test
  public void deleteBrandById(){
    doNothing().when(dao).deleteBrandById(anyString());
    brandService.deleteBrandById(anyString());
    verify(dao, atLeastOnce()).deleteBrandById(anyString());
  }
  
  @Test
  public void findAllBrands(){
    when(dao.findAllBrands()).thenReturn(brands);
    Assert.assertEquals(brandService.findAllBrands(), brands);
  }
  
  @Test
  public void findBrandById(){
    Brand bra = brands.get(0);
    when(dao.findBrandById(anyString())).thenReturn(bra);
    Assert.assertEquals(brandService.findBrandById(anyString()), bra);
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
