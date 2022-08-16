package model;

public enum MaintenanceType {
  
  Clog(false, 0, 10.00),
  Electrical(false, 0, 30.00),
  Flooring(false, 0, 50.00),
  Window(false, 0, 10.00);
  
  private boolean waitForRepair;
  private int repairTimes;
  private double repairFee;
  
  private MaintenanceType(boolean waitForRepair,int repairTimes,double repairFee) {
    this.waitForRepair = waitForRepair;
    this.repairTimes = repairTimes;
    this.repairFee = repairFee;
  }

  public boolean isWaitForRepair() {
    return waitForRepair;
  }

  public void setWaitForRepair(boolean waitForRepair) {
    this.waitForRepair = waitForRepair;
  }

  public int getRepairTimes() {
    return repairTimes;
  }

  public void setRepairTimes(int repairTimes) {
    this.repairTimes = repairTimes;
  }

  public double getRepairFee() {
    return repairFee;
  }

  public void setRepairFee(double repairFee) {
    this.repairFee = repairFee;
  }


}
