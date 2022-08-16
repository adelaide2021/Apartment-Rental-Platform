package dao;

import java.util.List;

import model.Resident;
import model.Unit;

public interface ResidentList extends UserList{
  
  /**
   * Find all residents live in the given unit
   * @param unit 
   * @return all residents live in the given unit
   */
  List<Resident> findByUnit(Unit unit);
  
  List<Resident> getResidentList();
  
  void setResidentList(List<Resident> residentList);

}
