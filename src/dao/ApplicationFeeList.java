package dao;

import java.util.List;

import model.ApplicationFee;
import model.Unit;

public interface ApplicationFeeList {
  
  /**
   * Add ApplicationFee to current applicationFee list.
   * @param applicationFee the applicationFee added 
   * @return 1 when add successfully 0 when not
   */
  int addApplicationFee(ApplicationFee applicationFee);
  
  /**
   * Delete ApplicationFee to current applicationFee list.
   * @param applicationFee the applicationFee deleted
   * @return 1 when delete successfully 0 when not
   */
  int deleteApplicationFee(ApplicationFee applicationFee);
  
  /**
   * Find all units that have paid their application fee.
   * @return all units that haven't pay their application fee
   */
  List<ApplicationFee> findPaid();
  
  /**
   * all units that haven't paid their application fee.
   * @return all units that haven't paid their application fee
   */
  List<ApplicationFee> findUnpaid();
  
  /**
   * Get the application fee status given the unit.
   * @param unit
   * @return boolean value indicates application fee paid or not
   * @throws IllegalArgumentException
   */
  boolean findUnitStatus(Unit unit) throws IllegalArgumentException;
  
  /**
   * Get the application fee amount given the unit.
   * @param unit
   * @return the amount of application fee of this unit
   */
  double findUnitAmount(Unit unit);
  
  /**
   * Set the application fee status given the boolean value
   * @param applicationFee
   * @param status
   */
  void setFeeStatus(ApplicationFee applicationFee, boolean status);

  /**
   * Find ApplicationFee of the given unit
   * @param unit
   * @return ApplicationFee of the given unit
   */
  ApplicationFee getApplFeeByUnit(Unit unit);
}
