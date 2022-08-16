package dao;

import java.time.LocalDate;
import java.util.List;

import model.UnitType;
import model.Amenity;
import model.Unit;

public interface UnitList {
  
  List<Unit> getUnitList();
  
  void setUnitList(List<Unit> unitList);
  
  int addUnit(Unit unit);
  
  int deleteUnit(Unit unit);
  
  Unit findByUnitID(String unitID);
  
  List<Unit> findByUnittype(UnitType unitType);
  
  List<Unit> findByAmenity(Amenity amenity);
  //如果想查具体amenity有多少间unit也要从unit中找而不是amenity。
  
  List<Unit> findBellowRent(double rent);
  
  List<Unit> findByAvailableDate(LocalDate date);
  
  List<Unit> findApartmentList(UnitType unitType, Amenity amenity, double rent, LocalDate date);
   
  

}
