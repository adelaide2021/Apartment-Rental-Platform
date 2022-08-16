package viewinterface;

import java.awt.event.ActionListener;

public interface IPayInterView {
  
  void setCurrBalance(double curr);
  
  double getAmount();
  
  void setAftBalance(double aft);
  
  void setListener(ActionListener listener);
  
  void display(boolean display);

}
