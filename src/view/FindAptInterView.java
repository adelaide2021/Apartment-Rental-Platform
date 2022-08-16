package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import tool.Format;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import model.Amenity;
import model.Unit;
import model.UnitType;
import service.UserService;
import viewinterface.IFindAptInterView;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class FindAptInterView extends JInternalFrame implements IFindAptInterView {
  private JCheckBox studio;
  private JCheckBox oneboneb;
  private JCheckBox twoboneb;
  private JCheckBox twobtwob;
  private JCheckBox washdryer;
  private JCheckBox ac;
  private JCheckBox internet;
  private JCheckBox furniture;
  private JTextField moveinDate;
  private JTextField rent;
  private JButton search;
  private JTextField resultUnits;
  private UserService userService;
  

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          FindAptInterView frame = new FindAptInterView();
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the frame.
   */
  public FindAptInterView() {
    this.userService = userService;
    setBackground(new Color(230, 230, 250));
    setClosable(true);
    setIconifiable(true);
    setTitle("Find your dream apartment");
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("Type");
    
    studio = new JCheckBox("studio");
    
    oneboneb = new JCheckBox("1b1b");
    
    twoboneb = new JCheckBox("2b1b");
    
    twobtwob = new JCheckBox("2b2b");
    
    JLabel lblNewLabel_1 = new JLabel("Amenity");
    
    washdryer = new JCheckBox("wash&dryer");
    
    ac = new JCheckBox("air conditioner");
    
    internet = new JCheckBox("internet");
    
    furniture = new JCheckBox("furniture");
    
    JLabel lblNewLabel_2 = new JLabel("Rent");
    
    JLabel lblNewLabel_3 = new JLabel("Move in date");
    
    moveinDate = new JTextField();
    moveinDate.setColumns(10);
    
    rent = new JTextField();
    rent.setColumns(10);
    
    search = new JButton("search");
    /*
    search.addActionListener(new ActionListener() {
      
      public void actionPerformed(ActionEvent e) {
        System.out.println("from find apt inter view 107");
        UnitType type = null;
        if (studio.isSelected()) {
          type = UnitType.Studio;
        }
        else if (oneboneb.isSelected()) {
          type = UnitType.OneBOneB;
        }
        else if (twoboneb.isSelected()) {
          type = UnitType.TwoBOneB;
        }
        else if (twobtwob.isSelected()) {
          type = UnitType.TwoBOneB;
        } 
   
        boolean mywd = washdryer.isSelected();
        boolean myac = ac.isSelected();
        boolean myinternet = internet.isSelected();
        boolean myfurniture = furniture.isSelected();
        Amenity amenity = new Amenity(mywd, myac, myinternet, myfurniture);
        
        String rentString = rent.getText();
        double rent = Double.parseDouble(rentString) ;
        
        String moveinString = moveinDate.getText();
        LocalDate moveinDate = Format.strToDate(moveinString);
        
        List<Unit> resultUnit = userService.findApartment(type, amenity, rent, moveinDate);
        String resultString;
        if (resultUnit == null) {
          resultString = "No available apartment";
        }
        else {
          resultString = resultUnit.toString();
        }
        
        resultUnits.setText(resultString);
        
        
        System.out.println(type + "find apt 153");
      }
    });
   */
    //search.setActionCommand("search");
    
    
    
    resultUnits = new JTextField();
    resultUnits.setColumns(10);

    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(27)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(search)
              .addPreferredGap(ComponentPlacement.UNRELATED)
              .addComponent(resultUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addComponent(lblNewLabel_1)
            .addComponent(lblNewLabel)
            .addGroup(groupLayout.createSequentialGroup()
              .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                .addGroup(groupLayout.createSequentialGroup()
                  .addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(groupLayout.createSequentialGroup()
                      .addComponent(lblNewLabel_2)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(rent, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(ComponentPlacement.RELATED)
                      .addComponent(lblNewLabel_3))
                    .addComponent(washdryer, Alignment.LEADING)
                    .addComponent(internet, Alignment.LEADING))
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                    .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(furniture)
                    .addComponent(ac)))
                .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
                  .addComponent(studio)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(oneboneb)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(twoboneb)))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(twobtwob)))
          .addGap(12))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(22)
          .addComponent(lblNewLabel)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(studio)
            .addComponent(oneboneb)
            .addComponent(twoboneb)
            .addComponent(twobtwob))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblNewLabel_1)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(washdryer)
            .addComponent(ac))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(internet)
            .addComponent(furniture))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(rent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(lblNewLabel_3)
            .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(search)
            .addComponent(resultUnits, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(28, Short.MAX_VALUE))
    );
    getContentPane().setLayout(groupLayout);

  }
 
  @Override
  public void setListener(ActionListener listener) {
    System.out.println("from find apt inter view 188");
    search.addActionListener(listener);
  }
  
  @Override
  public UnitType getUnitType() {
    System.out.println("from find apt inter view 198");
    if (studio.isSelected()) {
      return UnitType.Studio;
    }
    else if (oneboneb.isSelected()) {
      return UnitType.OneBOneB;
    }
    else if (twoboneb.isSelected()) {
      return UnitType.TwoBOneB;
    }
    else if (twobtwob.isSelected()) {
      return UnitType.TwoBOneB;
    }  
    return null;
   }
  
  @Override
  public Amenity getAmenity() {
    boolean mywd = washdryer.isSelected();
    boolean myac = ac.isSelected();
    boolean myinternet = internet.isSelected();
    boolean myfurniture = furniture.isSelected();
    
    Amenity amenity = new Amenity(mywd, myac, myinternet, myfurniture);
    return amenity;
  }
  
  @Override
  public double getRent() {
    String rentString = rent.getText();
    double rent = Double.parseDouble(rentString) ;
    return rent;
  }
  
  @Override
  public LocalDate getMoveindate() {
    String moveinString = moveinDate.getText();
    LocalDate moveinDate = Format.strToDate(moveinString);
    return moveinDate;
  }  
 
  @Override
  public void throwMessage() {
    JOptionPane.showMessageDialog(null, "Invalid username or password!");
  }
  
  @Override
  public void display(boolean display) {
    if (display == true) {
      setVisible(true);
    }
    else {
      setVisible(false);
    }    
  }
  
  @Override
  public void printResult(String str) {
    resultUnits.setText(str);
  }
}
