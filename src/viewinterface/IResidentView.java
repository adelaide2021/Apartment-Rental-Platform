package viewinterface;

import java.awt.event.ActionListener;

import view.PayInterView;

public interface IResidentView {
  
  void addPayInterView(PayInterView payInterView);
  
  void setListener(ActionListener listener);
  
  void display(boolean display);

}
