package viewinterface;

import java.awt.event.ActionListener;

public interface ILogin {
  
  void setListener(ActionListener listener);
  
  String getEmail();
  
  String getPassword();
  
  void throwException();
  
  void display(boolean display);
  
}
