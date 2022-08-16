package daoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import dao.ApplicationFeeList;
import model.ApplicationFee;
import model.Unit;
import model.User;

/**
 * This class represents an application fee list.
 */
public class ApplicationFeeListImpl implements ApplicationFeeList{
  
  private List<ApplicationFee> applicationFeeList;
  
  public ApplicationFeeListImpl() {
    applicationFeeList = new ArrayList<>();
  }

  @Override
  public int addApplicationFee(ApplicationFee applicationFee) {
    if (applicationFeeList.contains(applicationFee)) {
      return 0;
    }
    else {
      applicationFeeList.add(applicationFee);  
      return 1;      
    }
  }

  @Override
  public int deleteApplicationFee(ApplicationFee applicationFee) {
    if (applicationFeeList.contains(applicationFee)) {
      applicationFeeList.remove(applicationFee);
      return 1;
    }
    else {
      return 0;
    } 
  }

  @Override
  public List<ApplicationFee> findPaid() {
    List<ApplicationFee> resultList = applicationFeeList.stream()
        .filter(applicationFee -> applicationFee.isPaidApplFee())
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<ApplicationFee> findUnpaid() {
    List<ApplicationFee> resultList = applicationFeeList.stream()
        .filter(applicationFee -> !applicationFee.isPaidApplFee())
        .collect(Collectors.toList());
    return resultList;
  }
  
  @Override
  public boolean findUnitStatus(Unit unit) throws IllegalArgumentException {
    boolean result = false;
    try {
      for (ApplicationFee resultUnit : applicationFeeList) {
        if (resultUnit.getUnit().equals(unit)) {
             result = resultUnit.isPaidApplFee();
        }
      }
    }
    catch(NoSuchElementException e) {
      throw new IllegalArgumentException("Unit not found");
    }
    return result;
  }
  
  @Override 
  public double findUnitAmount(Unit unit) {
    for (ApplicationFee resultUnit : applicationFeeList) {
      if (resultUnit.getUnit().equals(unit)) {
         return resultUnit.getApplFee();
      }
    }
    return -1;
  }
  
  @Override
  public void setFeeStatus(ApplicationFee applicationFee, boolean status) {
    applicationFee.setPaidApplFee(status);
  }
  
  @Override
  public ApplicationFee getApplFeeByUnit(Unit unit) {
    Iterator<ApplicationFee> iterator = applicationFeeList.iterator();
    while (iterator.hasNext()){
      if (iterator.next().getUnit().equals(unit)){
        return iterator.next();
      }
    }
    return null;
  }
  

}
