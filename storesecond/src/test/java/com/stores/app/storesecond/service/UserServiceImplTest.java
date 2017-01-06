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

import com.stores.app.storesecond.dao.UserDao;
import com.stores.app.storesecond.model.User;

/**
 * @author andre
 *
 */
public class UserServiceImplTest {
  @Mock
  UserDao dao;
  @InjectMocks
  UserServiceImpl userService;
  
  @Spy
  List<User> users = new ArrayList<User>();
  
  @BeforeClass
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    users = getUserList();
  }
  

  @Test
  public void findById(){
    User use = users.get(0);
    when(dao.findById(anyInt())).thenReturn(use);
    Assert.assertEquals(userService.findById(use.getIdUser()),use);
  }

  @Test
  public void saveColour(){
    doNothing().when(dao).saveUser(any(User.class));
    userService.saveUser(any(User.class));
    verify(dao, atLeastOnce()).saveUser(any(User.class));
  }
  
  @Test
  public void updateUser(){
    User use = users.get(0);
    when(dao.findById(anyInt())).thenReturn(use);
    userService.updateUser(use);
    verify(dao, atLeastOnce()).findById(anyInt());
  }

  @Test
  public void deleteUserById(){
    doNothing().when(dao).deleteUserById(anyString());
    userService.deleteUserById(anyString());
    verify(dao, atLeastOnce()).deleteUserById(anyString());
  }
  
  @Test
  public void findAllUsers(){
    when(dao.findAllUsers()).thenReturn(users);
    Assert.assertEquals(userService.findAllUsers(), users);
  }
  
  @Test
  public void findUserById(){
    User use = users.get(0);
    when(dao.findUserById(anyString())).thenReturn(use);
    Assert.assertEquals(userService.findUserById(anyString()), use);
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
}
