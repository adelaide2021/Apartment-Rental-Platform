package viewinterface;

import java.awt.event.ActionListener;

import service.UserService;

public interface IUserView {
  
  void setListener(ActionListener listener);
  
  void display(boolean display);
  
  void openFindAptInterView();
  
  void openStartApplicationView();

}
