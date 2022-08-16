package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.MaintenanceList;
import model.ApplicationFee;
import model.Maintenance;
import model.Unit;

/**
 * This class represents a maintenance list.
 */
public class MaintenanceListImpl implements MaintenanceList {
  
  private List<Maintenance> maintenanceList;
  
  public MaintenanceListImpl() {
    maintenanceList = new ArrayList<>();
  }
  
  @Override
  public void setMaintenance(List<Maintenance> maintenances) {
    this.maintenanceList = maintenances;
  }

  @Override
  public int addMaintenance(Maintenance maintenance) {
    if (maintenanceList.contains(maintenance)) {
      return 0;
    }
    else {
      maintenanceList.add(maintenance);  
      return 1;      
    }
  }

  @Override
  public int deleteMaintenance(Maintenance maintenance) {
    if (maintenanceList.contains(maintenance)) {
      maintenanceList.remove(maintenance);
      return 1;
    }
    else {
      return 0;
    } 
  }

  @Override
  public Maintenance getMaintenance(Unit unit) {
    Optional<Maintenance> result = maintenanceList.stream()
                              .filter(m -> m.getUnit() == unit)
                         .findFirst();
    return result.get();
  }
  
  


}
