package dao;

import model.Utility;

import java.util.List;

import model.Unit;

public interface UtilityList {
  
  /**
   * Add new utility to the utility list.
   * @param Utility
   * @return 1 when add successfully 0 when not
   */
  int addUtility(Utility Utility);
  
  /**
   * Delete utility from the utility list.
   * @param utility
   * @return 1 when add successfully 0 when not
   */
  int deleteUtility(Utility utility);
  
  /**
   * Get utility of the given unit
   * @param unit
   * @return the utility of the given unit
   */
  Utility getUtility(Unit unit);
  
  /**
   * Set utility list
   * @param utilities
   */
  void setUtilityList(List<Utility> utilities) ;

}
