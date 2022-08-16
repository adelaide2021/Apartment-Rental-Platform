package worker;

import dao.UnitList;
import manager.IEmployee;

/**
 * This class represents a technician.
 * A technician has a name, times of maintaining things,
 * and a pay per time.
 */
public class Technician {
    
  
    private String name;
    private int workingTimes;
    private double payPerTime;
    
    
    public Technician(String name, int times, double payPerTime) {
      this.name = name;
      this.workingTimes = times;
      this.payPerTime = payPerTime;
    }


    public String getName() {
      return name;
    }


    public void setName(String name) {
      this.name = name;
    }


    public int getWorkingTimes() {
      return workingTimes;
    }


    public void setWorkingTimes(int workingTimes) {
      this.workingTimes = workingTimes;
    }


    public double getPayPerTime() {
      return payPerTime;
    }


    public void setPayPerTime(double payPerTime) {
      this.payPerTime = payPerTime;
    }

    
    
    
 


}
