package service;

import dao.ApplicantList;
import dao.RentalApplicationList;
import dao.UnitList;
import model.Applicant;
import model.ApplicationStatus;
import model.RentalApplication;
import model.Unit;
import model.User;

public interface ApplicantService {
  
  /**
   * Add a new applicant to the current applicant list.
   * @param applicant
   * @return 1 if success 0 if not
   */
  int addApplicant(User applicant);
  
  /**
   * Add a new rental application to the current rental application list.
   * @param rentalApplication
   */
  void addRentalApplication(RentalApplication rentalApplication);
  
  /**
   * Find the unit of the given id
   * @param unitID
   * @return the unit of the given id
   */
  Unit findUnit(String unitID);
  
  /**
   * Get the application status of the applicant
   * @param applicant
   * @return the application status of the applicant
   */
  ApplicationStatus getApplicationStatus(Applicant applicant);
  
  /**
   * Submit application 
   * @param applicant
   * @param unit
   */
  void submitApplication(Applicant applicant, Unit unit);
  
  /**
   * Pay application fee
   * @param applicant
   * @param payment
   * @return String that indicates the application fee payment statement
   */
  String payApplicationFee(Applicant applicant, double payment);
  
  ApplicantList getApplicantServiceList();
  
  public void setApplicantServiceList(ApplicantList applicantServiceList);
  
  public UnitList getUnitServiceList();
  
  public void setUnitServiceList(UnitList unitServiceList);
  
  public RentalApplicationList getRentalApplicationServiceList();
  
  public void setRentalApplicationServiceList(RentalApplicationList rentalApplicationServiceList);
  
  
}
