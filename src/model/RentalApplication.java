package model;

/**
 * This class represents an rental application.
 * An application has an applicant and a unit.
 * If more than one person applies for the same apartment together, 
 * only the information of the main applicant is required.
 */
public class RentalApplication {
  
  private Applicant applicant;
  private Unit unit;
  
  /**
   * Constructs a rental application and initialize it 
   * with the given applicant and unit.
   * @param applicant the applicant of this rental application
   * @param unit the unit applied for of this rental application
   */
  public RentalApplication(Applicant applicant, Unit unit) {
    this.applicant = applicant;
    this.unit = unit;
  }
  /**
   * Get the applicant of this application
   * @return the applicant of this application
   */
  public Applicant getApplicant() {
    return applicant;
  }
  /**
   * Set the applicant of this application
   */
  public void setApplicant(Applicant applicant) {
    this.applicant = applicant;
  }
  /**
   * Get the unit of this application
   * @return the unit of this application
   */
  public Unit getUnit() {
    return unit;
  }
  /**
   * Set the unit of this application
   */
  public void setUnit(Unit unit) {
    this.unit = unit;
  }
  
  

}
