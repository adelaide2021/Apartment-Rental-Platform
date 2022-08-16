package serviceImpl;

import java.util.List;

import dao.ApplicantList;
import dao.ApplicationFeeList;
import dao.RentalApplicationList;
import dao.UnitList;
import daoImpl.ApplicantListImpl;
import daoImpl.RentalApplicationListImpl;
import daoImpl.UnitListImpl;
import daoImpl.UserListImpl;
import model.Applicant;
import model.ApplicationFee;
import model.ApplicationStatus;
import model.RentalApplication;
import model.Unit;
import model.User;
import service.ApplicantService;
/**
 * This class represents all the operations that an applicant can do
 * in this rental system
 */
public class ApplicantServiceImpl implements ApplicantService {
  
  private static ApplicantList applicantServiceList;//s是否要加static？
  private static UnitList unitServiceList;
  private static RentalApplicationList rentalApplicationServiceList;
  private static ApplicationFeeList applFeeServiceList;

  public ApplicantServiceImpl() {
    applicantServiceList = new ApplicantListImpl();
    unitServiceList = new UnitListImpl();
    rentalApplicationServiceList = new RentalApplicationListImpl();
  }
  
  public ApplicantServiceImpl(List<Applicant> applicantList, List<Unit> unitList, List<RentalApplication> rentalApplicantList) {
    applicantServiceList = new ApplicantListImpl();
    applicantServiceList.setApplicantList(applicantList);
    unitServiceList = new UnitListImpl();
    unitServiceList.setUnitList(unitList);
    rentalApplicationServiceList = new RentalApplicationListImpl();
    
    rentalApplicationServiceList = new RentalApplicationListImpl(rentalApplicantList);
    rentalApplicationServiceList.setRentalApplicationList(rentalApplicantList);
  }   
  
  @Override
  public ApplicationStatus getApplicationStatus(Applicant applicant) {
    return applicant.getStatus();
  }

  @Override
  public ApplicantList getApplicantServiceList() {
    return applicantServiceList;
  }

  @Override
  public void setApplicantServiceList(ApplicantList applicantServiceList) {
    ApplicantServiceImpl.applicantServiceList = applicantServiceList;
  }

  @Override
  public UnitList getUnitServiceList() {
    return unitServiceList;
  }

  @Override
  public void setUnitServiceList(UnitList unitServiceList) {
    ApplicantServiceImpl.unitServiceList = unitServiceList;
  }

  @Override
  public RentalApplicationList getRentalApplicationServiceList() {
    return rentalApplicationServiceList;
  }

  @Override
  public void setRentalApplicationServiceList(
      RentalApplicationList rentalApplicationServiceList) {
    ApplicantServiceImpl.rentalApplicationServiceList = rentalApplicationServiceList;
  }
  
  @Override
  public int addApplicant(User applicant) {
    int returnInt = applicantServiceList.addNewUser(applicant);
    return returnInt;
  }
  
  @Override
  public Unit findUnit(String unitID) {
    return unitServiceList.findByUnitID(unitID);
  }
  
  @Override
  public void addRentalApplication(RentalApplication rentalApplication) {
    rentalApplicationServiceList.addRentalApplication(rentalApplication);
  }
  
  @Override 
  public void submitApplication(Applicant applicant, Unit unit) {
    RentalApplication rentalApplication = new RentalApplication(applicant, unit);
    rentalApplicationServiceList.addRentalApplication(rentalApplication);
    ApplicationFee applicationFee = new ApplicationFee(unit, false);
    applFeeServiceList.addApplicationFee(applicationFee);
  }
  
  @Override
  public String payApplicationFee(Applicant applicant, double payment) {   
    //此处参数是applicant而非user有待考虑
    RentalApplication application = rentalApplicationServiceList.getByApplicant(applicant);
    Unit unit  = application.getUnit();
    ApplicationFee applicationFee = applFeeServiceList.getApplFeeByUnit(unit);
    boolean feeStatus = applicationFee.isPaidApplFee();
    if (feeStatus == true) {
      return "Application fee has been paid";
    }
    else {
      double amount = applicationFee.getApplFee();
      if (payment == amount) {
        applicationFee.setPaidApplFee(true);
        return "Pay sucessfully";
      }
      else {
        return "Wrong payment amount";
      }
    }
  } 
  
  
  

}
