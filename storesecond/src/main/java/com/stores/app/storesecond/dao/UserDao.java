package com.stores.app.storesecond.dao;

import java.util.List;

import com.stores.app.storesecond.model.User;

public interface UserDao {
  User findById(int id);

  void saveUser(User user);
  
  void deleteUserById(String idUser);
  
  List<User> findAllUsers();

  User findUserById(String idUser);

}
