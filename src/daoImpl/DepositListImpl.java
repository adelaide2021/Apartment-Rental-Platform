package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.DepositList;
import model.Deposit;
import model.Unit;

/**
 * This class represents a deposit list.
 */
public class DepositListImpl implements DepositList {
  
  private List<Deposit> depositList;
  
  public DepositListImpl() {
    depositList = new ArrayList<>();
  }
  
  @Override
  public void setDepositList(List<Deposit> deposits) {
    this.depositList = deposits;
  }

  @Override
  public int addDeposit(Deposit deposit) {
    if (depositList.contains(deposit)) {
      return 0;
    }
    else {
      depositList.add(deposit);  
      return 1;      
    }
  }

  @Override
  public int deleteDeposit(Deposit deposit) {
    if (depositList.contains(deposit)) {
      depositList.remove(deposit);
      return 1;
    }
    else {
      return 0;
    } 
  }

  @Override
  public List<Deposit> findPaid() {
    List<Deposit> resultList = depositList.stream()
        .filter(deposit -> deposit.isPaidDeposit())
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<Deposit> findUnpaid() {
    List<Deposit> resultList = depositList.stream()
        .filter(deposit -> !deposit.isPaidDeposit())
        .collect(Collectors.toList());
    return resultList;
  }
  
  @Override
  public Deposit findByUnit(Unit unit) {
    for (Deposit deposit : depositList) {
      if (deposit.getUnit().equals(unit)) {
        return deposit;
      }
    }
    return null;
  }
  
  

}
