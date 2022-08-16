package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Resident;
import model.User;
import service.ApplicantService;
import service.ResidentService;
import service.UserService;
import view.PayInterView;
import viewinterface.IResidentView;
import viewinterface.IUserView;

public class ResidentController implements ActionListener {
  
  private Resident resident;//把user改成了resident
  private ResidentService residentService;//还没写residentservice
  private IResidentView residentView;
  
  //没有写构造函数
  
  @Override
  public void actionPerformed(ActionEvent e) {
    PayInterView payInterView = new PayInterView();
    payInterView.setVisible(true);
    residentView.addPayInterView(payInterView);
    double amount = residentService.getCurrBalance(resident);
    payInterView.setCurrBalance(amount);
    double pay = payInterView.getAmount();
    double aftBalance = amount - pay;
    payInterView.setAftBalance(aftBalance);  
  }
  

}
