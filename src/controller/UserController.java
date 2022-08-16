package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.UnitList;
import model.User;
import service.ApplicantService;
import service.ManagerService;
import service.ResidentService;
import service.UserService;
import view.FindAptInterView;
import view.StartApplicationView;
import viewinterface.IApplicantView;
import viewinterface.IFindAptInterView;
import viewinterface.IStartApplicationView;
import viewinterface.IUserView;

public class UserController implements ActionListener {
  
  private User user;
  private UserService userService;
  private ApplicantService applicantService;
  private ResidentService residentService;
  private ManagerService managerService;
  private IUserView iUserView;
  
  public UserController(User user, UserService model1, ApplicantService model2,
      ResidentService residentService, ManagerService managerService ,IUserView view) {
    this.user = user;
    userService = model1;
    applicantService = model2;
    this.residentService = residentService;
    this.managerService = managerService;
    iUserView = view;
    iUserView.setListener(this);
    iUserView.display(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "search apt":   
        iUserView.openFindAptInterView();
        IFindAptInterView view = new FindAptInterView();
        //System.out.println("form user controller 46");
        //FindAptController findAptController = new FindAptController(userService, view);
        break;
      case "start apl":
        iUserView.openStartApplicationView(); 
        IStartApplicationView view2 = new StartApplicationView();
        StartApplicationController startApplicationController = new StartApplicationController(user, applicantService, view2);
        break;
      default:
        break;
      }           
    }
   
  }
