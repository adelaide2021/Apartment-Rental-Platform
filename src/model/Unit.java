package model;

import java.time.LocalDate;

/**
 * This class represents an Unit of the apartment building.
 * An unit has an unitID, a type, amenities, rent and available date.
 */
public class Unit {
  protected String unitID;
  protected UnitType unitType;
  protected Amenity amenities;
  protected double rent;
  protected LocalDate availableDate;
  
  /**
   * Construct an unit and initialize it with the given unit id, unit type, amenity
   * and rent. Initialize the available date with current date.
   * @param unitID the unit id of this unit
   * @param unitType the type of this unit
   * @param amenities the amenity of this unit
   * @param rent the rent of this unit
   */
  public Unit(String unitID, UnitType unitType, Amenity amenities, double rent) {
    this.unitID = unitID;
    this.unitType = unitType;
    this.amenities = amenities;
    this.rent = rent;
    this.availableDate = LocalDate.now();
  }
 
  public String getUnitID() {
    return unitID;
  }
  public void setUnitID(String unitID) {
    this.unitID = unitID;
  }
  public UnitType getUnitType() {
    return unitType;
  }
  public void setUnitType(UnitType unitType) {
    this.unitType = unitType;
  }
  public Amenity getAmenities() {
    return amenities;
  }
  public void setAmenities(Amenity amenities) {
    this.amenities = amenities;
  }
  public double getRent() {
    return rent;
  }
  public void setRent(double rent) {
    this.rent = rent;
  }
  public LocalDate getAvailableDate() {
    return this.availableDate;
  }
  public void setAvailable(int plusMonth) {
    this.availableDate.plusMonths(plusMonth);
  }
    
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !(o instanceof Unit)) {
      return false;
    }
    Unit other = (Unit) o;
    return this.unitID.equals(other.unitID);
  }
  
  @Override
  public String toString() {
    return "unit ID: " + unitID + "\n" +
    "unit type: " + unitType + "\n" +
    "amenities: " + amenities + "\n" +
    "rent: " + rent + "\n" +
    "available date: " + availableDate;
  }
  

  
  
  


}
