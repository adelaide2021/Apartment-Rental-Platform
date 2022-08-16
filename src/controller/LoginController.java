package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import model.User;
import model.UserType;
import dao.UserList;
import service.ApplicantService;
import service.ManagerService;
import service.ResidentService;
import service.UserService;
import serviceImpl.UserServiceImpl;
import view.Login;
import view.RegisterView;
import view.UserView;
import viewinterface.ILogin;
import viewinterface.IRegisterView;
import viewinterface.IUserView;

/**
 * This class represents a login view controller.
 */
//@Controller，这都是springmvc网页框架中的
//@RequestMapping
public class LoginController implements ActionListener{
  
  private UserService userService;
  private ApplicantService applicantService;
  private ResidentService residentService;
  private ManagerService managerService;
  //要把所有的service在driver里初始化然后传递值到这里
  private ILogin ilogin;
  
  public LoginController(UserService model1, ApplicantService model2, 
      ResidentService model3, ManagerService model4,
      ILogin view) {
    //System.out.println("form login controller 39");
    userService = model1;
    applicantService = model2;
    residentService = model3;
    managerService = model4;
    ilogin = view;
    ilogin.setListener(this);
    ilogin.display(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //System.out.println(e.getActionCommand());
    switch (e.getActionCommand()) {
      
      case "login button":
        //System.out.println(userService.getUserList().getUserList() + "form login controller 52");
        User resultUser = null;
        String email = ilogin.getEmail();
        String password = ilogin.getPassword();
        resultUser = userService.login(email, password);
        //System.out.println(userService.getUserList().getUserList() + "form login controller 57");
        //System.out.println(resultUser + "form login controller 58");
        if (resultUser == null) {
          ilogin.throwException();
        }
        else {
          if (resultUser.getUserType().equals(UserType.guest)) {//全部改成equals！！！
            //System.out.println("form login controller 65");
            ilogin.display(false);
            IUserView view = new UserView();
            UserController controller = new UserController(resultUser, userService, applicantService,residentService, managerService, view);
          }
          else if (resultUser.getUserType().equals(UserType.applicant)) {
            ilogin.display(false);
            new ApplicantController();
            //1.直接new能不能实现跳转窗口
            //2.实现跳转窗口是new一个view还是controller
          }
          else if (resultUser.getUserType().equals(UserType.resident)) {
            ilogin.display(false);
            new ResidentController();
          }
          else {
            System.out.println("404 error - log in");
          }      
        }      
        break;
      case "signup button":
        //UserService model = new UserServiceImpl();//是否需要新建UserService？
        ilogin.display(false);
        IRegisterView view = new RegisterView();
        RegisterController controller = new RegisterController(userService, applicantService, residentService, managerService, view);
        //controller.actionPerformed(e);
        //new RegisterView();
      case "manager button":
        
      default:
        break;
    }
    
  }
  

}
