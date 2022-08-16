package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.User;
import service.ApplicantService;
import service.ManagerService;
import service.ResidentService;
import service.UserService;
import tool.Format;
import view.Login;
import view.UserView;
import viewinterface.ILogin;
import viewinterface.IRegisterView;
import viewinterface.IUserView;

//注册页面控制部分
public class RegisterController implements ActionListener {
  
  private UserService userService;
  private ApplicantService applicantService;
  private ResidentService residentService;
  private ManagerService managerService;
  
  private IRegisterView iRgisterView;
  
  public RegisterController(UserService model, ApplicantService model2, 
      ResidentService model3, ManagerService model4, IRegisterView view) {
    userService = model;
    applicantService = model2;
    residentService = model3;
    managerService = model4;
    iRgisterView = view;
    iRgisterView.setListener(this);
    iRgisterView.display(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String email = iRgisterView.getEmail();
    String firstname = iRgisterView.getFirstName();
    String lastname = iRgisterView.getLastName();
    String password = iRgisterView.getPassword();
    String str;
    str = userService.register(email, firstname, lastname, password);
    //System.out.print(str);
    firstname = Format.nameConvert(firstname);
    lastname = Format.nameConvert(lastname);
    if (str.equals("Duplicate registration")) {
      iRgisterView.throwException("You already have an account, please sign in");
      iRgisterView.display(false);
      ILogin view = new Login();
      LoginController controller = new LoginController(userService, applicantService, residentService, managerService, view);
    }
    else if (str.equals("Invalid name")) {
      iRgisterView.throwException("Name can only be letters");
    }
    else if (str.equals("Invalid password")) {
      iRgisterView.throwException("Password must be 8-16 characters, contain letters and numbers");     
    }
    else if (str.equals("Success")) {
      iRgisterView.throwException("Congratulations, your account has been successfully created!");
      iRgisterView.display(false);
      IUserView view = new UserView();
      User newUser = new User(email, firstname, lastname, password);
      userService.addUser(newUser);
      UserController controller = new UserController(newUser, userService, applicantService, residentService, managerService, view);
      //new UserView();    
    }
    else {
      System.out.println("404 error - register");
    }
  }



}
