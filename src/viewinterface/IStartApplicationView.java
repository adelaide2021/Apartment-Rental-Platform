package viewinterface;

import java.awt.event.ActionListener;
import java.time.LocalDate;

public interface IStartApplicationView {
  
  void setListener(ActionListener listener);

  double getIncome();
  
  double getCredit();
  
  LocalDate getMoveinDate();
  
  int getTerm();
  
  String getUnitID();
  
  void throwMessage(String str);
  
  void display(boolean display);
  
}
