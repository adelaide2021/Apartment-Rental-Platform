package daoImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.UnitList;
import model.Amenity;
import model.Unit;
import model.UnitType;
import model.User;

/**
 * This class represents a unit list.
 */
public class UnitListImpl implements UnitList {
  
  private List<Unit> unitList;
  
  public UnitListImpl() {
    unitList = new ArrayList<>();
  }
  
  public UnitListImpl(List<Unit> myUnitList) {
    unitList = myUnitList;
  }
  
  @Override
  public List<Unit> getUnitList() {
    return this.unitList;
  }
  
  @Override
  public void setUnitList(List<Unit> unitList) {
    this.unitList = unitList;
  }
  
  @Override
  public int addUnit(Unit unit) {
    if (unitList.contains(unit)) {
      return 0;
    }
    else {
      unitList.add(unit);  
      return 1;      
    }
  }

  @Override
  public int deleteUnit(Unit unit) {
    if (unitList.contains(unit)) {
      unitList.remove(unit);
      return 1;
    }
    else {
      return 0;
    }  
  }
  
  @Override
  public Unit findByUnitID(String unitID) {
    if (unitList == null || unitList.isEmpty()) {
      return null;
    }
    for (Unit resultUnit : unitList) {
      if (resultUnit.getUnitID().equals(unitID)) {
        return resultUnit;
      }
    }
    return null;
  }

  @Override
  public List<Unit> findByUnittype(UnitType unitType) {
    List<Unit> resultList = unitList.stream()
        .filter(unit -> unit.getUnitType().equals(unitType))
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<Unit> findByAmenity(Amenity amenity) {
    List<Unit> resultList = unitList.stream()
        .filter(unit -> unit.getAmenities().equals(amenity))
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<Unit> findBellowRent(double rent) {
    List<Unit> resultList = unitList.stream()
        .filter(unit -> unit.getRent() <= rent)
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<Unit> findByAvailableDate(LocalDate date) {
    List<Unit> resultList = unitList.stream()
        .filter(unit -> unit.getAvailableDate().isBefore(date))
        .collect(Collectors.toList());
    return resultList;
  }
  
  @Override
  public List<Unit> findApartmentList(UnitType unitType, Amenity amenity, double rent, LocalDate date) {
    System.out.println(unitType + amenity.toString() + rent + "unit list 108");
    List<Unit> resultList = unitList.stream()
        .filter(unit -> unit.getUnitType().equals(unitType) &&
                     unit.getAmenities().equals(amenity) &&
                     unit.getAmenities().equals(amenity) &&
                     unit.getAvailableDate().isBefore(date))
        .collect(Collectors.toList());
    System.out.println(resultList.toString() + "unit list 114");
    return resultList;
  }



  
  

}
