package viewinterface;

import java.awt.event.ActionListener;

public interface IReviewApplicationInterView {
  
  void setListener(ActionListener listener);
  
  String getEmail();
  
  void setInformation(String str);
  
  void display(boolean display);

}
