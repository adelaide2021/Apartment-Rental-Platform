package dao;

import java.util.List;

import model.Maintenance;
import model.Unit;

public interface MaintenanceList {
  
  /**
   * Add Maintenance to the maintenance list
   * @param maintenance to be added
   * @return 1 when add successfully 0 when not
   */
  int addMaintenance(Maintenance maintenance);
  
  /**
   * Delete Maintenance from the maintenance list
   * @param maintenance to be deleted
   * @return 1 when delete successfully 0 when not
   */
  int deleteMaintenance(Maintenance maintenance);
  
  /**
   * Get the maintenance of the given unit
   * @param unit 
   * @return the maintenance of the given unit
   */
  Maintenance getMaintenance(Unit unit);
  
  /**
   * Set the maintenance list
   * @param maintenances
   */
  void setMaintenance(List<Maintenance> maintenances);


}
