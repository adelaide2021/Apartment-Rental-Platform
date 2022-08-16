package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import model.Amenity;
import model.Applicant;
import model.RentalApplication;
import model.Unit;
import model.UnitType;
import model.User;
import service.ApplicantService;
import service.UserService;
import viewinterface.IFindAptInterView;
import viewinterface.IStartApplicationView;

public class StartApplicationController implements ActionListener {
  
  private User user;
  //private UserService userService;
  private ApplicantService applicantService;
  private IStartApplicationView iStartApplicationView;
  
  public StartApplicationController(User user, ApplicantService model, IStartApplicationView view) {
    this.user = user;
    applicantService = model;
    iStartApplicationView = view;
    iStartApplicationView.setListener(this);
    iStartApplicationView.display(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    double income = iStartApplicationView.getIncome();
    double credit = iStartApplicationView.getCredit();
    LocalDate moveinDate = iStartApplicationView.getMoveinDate();
    int term = iStartApplicationView.getTerm();
    Applicant newApplicant = new Applicant(user, income, credit, moveinDate, term);
    applicantService.addApplicant(newApplicant);
    
    String unitID  = iStartApplicationView.getUnitID();
    Unit unit = applicantService.findUnit(unitID);
    RentalApplication newApplication = new RentalApplication(newApplicant, unit);
    applicantService.addRentalApplication(newApplication);
    
    iStartApplicationView.throwMessage("Submit successfully");
    
  }
  
  

}
