package model;

/**
 * This class represents a bill of this unit
 */
public class Bill {

  private Unit unit;
  private double balance;
  
  public Bill() {}
  
  /**
   * Construct and initialize the Bill by given unit,
   * maintenance and utility.
   * @param unit the unit of this bill
   * @param maintenance the maintenance of this bill
   * @param utility the utility of this bill
   */
  public Bill(Unit unit, double balance) {
    this.unit = unit;
    this.balance = balance;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public double getBalance() {
    return balance;
  }

  /**
   * Change the balance of bill based on the original balance
   * @param balance
   */
  public void setBalance(double balance) {
    this.balance = this.balance + balance;
  }


  
  
  
  
}
