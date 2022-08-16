package dao;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.List;

import model.*;

public interface UserList {

  /**
   * Add new user to the user list.
   * @param user to be added
   * @return 1 when add successfully 0 when not
   */
  public int addNewUser(User user);
 
  /**
   * Delete user from the user list.
   * @param user to be deleted
   * @return 1 when add successfully 0 when not
   */
  int deleteUser(User user);
  
  /**
   * Get the whole user list.
   * @return the whole user list
   */
  List<User> getUserList();
  
  /**
   * Set the user list by given user list.
   * @param userList
   */
  void setUserList(List<User> userList);
  
  /**
   * Find all users given the first name
   * @param firstName
   * @return all users given the first name
   */
  List<User> findByFirstName(String firstName);
  
  /**
   * Find all users given the last name
   * @param lastName
   * @return all users given the last name
   */
  List<User> findByLastName(String lastName);
  
  /**
   * Find the user given the email
   * @param email
   * @return the user with given given
   */
  User findByEmail(String email);//一个email只能对应一个user
  
  /**
   * Check the password is correct or not
   * @param user
   * @param password
   * @return boolean value indicating the password is correct or not
   */
  boolean checkPassword(User user, String password);//确实密码与用户数据是否相符
  
  /**
   * Find all users given the type
   * @param userType
   * @return all users given the type
   */
  List<User> findAllUserType(UserType userType);
  
  /**
   * Update user first name
   * @param user
   * @param firstName
   */
  void updateFirstName(User user, String firstName);
  
  /**
   * Update user last name
   * @param user
   * @param lastName
   */
  void updateLastName(User user, String lastName);
  
  /**
   * Update user email
   * @param user
   * @param email
   */
  void updateEmail(User user, String email);
  
  /**
   * Update user password
   * @param user
   * @param passWord
   */
  void updatePassword(User user, String passWord);
  
  /**
   * Get the size of the list
   * @return
   */
  int getSize();

}
