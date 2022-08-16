package model;

/**
 * This class represents a resident. A resident is also a user. A resident lives
 * in a unit of the apartment building.
 */
public class Resident extends User {

  private Unit unit;

  /**
   * Construct a resident and initialize it using the given user and unit
   * information
   * 
   * @param user the user information of this resident
   * @param unit the unit in which this resident lives
   */
  public Resident(User user, Unit unit) {
    super(user);
    this.setUserType(UserType.resident);
    this.unit = unit;
  }

  /**
   * Get the unit in which this resident lives.
   * @return unit in which this resident lives
   */
  public Unit getUnit() {
    return unit;
  }

  /**
   * Set the unit in which this resident lives.
   */
  public void setUnit(Unit unit) {
    this.unit = unit;
  }

}
