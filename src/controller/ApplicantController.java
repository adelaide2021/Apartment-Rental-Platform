package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.time.LocalDate;

import model.Applicant;
import model.ApplicationStatus;
import model.User;
import service.ApplicantService;
import tool.Format;
import view.ApplicationStatusInterView;
import view.PayInterView;
import view.UpdateProfileInterView;
import viewinterface.IApplicantView;
import viewinterface.IApplicationStatusInterView;
import viewinterface.IPayInterView;

public class ApplicantController implements ActionListener {
  
  private Applicant applicant;//把原来的user改成了applicant
  private ApplicantService applicantService;
  private IApplicantView applicantView;
  //还要写其他的变量
  //public ..//构造函数
  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "application status":      
        ApplicationStatusInterView applicationStatusInterView = new ApplicationStatusInterView(); 
        applicationStatusInterView.setVisible(true);
        applicantView.addApplicantStatusView(applicationStatusInterView);
        ApplicationStatus status = applicant.getStatus();
        applicationStatusInterView.setStatusTxt(status.toString());
        break;
      case "update profile":
        UpdateProfileInterView updateProfileInterView = new UpdateProfileInterView();
        updateProfileInterView.setVisible(true);
        applicantView.addUpdateProfileInterView(updateProfileInterView);
        double income = Format.strToDouble(updateProfileInterView.getIncome());
        double credit = Format.strToDouble(updateProfileInterView.getCredit());
        LocalDate moveinDate = Format.strToDate(updateProfileInterView.getMovein());
        int term = Format.strToInt(updateProfileInterView.getTerm()); 
        applicant.setAnnualIncome(income);
        applicant.setCreditScore(credit);
        applicant.setExpMoveInDate(moveinDate);
        applicant.setTerm(term);
        updateProfileInterView.throwMessage("Your profile has been updated!");
      case "review profile":
        double myIncome = applicant.getAnnualIncome();
        double myCredit = applicant.getCreditScore();
        LocalDate myMoveDate = applicant.getExpMoveInDate();
        int myTerm = applicant.getTerm();
        applicantView.throwMessage("Income: " + myIncome 
            + "\n Credit: " + myCredit
            + "\n Move in date: " + myMoveDate
            + "\n Term: " + myTerm);       
        break;
      default:
        break;
    }
    
  }
  
  

  
  
  
  

}
