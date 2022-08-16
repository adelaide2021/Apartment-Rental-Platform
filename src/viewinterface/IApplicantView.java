package viewinterface;

import java.awt.event.ActionListener;

import view.ApplicationStatusInterView;
import view.UpdateProfileInterView;

public interface IApplicantView {
  
  void setListener(ActionListener listener);
  
  void display(boolean display);
  
  void addApplicantStatusView(ApplicationStatusInterView applicationStatusInterView);
  
  void addUpdateProfileInterView(UpdateProfileInterView updateProfileInterView);

  void throwMessage(String str);
}
