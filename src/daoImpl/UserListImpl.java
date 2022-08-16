package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.NestingKind;

import dao.UserList;
import model.User;
import model.UserType;

/**
 * This class represents a user list.
 */
public class UserListImpl implements UserList {
  
  public List<User> userList;//不能加static
  
  public UserListImpl() {
    userList = new ArrayList<>();
  }
  
  public UserListImpl(List<User> userList) {
    userList = new ArrayList<>();
    this.userList = userList;
  }

  @Override
  public List<User> getUserList() {
    return userList;
  }

  @Override
  public void setUserList(List<User> userList) {
    this.userList = userList;
  }
   
    
  @Override
  public int addNewUser(User user) {
    if (userList.contains(user)) {
      return 0;
    }
    else {
      userList.add(user);  
      return 1;      
    }
  }
  
  @Override
  public int deleteUser(User user) {
    if (userList.contains(user)) {
      userList.remove(user);
      return 1;
    }
    else {
      return 0;
    }    
  }

  @Override
  public List<User> findByFirstName(String firstName) {
    List<User> resultList = userList.stream()
                                    .filter(user -> user.getFirstName().equals(firstName))
                                    .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<User> findByLastName(String lastName) {
    List<User> resultList = userList.stream()
        .filter(user -> user.getLastName().equals(lastName))
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public User findByEmail(String email) {
    //System.out.println(email+"from user list impl 68");
    if (userList == null || userList.isEmpty()) {
      //System.out.println(email+"from user list impl 70");
      return null;
    }
    //System.out.println(email + "form ser list impl 81");
    for (User resultUser : userList) {
      //System.out.println(resultUser.getEmail() + "form user list impl 82");
      if (resultUser.getEmail().equals(email)) {
        //System.out.println(resultUser.toString() + "from user list impl 85");//已验证可成功返回值
        return resultUser;
      }
    }
    //System.out.println(email+"from user list impl 77");
    return null;
  }

  @Override
  public boolean checkPassword(User user, String passWord) {
    if (user.getPassword().equals(passWord)) {
      return true;
    }
    else {
      return false;
    }   
  }

  @Override
  public List<User> findAllUserType(UserType userType) {
    List<User> resultList = userList.stream()
        .filter(user -> user.getUserType().equals(userType))
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public void updateFirstName(User user, String firstName) {
    user.setFirstName(firstName);  
  }

  @Override
  public void updateLastName(User user, String lastName) {
    user.setLastName(lastName);  
  }

  @Override
  public void updateEmail(User user, String email) {
    user.setEmail(email); 
    
  }

  @Override
  public void updatePassword(User user, String passWord) {
    user.setPassword(passWord);
    
  }
  
  @Override
  public int getSize() {
    return this.getSize();
  }
  

}
