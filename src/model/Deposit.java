package model;

/**
 * This class represents the deposit of one unit.
 */
public class Deposit {

  /**
   * Constructs the deposit of one unit.
   * 
   * @param unit        the unit of this deposit pay for
   * @param paidDeposit the boolean value indicates the deposit fee paid or not
   * @param deposit     the amount of deposit
   */
  public Deposit(Unit unit, boolean paidDeposit) {
    this.unit = unit;
    this.paidDeposit = paidDeposit;
    this.deposit = unit.getRent();
  }

  private Unit unit;
  private boolean paidDeposit;
  private double deposit;

  /**
   * Get the unit of the deposit pay for
   * 
   * @return the unit of the deposit pay for
   */
  public Unit getUnit() {
    return unit;
  }

  /**
   * Set the unit of the deposit pay for
   */
  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  /**
   * Get the boolean value indicating the deposit fee paid or not
   * 
   * @return the boolean value indicating the deposit fee paid or not
   */
  public boolean isPaidDeposit() {
    return paidDeposit;
  }

  /**
   * Set the boolean value to indicate the deposit fee paid or not
   */
  public void setPaidDeposit(boolean paidDeposit) {
    this.paidDeposit = paidDeposit;
  }

  /**
   * Get the deposit amount of a unit
   * 
   * @return the deposit amount
   */
  public double getDeposit() {
    return deposit;
  }

  /**
   * Set the deposit amount of a unit
   */
  public void setDeposit(double deposit) {
    this.deposit = deposit;
  }

}
