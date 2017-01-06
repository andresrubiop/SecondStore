package com.stores.app.storesecond.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stores.app.storesecond.dao.UserDao;

import com.stores.app.storesecond.model.User;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
  @Autowired
  private UserDao dao;
  public User findById(int id) {
    return dao.findById(id);
  }

  public void saveUser(User user) {
    dao.saveUser(user);
    
  }

  public void updateUser(User user) {
    User entity = dao.findById(user.getIdUser());
    if(entity!=null){
      entity.setUserName(user.getUserName());
      entity.setUserLastName(user.getUserLastName());
      entity.setUserEmail(user.getUserEmail());
      entity.setUserPassword(user.getUserPassword());
      entity.setUserSecurityQuestion1(user.getUserSecurityQuestion1());
      entity.setUserSecurityQuestion2(user.getUserSecurityQuestion2());
      
    }
      
    
  }

  public void deleteUserById(String idUser) {
    dao.deleteUserById(idUser);
    
  }

  public List<User> findAllUsers() {
    return dao.findAllUsers();
  }

  public User findUserById(String idUser) {
    return dao.findUserById(idUser);
  }

  public boolean isUserIdUnique(Integer id, String idUser) {
    User user = findUserById(idUser);
    return ( user == null || ((id != null) && (user.getIdUser() == id)));
  }

}
