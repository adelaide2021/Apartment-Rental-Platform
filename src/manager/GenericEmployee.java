package manager;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import dao.UnitList;

/**
 * This abstract class represents a employee
 */
public abstract class GenericEmployee implements IEmployee {

    protected String number;
    protected String name;
    protected UnitList unitList;
    protected double pay;
    
    public GenericEmployee(String number, String name, UnitList unitList, double pay) {
      this.number = number;
      this.name = name;
      this.unitList = unitList;
      this.pay = pay;
    }   
   
    @Override
    public int count(Predicate<IEmployee> predicate) {
      if (predicate.test(this)) {
        return 1;
      }
      else {
        return 0;
      }
    }   
    
    @Override
    public List<IEmployee> toList(Predicate<IEmployee> predicate) {      
      List<IEmployee> resultList = new ArrayList<>();
      if (predicate.test(this)) {
        resultList.add(this);
      }
      return resultList;
    }

    public String getNumber() {
      return number;
    }

    public void setNumber(String number) {
      this.number = number;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public UnitList getUnitList() {
      return unitList;
    }

    public void setUnitList(UnitList unitList) {
      this.unitList = unitList;
    }

    public double getPay() {
      return pay;
    }

    public void setPay(double pay) {
      this.pay = pay;
    }

}
