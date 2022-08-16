package model;

/**
 * This class represents an utility of a unit.
 * Utility includes water, electricity and trash.
 */
public class Utility {
  private Unit unit;
  private double water;
  private double electricity;
  private double trash;
  
  private double utilityFee;
  
  private static double waterPerCCF = 5.56;
  private static double elecPerKWH = 0.117;
  private static double trashFee = 25.7;
  
  public Utility(Unit unit, double water, double electricity, double trash) {
    this.unit = unit;
    this.water = water;
    this.electricity = electricity;
    this.trash = trash;
    utilityFee = water*waterPerCCF + electricity*elecPerKWH + trash*trashFee;
  }

  public double getWater() {
    return water;
  }

  public void setWater(double water) {
    this.water = water;
  }

  public double getElectricity() {
    return electricity;
  }

  public void setElectricity(double electricity) {
    this.electricity = electricity;
  }

  public double getTrash() {
    return trash;
  }

  public void setTrash(double trash) {
    this.trash = trash;
  }
  
  public double getUtilityfee() {
    return utilityFee;
  }
  
  public void setUtilityFee() { 
    utilityFee = water*waterPerCCF + electricity*elecPerKWH + trash*trashFee;
  }

  public Unit getUnit() {
    return unit;
  }

  public void setUnit(Unit unit) {
    this.unit = unit;
  }

  @Override
  public String toString() {
    return "unit: " + unit + "\n" +
    "water: " + water*waterPerCCF + "\n" +
    "electricity: " + electricity*elecPerKWH + "\n" +
    "trash: " + trash*trashFee + "\n" +
    "total: " + utilityFee;
    
  }
  
  
    
  

}
