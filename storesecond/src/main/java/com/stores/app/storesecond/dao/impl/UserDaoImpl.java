package com.stores.app.storesecond.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.stores.app.storesecond.dao.AbstractDao;
import com.stores.app.storesecond.dao.UserDao;

import com.stores.app.storesecond.model.User;

public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{

  public User findById(int id) {
    return getByKey(id);
  }

  public void saveUser(User user) {
    persist(user);
    
  }

  public void deleteUserById(String idUser) {
    Query query = getSession().createSQLQuery("delete from User where idUser = :idUser");
    query.setString("idUser", idUser);
    query.executeUpdate();
  }

  @SuppressWarnings("unchecked")
  public List<User> findAllUsers() {
    Criteria criteria = createEntityCriteria();
    return (List<User>) criteria.list();
  }

  public User findUserById(String idUser) {
    Criteria criteria = createEntityCriteria();
    criteria.add(Restrictions.eq("idUser", idUser));
    return (User) criteria.uniqueResult();
  }

}
