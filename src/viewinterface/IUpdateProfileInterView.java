package viewinterface;

import java.awt.event.ActionListener;

public interface IUpdateProfileInterView {
  
  void setListener(ActionListener listener);
  
  String getIncome();
  
  String getCredit();
  
  String getMovein();
  
  String getTerm();
  
  void throwMessage(String str);

}
