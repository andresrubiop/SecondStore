package com.stores.app.storesecond.service;

import java.util.List;


import com.stores.app.storesecond.model.User;

public interface UserService {
  User findById(int id);
  
  void saveUser(User user);
  
  void updateUser(User user);
  
  void deleteUserById(String idUser);

  List<User> findAllUsers(); 
  
  User findUserById(String idUser);

  

}
