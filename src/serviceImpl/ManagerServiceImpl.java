package serviceImpl;

import java.time.LocalDate;

import java.util.Comparator;
import java.util.List;

import dao.ApplicantList;
import dao.ApplicationFeeList;
import dao.BillList;
import dao.DepositList;
import dao.MaintenanceList;
import dao.RentalApplicationList;
import dao.ResidentList;
import daoImpl.ApplicantListImpl;
import daoImpl.ApplicationFeeListImpl;
import daoImpl.BillListImpl;
import daoImpl.DepositListImpl;
import daoImpl.RentalApplicationListImpl;
import service.ManagerService;
import model.Applicant;
import model.ApplicationFee;
import model.ApplicationStatus;
import daoImpl.ResidentListImpl;
import model.Bill;
import model.Deposit;
import model.RentalApplication;
import model.Resident;
import model.Unit;
import model.User;

public class ManagerServiceImpl implements ManagerService, Comparator<Applicant>{
  
  private ApplicantList applicantServiceList;
  private RentalApplicationList rentalApplicationServiceList;
  private ApplicationFeeList applicationFeeServiceList;
  private DepositList depositServiceList;
    
  private ResidentList residentServiceList;
  private BillList billServiceList;
  
  //构造函数要怎么写？要看在controller的时候怎么弄的
  public ManagerServiceImpl(List<Applicant> applicantServiceList, List<RentalApplication> rentalApplicationServiceList,
              List<Deposit> depositFeeServiceList,
              List<ApplicationFee> applicationFeeServiceList, List<ApplicationFee> depositServiceList,
              List<Resident> residentList, List<Bill> billServiceList)  {
    this.applicantServiceList = new ApplicantListImpl();
    this.applicantServiceList.setApplicantList(applicantServiceList);
    
    this.rentalApplicationServiceList = new RentalApplicationListImpl();
    this.rentalApplicationServiceList.setRentalApplicationList(rentalApplicationServiceList);
    
    this.depositServiceList = new DepositListImpl();
    this.depositServiceList.setDepositList(depositFeeServiceList);
    
    this.applicationFeeServiceList = new ApplicationFeeListImpl();
    this.applicantServiceList.setApplicantList(applicantServiceList);
    
    this.residentServiceList = new ResidentListImpl();
    this.residentServiceList.setResidentList(residentList);
    
    this.billServiceList = new BillListImpl();
    this.billServiceList.setBilList(billServiceList);

  }
  
  @Override
  public Applicant findApplicantByEmail(String email) {
    return applicantServiceList.findByEmail(email);
  }
  
  @Override
  public String getApplicantInformation(Applicant applicant) {
    RentalApplication rentalApplication = rentalApplicationServiceList.getByApplicant(applicant);
    Unit unit = rentalApplication.getUnit();
    ApplicationFee applicationFee = applicationFeeServiceList.getApplFeeByUnit(unit);
    boolean applFeeStatus = applicationFee.isPaidApplFee();
    Deposit deposit = depositServiceList.findByUnit(unit);
    boolean depositStatus = deposit.isPaidDeposit();
    String string = "Name: " + applicant.getFirstName() + applicant.getLastName()
                  + "\n Unit apply for: " + unit.getUnitID()
                  + "\n application fee: " + applFeeStatus
                  + "\n deposit: " + depositStatus;
    return string;
  }
  
  @Override
  public int changeApplicantStatus(Applicant applicant, double income, double credit, LocalDate moveinDate) {
    if (applicant.getAnnualIncome() >= income &&
        applicant.getCreditScore() >= credit &&
        applicant.getExpMoveInDate().isBefore(moveinDate)) {
      applicant.setStatus(ApplicationStatus.Appr);
      return 1;
    }
    else {
      applicant.setStatus(ApplicationStatus.Ref);
      return 0;
    }
  }
  
  @Override
  public String remindPayApplFee(Applicant applicant) {
    RentalApplication rentalApplication = rentalApplicationServiceList.getByApplicant(applicant);
    Unit unit = rentalApplication.getUnit();    
    boolean result = applicationFeeServiceList.findUnitStatus(unit);
    if (result == false) {
      return "Please pay the application fee";
    }
    else {
      return "";
    }  
  }

  @Override
  //这里缺少冒号负号，没看懂是干什么的
  public int compare(Applicant o1, Applicant o2) {
    int result = 0;
    int a = ((Double)o1.getAnnualIncome()).compareTo((Double)o2.getAnnualIncome());
    if (a != 0) {
      result = a;
    }
    else {
      a = ((Double)o1.getCreditScore()).compareTo((Double)o2.getCreditScore());
      if (a != 0) {
        result = a;
      }
    }
    return result;
  }
  
  @Override
  public void moveToResident(Applicant applicant) {
    RentalApplication rentalApplication = rentalApplicationServiceList.getByApplicant(applicant);
    Unit unit = rentalApplication.getUnit();
    Deposit deposit = depositServiceList.findByUnit(unit);
    if (deposit.isPaidDeposit() == true) {
      Resident newResident = new Resident(applicant, unit);
      residentServiceList.addNewUser(newResident);
    }
  }
  

}
