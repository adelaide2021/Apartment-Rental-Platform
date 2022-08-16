package model;

/**
 * This class represents maintenance fee of a unit. Range of maintenance
 * includes amenity, clog, electrical, flooring and window.
 */
public class Maintenance {

  /**
   * Construct a Maintenance and initialize it with the given repair time and
   * repair price of amenity, clog, electrical, flooring and window.
   * 
   * @param unit       the unit of this maintenance fee pay for
   * @param amenity    amenity repair time of this unit
   * @param clog       clog repair time of this unit
   * @param electrical electrical repair time of this unit
   * @param flooring   flooring repair time of this unit
   * @param window     window repair time of this unit
   */
  private Unit unit;
  private MaintenanceType[] type;
  private double maintenanceFee;

  public Maintenance(Unit unit, MaintenanceType[] maintenanceTypes) {
    this.unit = unit;
    this.type = new MaintenanceType[]{MaintenanceType.Clog, MaintenanceType.Electrical, 
                                    MaintenanceType.Flooring, MaintenanceType.Window};
    this.maintenanceFee = type[1].getRepairTimes()*type[1].getRepairFee() + 
        type[0].getRepairTimes()*type[0].getRepairFee() + 
        type[2].getRepairTimes()*type[2].getRepairFee() + 
        type[3].getRepairTimes()*type[3].getRepairFee();
  }
  
  
  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  public MaintenanceType[] getType() {
    return type;
  }


  public void setType(MaintenanceType[] type) {
    this.type = type;
  }


  public double getMaintenanceFee() {
    return maintenanceFee;
  }


  public void setMaintenanceFee(double maintenanceFee) {
    this.maintenanceFee = maintenanceFee;
  }

  public double getMaintenenceFee() {
    return maintenanceFee;
  }

  public void setMaintenenceFee() {
    maintenanceFee = type[1].getRepairTimes()*type[1].getRepairFee() + 
        type[0].getRepairTimes()*type[0].getRepairFee() + 
        type[2].getRepairTimes()*type[2].getRepairFee() + 
        type[3].getRepairTimes()*type[3].getRepairFee();
  }

  @Override
  public String toString() {
    return "Unit: " + unit + "\n" + "Maintenance time: \n" + "clog: "
        + type[0].getRepairTimes() + "\n" + "electrical: " + type[1].getRepairTimes() + "\n" + "flooring: " + type[2].getRepairTimes() + "\n"
        + "window: " + type[3].getRepairTimes();
  }




}
