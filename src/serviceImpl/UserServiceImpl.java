package serviceImpl;

import java.time.LocalDate;
import java.util.List;

import dao.UnitList;
import dao.UserList;
import daoImpl.UserListImpl;
import model.Amenity;
import model.Applicant;
import model.Unit;
import model.UnitType;
import model.User;
import service.UserService;
import tool.Format;

/**
 * This class represents all the operations that a user can do.
 */
public class UserServiceImpl implements UserService {
  
  private UserList userServiceList;
  private UnitList unitServiceList;
  
  //在初次调用的时候必须生成一个数组
  public UserServiceImpl() {
    userServiceList = new UserListImpl();
  }  
  
  public UserServiceImpl(List<User> userList) {
    userServiceList = new UserListImpl();
    userServiceList.setUserList(userList);
  }
  
  public UserList getUserList() {
    return userServiceList;
  }
  
  @Override
  public void addUser(User user) {
    userServiceList.addNewUser(user);
  }
  
  @Override
  public User login(String email, String password) {
    User resultUser = null;
    if (Format.isEmpty(email) || Format.isEmpty(password)) {
      return null;
    }
    resultUser = userServiceList.findByEmail(email);
    //System.out.println(resultUser + "form user service 41\n");
    //System.out.println(userList.getUserList() + "form user service 42\n");
    if (resultUser == null) {
      return null;
    }
    else {
      if (resultUser.getPassword().equals(password)) {
        return resultUser;
      }
      else {
        //System.out.println(password + "form user service 52\n");
        //System.out.println(resultUser.getPassword() + "form user service 52\n");
        return null;
      }
    }
  }
  
  @Override
  public String register(String email, String firstName, String lastName, String password) {
    //System.out.println(email+"from user service impl 39");
    String string;
    if (userServiceList.findByEmail(email) != null) {
      //System.out.println(email+"from user service impl 40");
      string = "Duplicate registration";
      return string;
    }
    else if (Format.nameFormat(firstName) == false
        || Format.nameFormat(lastName) == false) {
        return "Invalid name";
        }
    else if (Format.passwordFormat(password) == false) {
        return "Invalid password";
    }
    else {
      User newUser = new User(email, firstName, lastName, password);
      userServiceList.addNewUser(newUser);
      //System.out.println(userList.getUserList() + "form user service impl 61");
    }
    return "Success";
  }
  
  @Override
  public List<Unit> findApartment(UnitType unitType, Amenity amenity, double rent, LocalDate availableDate) {
  
    System.out.println(unitType + amenity.toString() + rent + "user service 94");
    System.out.println(unitServiceList.getUnitList() + "user service 95");
    List<Unit> list = unitServiceList.findApartmentList(unitType, amenity, rent, availableDate);
    System.out.println(list.toString() + "user service 95");
    return list;
  }

}
