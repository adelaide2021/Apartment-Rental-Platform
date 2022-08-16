package service;

import java.time.LocalDate;
import java.util.List;

import dao.UserList;
import model.Amenity;
import model.Unit;
import model.UnitType;
import model.User;

public interface UserService {
  
  /**
   * 
   */
  UserList getUserList();
  
  /**
   * Log in to the account given email and password
   * @param email
   * @param password
   * @return the user of this email
   */
  User login(String email, String password);
  
  /**
   * Search for an apartment given type, amenity, rent and available date
   * @param unitType
   * @param amenity
   * @param rent
   * @param availableDate
   * @return a list of unit that meets the requirement
   */
  List<Unit> findApartment(UnitType unitType, Amenity amenity, double rent, LocalDate availableDate);
  
  /**
   * Register a new account given email, first/last name and password
   * @param email 
   * @param firstName
   * @param lastName
   * @param password
   * @return a string which indicates success or not
   */
  String register(String email, String firstName, String lastName, String password);
  
  /**
   * Add new user to the list.
   * @param user
   */
  void addUser(User user);

}
