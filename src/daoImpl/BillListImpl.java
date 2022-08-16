package daoImpl;

import java.util.ArrayList;
import java.util.List;

import dao.BillList;
import dao.MaintenanceList;
import dao.UtilityList;
import model.Maintenance;
import model.Resident;
import model.Unit;
import model.Utility;
import model.Bill;

public class BillListImpl implements BillList {
  
  private List<Bill> billList;
  private MaintenanceList maintenanceList;
  private UtilityList utilityList;
  
  public BillListImpl() {
    billList = new ArrayList<>();
  }
  
  @Override
  public void setBilList(List<Bill> bills) {
    this.billList = bills;
  }
  
  @Override
  public void setBalanceByUnit(Unit theUnit) {  
    double rent = theUnit.getRent();
    Bill resultBill = new Bill();
    for (Bill bill : billList) {
      if (bill.getUnit().equals(theUnit)) {
        resultBill = bill;
      }
    }
    
    Maintenance maintenence = maintenanceList.getMaintenance(theUnit);
    double mainFee = maintenence.getMaintenenceFee();
    
    Utility utility = utilityList.getUtility(theUnit);
    double utiFee = utility.getUtilityfee();
    double currBalance = rent + mainFee + utiFee;
  
    resultBill.setBalance(currBalance);
    
  }
  
  @Override
  public double getBalanceByUnit(Unit theUnit) {
    for (Bill bill : billList) {
      if (bill.getUnit().equals(theUnit)) {
        Bill resultBill = bill;
        return resultBill.getBalance();  
      }
    }
    return -9999;     
  }
  
  @Override
  public Bill getBillByUnit(Unit unit) {
    for (Bill bill : billList) {
      if (bill.getUnit().equals(unit)) {
        return bill;
      }
    }
    return null;
  }
  
 
}
  
  


