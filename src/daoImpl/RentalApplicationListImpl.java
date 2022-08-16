package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dao.RentalApplicationList;
import model.Applicant;
import model.RentalApplication;
import model.Unit;

/**
 * 
 * This class represents an application list.
 */

public class RentalApplicationListImpl implements RentalApplicationList{
 
  private List<RentalApplication> rentalApplicationList;
  
  public RentalApplicationListImpl() {
    rentalApplicationList = new ArrayList<>();
  }
  
  public RentalApplicationListImpl(List<RentalApplication> myRentalApplicationList) {
    rentalApplicationList = myRentalApplicationList;
  }
  

  @Override
  public int addRentalApplication(RentalApplication rentalApplication) {
    if (rentalApplicationList.contains(rentalApplication)) {
      return 0;
    }
    else {
      rentalApplicationList.add(rentalApplication);  
      return 1;      
    }
  }

  @Override
  public int deleteRentalApplication(RentalApplication rentalApplication) {
    if (rentalApplicationList.contains(rentalApplication)) {
      rentalApplicationList.remove(rentalApplication);
      return 1;
    }
    else {
      return 0;
    } 
  }

  @Override
  public RentalApplication getByUnit(Unit unit) {
    Optional<RentalApplication> result = rentalApplicationList.stream()
        .filter(m -> m.getUnit() == unit)
        .findFirst();
    return result.get();
  }
  

  @Override
  public RentalApplication getByApplicant(Applicant applicant) {
    Optional<RentalApplication> result = rentalApplicationList.stream()
        .filter(m -> m.getApplicant() == applicant)
        .findFirst();
    return result.get();
  }

  @Override
  public List<RentalApplication> getRentalApplicationList() {
    return rentalApplicationList;
  }

  @Override
  public void setRentalApplicationList(List<RentalApplication> rentalApplicationList) {
    this.rentalApplicationList = rentalApplicationList;
  }
  
  

}
