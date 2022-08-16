package dao;

import java.util.List;

import model.Applicant;
import model.ApplicationStatus;

public interface ApplicantList extends UserList {
  
  List<Applicant> getApplicantList();
  
  void setApplicantList(List<Applicant> applicantList);
  //判断这个申请人的收入是不是小于给的值
  boolean aboveAnnualIncome(Applicant applicant, double annualIncome);
  
  boolean aboveCreditScore(Applicant applicant, double creditScore);
  
  public Applicant findByEmail(String email);

}
