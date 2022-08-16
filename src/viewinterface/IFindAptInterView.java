package viewinterface;

import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Amenity;
import model.UnitType;
import tool.Format;

public interface IFindAptInterView {
  
  public void setListener(ActionListener listener);
  
  public UnitType getUnitType();
  
  public Amenity getAmenity();
  
  public double getRent();

  public LocalDate getMoveindate();
 
  public void throwMessage();
 
  public void display(boolean display);
  
  public void printResult(String str);

}
