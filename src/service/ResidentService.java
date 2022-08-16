package service;

import model.Resident;

public interface ResidentService {
  
  /**
   * Get the current balance of this resident
   * @param resident
   * @return the current balance of this resident
   */
  double getCurrBalance(Resident resident);

  /**
   * Pay the balance of this resident
   * @param resident
   * @param amount
   * @return
   */
  void payCurrBalance(Resident resident, double amount);
}
