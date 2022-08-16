package service;

import java.time.LocalDate;

import model.Applicant;
import model.User;

public interface ManagerService {

  /**
   * Change the application status
   * @param applicant
   * @param income
   * @param credit
   * @param moveinDate
   */
  int changeApplicantStatus(Applicant applicant, double income, double credit, LocalDate moveinDate);
  
  /**
   * Remind the applicant to pay her/his application fee
   * @param applicant
   * @return message sent to the applicant
   */
  String remindPayApplFee(Applicant applicant);
  
  /**
   * Move the current applicant to be resident
   * @param applicant
   */
  void moveToResident(Applicant applicant);
  
  /**
   * Find applicant by email
   * @param email
   * @return
   */
  Applicant findApplicantByEmail(String email);
  
  /**
   * Get the information of the given applicant
   * @param applicant
   * @return
   */
  String getApplicantInformation(Applicant applicant);
}
