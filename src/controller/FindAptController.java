package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

import dao.UnitList;
import model.Amenity;
import model.Unit;
import model.UnitType;
import service.UserService;
import viewinterface.IFindAptInterView;

public class FindAptController implements ActionListener {
  
  private UserService userService;
  private IFindAptInterView iFindAptInterView;
  
  public FindAptController(UserService model, IFindAptInterView view) {
    userService = model;
    iFindAptInterView = view;
    iFindAptInterView.setListener(this);
    iFindAptInterView.display(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println(e.getActionCommand() + "from find apt contro 29");
    switch (e.getActionCommand()) {
      case "search":    
        UnitType type = iFindAptInterView.getUnitType();
        //System.out.println(type.toString());
        Amenity amenity = iFindAptInterView.getAmenity();
        double rent = iFindAptInterView.getRent();
        LocalDate date = iFindAptInterView.getMoveindate();
        List<Unit> resultUnits = userService.findApartment(type, amenity, rent, date);
        String resultString;
        if (resultUnits == null) {
          resultString = "No available apartment";
        }
        else {
          resultString = resultUnits.toString();
        }
        iFindAptInterView.printResult(resultString);       
    break;

  default:
    break;
}
    
  }
  
  
  
  

}
