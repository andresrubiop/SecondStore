package com.stores.app.storesecond.dao;



import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stores.app.storesecond.model.Brand;





public class BrandDaoImplTest extends EntityDaoImplTest {
  @Autowired
  BrandDao brandDao;

  @Override
  protected IDataSet getDataSet() throws Exception {
    IDataSet dataSet = new FlatXmlDataSet(this.getClass().getClassLoader().getResourceAsStream("Brand.xml"));
    return dataSet;
  }
  @Test
  public void findById(){
    Assert.assertNotNull(brandDao.findById(1));
    Assert.assertNull(brandDao.findById(3));
  }

  
  @Test
  public void saveBrand(){
    brandDao.saveBrand(getSampleBrand());
    Assert.assertEquals(brandDao.findAllBrands().size(), 3);
  }
  
  @Test
  public void deleteBrandById(){
    brandDao.deleteBrandById("200");
    Assert.assertEquals(brandDao.findAllBrands().size(), 1);
  }
  
  @Test
  public void deleteBrandByInvalidId(){
    brandDao.deleteBrandById("23423");
    Assert.assertEquals(brandDao.findAllBrands().size(), 2);
  }

  @Test
  public void findAllBrands(){
    Assert.assertEquals(brandDao.findAllBrands().size(), 2);
  }
  
  @Test
  public void findBrandById(){
    Assert.assertNotNull(brandDao.findBrandById("11111"));
    Assert.assertNull(brandDao.findBrandById("14545"));
  }

  public Brand getSampleBrand(){
    Brand brand = new Brand();
    brand.setNameBrand("BrandTest");
    
    return brand;
  }

}
