package serviceImpl;

import java.util.List;

import dao.BillList;
import dao.MaintenanceList;
import dao.ResidentList;
import dao.UnitList;
import dao.UtilityList;
import daoImpl.BillListImpl;
import daoImpl.MaintenanceListImpl;
import daoImpl.ResidentListImpl;
import daoImpl.UnitListImpl;
import daoImpl.UtilityListImpl;
import model.Bill;
import model.Maintenance;
import model.Resident;
import model.Unit;
import model.Utility;
import service.ResidentService;

/**
 * This class represents all the operations that a resident can do.
 */
public class ResidentServiceImpl implements ResidentService {
  
  private ResidentList residentList;
  private UnitList unitList;
  private MaintenanceList maintenanceList;
  private UtilityList utilityList;
  private BillList billList;
  
  //这里构造函数传参和其他service不同，要重新考虑这里的问题
  public ResidentServiceImpl(List<Resident> residentList, List<Unit> unitList, 
      List<Maintenance> maintenanceList, List<Utility> utilityList, List<Bill> billList) {
    /*
    this.residentList = residentList;
    this.unitList = unitList;
    this.maintenanceList = maintenanceList;
    this.utilityList = utilityList;
    this.billList = billList;
    */
    this.residentList = new ResidentListImpl();
    this.residentList.setResidentList(residentList);
    this.unitList = new UnitListImpl();
    this.unitList.setUnitList(unitList);
    this.maintenanceList = new MaintenanceListImpl();
    this.maintenanceList.setMaintenance(maintenanceList);
    this.utilityList = new UtilityListImpl();
    this.utilityList.setUtilityList(utilityList);
    this.billList = new BillListImpl();
    this.billList.setBilList(billList);
    
  }
  
  @Override
  public double getCurrBalance(Resident resident) {
    Unit theUnit = resident.getUnit();
    return billList.getBalanceByUnit(theUnit); 
  }
  
  @Override
  public void payCurrBalance(Resident resident, double amount) {
    Unit theUnit = resident.getUnit();    
    Bill bill = billList.getBillByUnit(theUnit);    
    bill.setBalance(amount);
  }
  
  

}
