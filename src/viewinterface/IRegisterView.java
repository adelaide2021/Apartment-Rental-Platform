package viewinterface;

import java.awt.event.ActionListener;

public interface IRegisterView {
  
  void setListener(ActionListener listener);
  
  String getEmail();
  
  String getFirstName();
  
  String getLastName();
  
  String getPassword();
  
  void throwException(String string);
  
  void display(boolean value);
  


}
