package dao;

import java.util.List;


import model.ApplicationFee;

import model.Deposit;
import model.Unit;

public interface DepositList {
  
  /**
   * Add Deposit to the Deposit list
   * @param deposit deposit need to be added
   * @return 1 when add successfully 0 when not
   */
  int addDeposit(Deposit deposit);
  
  /**
   * Delete Deposit from the Deposit list
   * @param deposit to be deleted
   * @return 1 when add successfully 0 when not
   */
  int deleteDeposit(Deposit deposit);
  
  /**
   * Find all units that have paid their deposit.
   * @return all units that have paid their deposit
   */
  List<Deposit> findPaid();
  
  /**
   * Find all units that have not paid their application fee.
   * @return all units that have not paid their application fee.
   */
  List<Deposit> findUnpaid();
  
  /**
   * Find Deposit by unit
   * @param unit
   * @return the Deposit of the given unit
   */
  Deposit findByUnit(Unit unit); 
  
  /**
   * Set deposit list
   * @param deposits
   */
  void setDepositList(List<Deposit> deposits);

}
