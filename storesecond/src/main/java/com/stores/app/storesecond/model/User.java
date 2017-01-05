package com.stores.app.storesecond.model;
// Generated 4 janv. 2017 23:30:32 by Hibernate Tools 5.2.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="User")
public class User /*implements java.io.Serializable*/ {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int idUser;
  @Column
  private String userName;
  @Column
  private String userLastName;
  @Column
  private String userEmail;
  @Column
  private String userPassword;
  @Column
  private String userSecurityQuestion1;
  @Column
  private String userSecurityQuestion2;

  public User() {
  }

  public User(int idUser) {
    this.idUser = idUser;
  }

  public User(int idUser, String userName, String userLastName,
      String userEmail, String userPassword, String userSecurityQuestion1,
      String userSecurityQuestion2) {
    this.idUser = idUser;
    this.userName = userName;
    this.userLastName = userLastName;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userSecurityQuestion1 = userSecurityQuestion1;
    this.userSecurityQuestion2 = userSecurityQuestion2;
  }

  public int getIdUser() {
    return this.idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserLastName() {
    return this.userLastName;
  }

  public void setUserLastName(String userLastName) {
    this.userLastName = userLastName;
  }

  public String getUserEmail() {
    return this.userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserPassword() {
    return this.userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public String getUserSecurityQuestion1() {
    return this.userSecurityQuestion1;
  }

  public void setUserSecurityQuestion1(String userSecurityQuestion1) {
    this.userSecurityQuestion1 = userSecurityQuestion1;
  }

  public String getUserSecurityQuestion2() {
    return this.userSecurityQuestion2;
  }

  public void setUserSecurityQuestion2(String userSecurityQuestion2) {
    this.userSecurityQuestion2 = userSecurityQuestion2;
  }

}