package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dao.ApplicantList;
import model.Applicant;
import model.Resident;
import model.User;
import model.UserType;

/**
 * This class represents an applicant list.
 */
public class ApplicantListImpl extends UserListImpl implements ApplicantList {
  
  private List<Applicant> applicantList;
  
  public ApplicantListImpl() {
    applicantList = new ArrayList<>();
  }
  
  public ApplicantListImpl(List<Applicant> myApplicantList) {
    applicantList = new ArrayList<>();
    applicantList = myApplicantList;
    System.out.println(applicantList + "form apl list 23");
  }

  @Override
  public List<Applicant> getApplicantList() {
    return this.applicantList;
  }

  @Override
  public void setApplicantList(List<Applicant> applicantList) {
    this.applicantList = applicantList;
  }

  @Override
  public boolean aboveAnnualIncome(Applicant applicant, double annualIncome) {
    if (applicant.getAnnualIncome() >= annualIncome) {
      return true;
    }
    else {
      return false;
    }
  }

  @Override
  public boolean aboveCreditScore(Applicant applicant, double creditScore) {
    if (applicant.getCreditScore() >= creditScore) {
      return true;
    }
    else {
      return false;
    }
  }
  
  @Override
  public int addNewUser(User user) {
    if (user instanceof Applicant) {
      Applicant applicant = (Applicant)user;  
      if (!applicantList.contains(applicant)) {
        applicantList.add(applicant); 
        return 1;
      }
      else {
        return 0;
      }
    }
    else {         
      return 0;      
    }   
  }
  
  @Override
  public int deleteUser(User user) {
    if (applicantList.contains(user)) {
      applicantList.remove(user);
      return 1;
    }
    else {
      return 0;
    }  
  }

  @Override
  public List<User> findByFirstName(String firstName) {
    List<User> resultList = applicantList.stream()
                                    .filter(user -> user.getFirstName() == firstName)
                                    .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public List<User> findByLastName(String lastName) {
    List<User> resultList = applicantList.stream()
        .filter(user -> user.getLastName() == lastName)
        .collect(Collectors.toList());
    return resultList;
  }

  @Override
  public Applicant findByEmail(String email) {
    for (Applicant resultUser : applicantList) {
      if (resultUser.getEmail() == email) {
        return resultUser;
      }
    }
    return null;
  }

  
  
  
}
