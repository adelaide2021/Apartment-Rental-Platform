package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.ResidentList;
import model.Resident;
import model.Unit;
import model.User;
import model.UserType;

/**
 * This class represents a resident list.
 */
public class ResidentListImpl extends UserListImpl implements ResidentList {

  private List<Resident> residentList;
  
  public ResidentListImpl() {
    residentList = new ArrayList<>();
  }  

  @Override
  public List<Resident> getResidentList() {
    return residentList;
  }
  @Override
  public void setResidentList(List<Resident> residentList) {
    this.residentList = residentList;
  }
  
   //只有此处返回了一个resident，因为继承自residentList
  @Override
  public List<Resident> findByUnit(Unit unit) {
    List<Resident> resultList = residentList.stream()
        .filter(resident -> resident.getUnit() == unit)
        .collect(Collectors.toList());
  return resultList;
  }

  @Override
  public int addNewUser(User user) {
    if (user instanceof Resident) {
      Resident resident = (Resident)user;  
      if (!residentList.contains(resident)) {
        residentList.add(resident); 
        return 1;
      }
      else {
        return 0;
      }
    }
    else {         
      return 0;      
    }   
  }
  
  @Override
  public int deleteUser(User user) {
    if (residentList.contains(user)) {
      residentList.remove(user);
      return 1;
    }
    else {
      return 0;
    }  
  }
//继承自userListImpl，继承需要，只能返回user类型的list，不知道是否有隐患？
  @Override
  public List<User> findByFirstName(String firstName) {
    List<User> resultList = residentList.stream()
                                    .filter(user -> user.getFirstName() == firstName)
                                    .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<User> findByLastName(String lastName) {
    List<User> resultList = residentList.stream()
        .filter(user -> user.getLastName() == lastName)
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public User findByEmail(String email) {
    for (User resultUser : residentList) {
      if (resultUser.getEmail() == email) {
        return resultUser;
      }
    }
    return null;
  }
  


/*以下应该是继承自arraylist，一个都没有重写，不知道是否需要？
  @Override
  public int hashCode() {
    // TODO Auto-generated method stub
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    // TODO Auto-generated method stub
    return super.equals(obj);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    // TODO Auto-generated method stub
    return super.clone();
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return super.toString();
  }

  @Override
  protected void finalize() throws Throwable {
    // TODO Auto-generated method stub
    super.finalize();
  }
  */
}
