package dao;

import java.util.List;

import model.Bill;
import model.Unit;

public interface BillList {
  
  /**
   * Set the balance of the bill of the given unit
   * @param theUnit
   */
  void setBalanceByUnit(Unit theUnit);
  
  /**
   * Get the balance of the bill of the given unit
   * @param theUnit
   * @return the balance of the bill of the given unit
   */
  double getBalanceByUnit(Unit theUnit);
  
  /**
   * Get the Bill of the given unit
   * @param unit
   * @return the Bill of the given unit
   */
  Bill getBillByUnit(Unit unit);
  
  /**
   * Set the bill list.
   * @param bills
   */
  void setBilList(List<Bill> bills);

}
