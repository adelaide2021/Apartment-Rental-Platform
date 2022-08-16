package dao;

import java.util.List;

import model.Applicant;
import model.RentalApplication;
import model.Unit;

public interface RentalApplicationList {
  
  /**
   * Add rental application to the rental application list
   * @param rentalApplication to be added
   * @return 1 when add successfully 0 when not
   */
  int addRentalApplication(RentalApplication rentalApplication);
  
  /**
   * Delete rental application from the rental application list
   * @param rentalApplication to be deleted
   * @return 1 when delete successfully 0 when not
   */
  int deleteRentalApplication(RentalApplication rentalApplication);
  
  /**
   * Search for rental application record of the given unit
   * @param unit 
   * @return rental application record of the given unit
   */
  RentalApplication getByUnit(Unit unit);
  
  /**
   * Search for rental application record of the given applicant
   * @param applicant
   * @return rental application record of the given applicant
   */
  RentalApplication getByApplicant(Applicant applicant);
  
  List<RentalApplication> getRentalApplicationList();
  
  void setRentalApplicationList(List<RentalApplication> rentalApplicationList);
  
  

}
