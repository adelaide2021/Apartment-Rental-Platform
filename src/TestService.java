  import static org.junit.jupiter.api.Assertions.*;

  import java.time.LocalDate;
  import java.util.ArrayList;
  import java.util.List;

  import static org.junit.Assert.assertEquals;


  import org.junit.Before;
  import org.junit.Test;


  import dao.ResidentList;
  import daoImpl.ResidentListImpl;
  import model.Amenity;
  import model.Applicant;
  import model.ApplicationFee;
import model.ApplicationStatus;
import model.Bill;
  import model.Deposit;
  import model.Maintenance;
  import model.MaintenanceType;
  import model.RentalApplication;
  import model.Resident;
  import model.Unit;
  import model.UnitType;
  import model.User;
  import model.Utility;
  import service.ApplicantService;
  import service.ManagerService;
  import service.ResidentService;
  import service.UserService;
  import serviceImpl.ApplicantServiceImpl;
  import serviceImpl.ManagerServiceImpl;
  import serviceImpl.ResidentServiceImpl;
  import serviceImpl.UserServiceImpl;

  
  public class TestService {
   
    private List<User> myUsers;
    private UserService userService;
    private List<Unit> myUnitList; 
    private List<Applicant> myApplicants;
    private List<RentalApplication> myRentalApplicationList;
    private ApplicantService applicantService;
    private List<Resident> myResidentlList;
    private List<Deposit> myDeposit;
    private List<Maintenance> myMaintenance;
    private List<Utility> myUtility;
    private List<Bill> myBill;
    private ResidentService residentService;
    private ManagerService managerService ;
    
    @Before
    public void setUp() {
      //User
      User u1 = new User("u1@sample.com", "u", "one", "a1234567");
      User u2 = new User("u2@sample.com", "u", "two", "b1234567");
      User u3 = new User("u3@sample.com", "u", "three", "c1234567");
      User u4 = new User("u4@sample.com", "u", "four", "d1234567");
      User u5 = new User("u5@sample.com", "u", "five", "e1234567");
      
      User u6 = new User("u6@sample.com", "u", "six", "f1234567");
      User u7 = new User("u7@sample.com", "u", "seven", "g1234567");
      User u8 = new User("u8@sample.com", "u", "eight", "h1234567");
      User u9 = new User("u9@sample.com", "u", "night", "i1234567");
      User u10 = new User("u10@sample.com", "u", "ten", "j1234567");
      
      User u11 = new User("u11@sample.com", "u", "eleven", "k1234567");
      User u12 = new User("u12@sample.com", "u", "twelve", "l1234567");
      User u13 = new User("u13@sample.com", "u", "thirteen", "m1234567");
      User u14 = new User("u14@sample.com", "u", "forteen", "n1234567");
      User u15 = new User("u15@sample.com", "u", "fifteen", "o1234567");
      
      //list of user
      myUsers = new ArrayList<>();
      myUsers.add(u1);
      myUsers.add(u2);
      myUsers.add(u3);
      myUsers.add(u4);
      myUsers.add(u5);
      myUsers.add(u6);
      myUsers.add(u7);
      myUsers.add(u8);
      myUsers.add(u9);
      myUsers.add(u10);
      myUsers.add(u11);
      myUsers.add(u12);
      myUsers.add(u13);
      myUsers.add(u14);
      myUsers.add(u15);

      //Initialize UserService
      userService = new UserServiceImpl(myUsers);
      
      //Amenity
      Amenity amenity1 = new Amenity(true, false, false, false);
      Amenity amenity2 = new Amenity(true, true, false, false);
      Amenity amenity3 = new Amenity(true, false, true, false);
      Amenity amenity4 = new Amenity(true, true, true, false);
      Amenity amenity5 = new Amenity(true, true, true, true);
          
      //Unit
      Unit unit1 = new Unit("101", UnitType.Studio, amenity5, 2000);
      Unit unit2 = new Unit("102", UnitType.Studio, amenity2, 1000);
      Unit unit3 = new Unit("103", UnitType.OneBOneB, amenity3, 1800);
      Unit unit4 = new Unit("201", UnitType.OneBOneB, amenity3, 2000);
      Unit unit5 = new Unit("202", UnitType.TwoBOneB, amenity4, 3500);
      Unit unit6 = new Unit("203", UnitType.TwoBOneB, amenity4, 3600);
      Unit unit7 = new Unit("301", UnitType.TwoBTwoB, amenity5, 4000);
      Unit unit8 = new Unit("302", UnitType.TwoBTwoB, amenity5, 4000);
      Unit unit9 = new Unit("303", UnitType.TwoBOneB, amenity5, 4000);
      Unit unit10 = new Unit("401", UnitType.Studio, amenity1, 800);
      Unit unit11 = new Unit("402", UnitType.OneBOneB, amenity2, 1000);
      Unit unit12 = new Unit("403", UnitType.TwoBTwoB, amenity1, 2000);
      
      //list of unit
      myUnitList =  new ArrayList<>();
      myUnitList.add(unit1);
      myUnitList.add(unit2);
      myUnitList.add(unit3);
      myUnitList.add(unit4);
      myUnitList.add(unit5);
      myUnitList.add(unit6);    
      myUnitList.add(unit7);  
      myUnitList.add(unit8);  
      myUnitList.add(unit9); 
      myUnitList.add(unit10);  
      myUnitList.add(unit11);  
      myUnitList.add(unit12);  
      
      //LocalDate
      LocalDate d1 = LocalDate.of(2022, 5, 20);
      LocalDate d2 = LocalDate.of(2022, 6, 30);
      LocalDate d3 = LocalDate.of(2022, 10, 1);
      LocalDate d4 = LocalDate.of(2022, 5, 26);
      LocalDate d5 = LocalDate.of(2022, 7, 24);
      
      //Applicant
      Applicant a1 = new Applicant(u6, 60000, 500, d1, 6);
      Applicant a2 = new Applicant(u7, 100000, 600, d2, 6);
      Applicant a3 = new Applicant(u8, 70000, 550, d3, 12);
      Applicant a4 = new Applicant(u9, 60000, 600, d4, 9);
      Applicant a5 = new Applicant(u10, 60000, 700, d5, 12);
      
      //RentalApplication
      RentalApplication r1 = new RentalApplication(a1, unit1);
      RentalApplication r2 = new RentalApplication(a2, unit2);
      RentalApplication r3 = new RentalApplication(a3, unit3);
      RentalApplication r4 = new RentalApplication(a4, unit4);
      RentalApplication r5 = new RentalApplication(a5, unit5);
       
      //list of rental applicant
       myApplicants = new ArrayList<>();
      myApplicants.add(a1);
      myApplicants.add(a2);
      myApplicants.add(a3);
      myApplicants.add(a4);
      myApplicants.add(a5);
      
      //list of rental application
      myRentalApplicationList = new ArrayList<>();
      myRentalApplicationList.add(r1);
      myRentalApplicationList.add(r2);
      myRentalApplicationList.add(r3);
      myRentalApplicationList.add(r4);
      myRentalApplicationList.add(r5);
      
      //Initialize ApplicantService
      applicantService = new ApplicantServiceImpl(myApplicants, myUnitList, myRentalApplicationList);

      
      //Resident
      Resident res1 = new Resident(u11, unit6);
      Resident res2 = new Resident(u12, unit7);
      Resident res3 = new Resident(u13, unit8);
      Resident res4 = new Resident(u14, unit9);
      Resident res5 = new Resident(u15, unit10);
      
      //list of resident
      myResidentlList = new ArrayList<>();
      myResidentlList.add(res1);
      myResidentlList.add(res2);
      myResidentlList.add(res3);
      myResidentlList.add(res4);
      myResidentlList.add(res5);
      
      //Deposit
      Deposit deposit1 = new Deposit(unit1, false);//unit6 application has been approved
      Deposit deposit2 = new Deposit(unit2, false);
      Deposit deposit3 = new Deposit(unit3, false);
      Deposit deposit4 = new Deposit(unit4, true);
      Deposit deposit5 = new Deposit(unit5, true);
      
      //list of deposit 
      myDeposit = new ArrayList<>();
      myDeposit.add(deposit1);
      myDeposit.add(deposit2);
      myDeposit.add(deposit3);
      myDeposit.add(deposit4);
      myDeposit.add(deposit5);
      
      //Utility
      Utility uti1 = new Utility(unit6, 10.00, 900.00, 1.00);
      Utility uti2 = new Utility(unit7, 11.00, 1900.00, 1.00);
      Utility uti3 = new Utility(unit8, 9.00, 1000.00, 1.00);
      Utility uti4 = new Utility(unit9, 8.00, 500.00, 1.00);
      Utility uti5 = new Utility(unit10, 3.00, 100.00, 1.00);
       
      //list of utility
      myUtility = new ArrayList<>();
      myUtility.add(uti1);
      myUtility.add(uti2);
      myUtility.add(uti3);
      myUtility.add(uti4);
      myUtility.add(uti5);
      
      //Application Fee
      ApplicationFee aplFee1 = new ApplicationFee(unit1, false);
      ApplicationFee aplFee2 = new ApplicationFee(unit2, false);
      ApplicationFee aplFee3 = new ApplicationFee(unit3, true);
      ApplicationFee aplFee4 = new ApplicationFee(unit4, true);
      ApplicationFee aplFee5 = new ApplicationFee(unit5, true);
      List<ApplicationFee> myAplFee = new ArrayList<>();
      myAplFee.add(aplFee1);
      myAplFee.add(aplFee2);
      myAplFee.add(aplFee3);
      myAplFee.add(aplFee4);
      myAplFee.add(aplFee5);
      
      //Maintenance type
      MaintenanceType mt1 = MaintenanceType.Clog;
      MaintenanceType mt2 = MaintenanceType.Electrical;
      MaintenanceType mt3 = MaintenanceType.Flooring;
      MaintenanceType mt4 = MaintenanceType.Window;
      MaintenanceType[] mtlist = new MaintenanceType[]{mt1, mt2, mt3, mt4};
      
      //Maintenance
      Maintenance m1 = new Maintenance(unit6, mtlist);
      Maintenance m2 = new Maintenance(unit7, mtlist);
      Maintenance m3 = new Maintenance(unit8, mtlist);
      Maintenance m4 = new Maintenance(unit9, mtlist);
      Maintenance m5 = new Maintenance(unit10, mtlist);
      
      //list of maintenance
      myMaintenance = new ArrayList<>();
      myMaintenance.add(m1);
      myMaintenance.add(m2);
      myMaintenance.add(m3);
      myMaintenance.add(m4);
      myMaintenance.add(m5);
      
      //bill
      Bill b1 = new Bill(unit6, 100);
      Bill b2 = new Bill(unit7, 1200);
      Bill b3 = new Bill(unit8, -100);
      Bill b4 = new Bill(unit9, 1000);
      Bill b5 = new Bill(unit10, 0);
      
      //list of bill
      myBill = new ArrayList<>();
      myBill.add(b1);
      myBill.add(b2);
      myBill.add(b3);
      myBill.add(b4);
      myBill.add(b5);
      
      //initialize resident service  
      residentService = new ResidentServiceImpl(myResidentlList, myUnitList, myMaintenance, myUtility, myBill);
      //initialize manager service  
      managerService = new ManagerServiceImpl(myApplicants, myRentalApplicationList, myDeposit, myAplFee, myAplFee, myResidentlList, myBill);
           
    }

    @Test
    public void testAddUser() {
      User u16 = new User("u16@sample.com", "u", "sixteen", "o1234567");
      userService.addUser(u16);
      assertEquals(16, myUsers.size());
    }
    
    
    @Test
    public void testApplicationStatus(){
      User u6 = new User("u6@sample.com", "u", "six", "f1234567");
      LocalDate d1 = LocalDate.of(2022, 5, 20);
      Applicant a1 = new Applicant(u6, 60000, 500, d1, 6);
      ApplicationStatus status = applicantService.getApplicationStatus(a1);
      assertEquals(ApplicationStatus.NotAppl.toString(), status.toString());
    }
    
    @Test
    public void testFindByUnit() {
      Unit unit = applicantService.findUnit("101");
      assertEquals("101", unit.getUnitID());
    }
    
    @Test
    public void testAddRentalApplication() {
      Amenity amenity2 = new Amenity(true, true, false, false);
      Unit unit11 = new Unit("402", UnitType.OneBOneB, amenity2, 1000);
      User u11 = new User("u11@sample.com", "u", "eleven", "k1234567");
      LocalDate d1 = LocalDate.of(2022, 5, 20);
      Applicant a6 = new Applicant(u11, 60000, 700, d1, 12);
      RentalApplication rentalApplication = new RentalApplication(a6, unit11);
      applicantService.addRentalApplication(rentalApplication);
      assertEquals(6, myRentalApplicationList.size());    
    }
    
    
    @Test
    public void testGetCurrBalance() {
      User u11 = new User("u11@sample.com", "u", "eleven", "k1234567");
      Amenity amenity4 = new Amenity(true, true, true, false);
      Unit unit6 = new Unit("203", UnitType.TwoBOneB, amenity4, 3600);
      Resident res1 = new Resident(u11, unit6);
      double balance = residentService.getCurrBalance(res1);
      assertEquals(100.00, balance, 0.01);
    }
    
    @Test
    public void test() {
      User u11 = new User("u11@sample.com", "u", "eleven", "k1234567");
      Amenity amenity4 = new Amenity(true, true, true, false);
      Unit unit6 = new Unit("203", UnitType.TwoBOneB, amenity4, 3600);
      Resident res1 = new Resident(u11, unit6);
      residentService.payCurrBalance(res1, -10.00);
      double balance = residentService.getCurrBalance(res1);
      assertEquals(90.00, balance, 0.01);
    }
    
 
    
    
    
    
   
    
    



}
