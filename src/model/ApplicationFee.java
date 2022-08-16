package model;

/**
 * This class represents application fee.
 * An application fee of 50 should be paid per application.
 */
public class ApplicationFee {
  
  public ApplicationFee(Unit unit, boolean paidApplFee) {
    this.unit = unit;
    this.paidApplFee = paidApplFee;
  }
  
  private Unit unit;
  private boolean paidApplFee;
  private final double applFee = 50.00;
  
  /**
   * Get the unit of this application fee pay for.
   * @return unit the unit of this application fee pay for
   */
  public Unit getUnit() {
    return unit;
  }
  
  /**
   * Set the unit of this application fee pay for.
   */
  public void setUnit(Unit unit) {
    this.unit = unit;
  }
  
  /**
   * Get the application fee status of this unit.
   * @return the application fee status of this unit
   */
  public boolean isPaidApplFee() {
    return paidApplFee;
  }
  
  /**
   * Set the application fee status of this unit.
   */
  public void setPaidApplFee(boolean paidApplFee) {
    this.paidApplFee = paidApplFee;
  }
  
  /**
   * Get the application fee amount of this unit.
   * @return applFee the amount of application fee
   */
  public double getApplFee() {
    return applFee;
  }
  
  

  
} 
