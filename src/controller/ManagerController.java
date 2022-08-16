package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import model.Applicant;
import service.ManagerService;
import view.ReviewApplicationInterView;
import viewinterface.IManagerView;

public class ManagerController implements ActionListener{
  
  private ManagerService managerService;
  private IManagerView managerView;
  
  public ManagerController(ManagerService managerService, IManagerView managerView) {
    this.managerService = managerService;
    this.managerView = managerView;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "review application":
        ReviewApplicationInterView reviewApplicationInterView = new ReviewApplicationInterView();
        reviewApplicationInterView.setVisible(true);
        managerView.addReviewApplicationInterView(reviewApplicationInterView);
        String emailString = reviewApplicationInterView.getEmail();
        Applicant applicant = managerService.findApplicantByEmail(emailString);
        String informationString = managerService.getApplicantInformation(applicant);
        reviewApplicationInterView.setInformation(informationString);
        
        LocalDate date = LocalDate.of(2022, 7, 1);
        int changeResult = managerService.changeApplicantStatus(applicant, 50000, 300, date);
        if (changeResult == 1) {
           managerService.moveToResident(applicant);
        }      
        break;

      default:
        break;
    }
    
  }
  
  
  

}
