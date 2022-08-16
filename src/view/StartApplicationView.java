package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import model.UnitType;
import tool.Format;
import viewinterface.IStartApplicationView;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class StartApplicationView extends JInternalFrame implements IStartApplicationView {
  private JTextField income;
  private JTextField credit;
  private JTextField moveinDate;
  private JTextField term;
  private JTextField unit;
  private JButton submit;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          StartApplicationView frame = new StartApplicationView();
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
  public StartApplicationView() {
    setTitle("Start my application");
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("annual income");
    
    JLabel lblNewLabel_1 = new JLabel("credit score");
    
    JLabel lblNewLabel_2 = new JLabel("move in date");
    
    JLabel lblNewLabel_3 = new JLabel("term");
    
    income = new JTextField();
    income.setColumns(10);
    
    credit = new JTextField();
    credit.setColumns(10);
    
    moveinDate = new JTextField();
    moveinDate.setColumns(10);
    
    term = new JTextField();
    term.setColumns(10);
    
    JLabel lblNewLabel_4 = new JLabel("unit applied");
    
    unit = new JTextField();
    unit.setColumns(10);
    
    submit = new JButton("submit");
    submit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(29)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNewLabel)
            .addComponent(lblNewLabel_1)
            .addComponent(lblNewLabel_2)
            .addComponent(lblNewLabel_3)
            .addComponent(lblNewLabel_4))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(unit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(submit))
            .addComponent(term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(income, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(40, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(38)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(income, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1)
            .addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_3)
            .addComponent(term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_4)
            .addComponent(unit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(48, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(211, Short.MAX_VALUE)
          .addComponent(submit)
          .addGap(14))
    );
    getContentPane().setLayout(groupLayout);

  }

  @Override
  public void setListener(ActionListener listener) {
    submit.addActionListener(listener);
  }
  
  @Override
  public double getIncome() {
    String str = income.getText();
    double income = Format.strToDouble(str);
    return income;
   }
  
  @Override
  public double getCredit() {
    String str = credit.getText();
    double credit = Format.strToDouble(str);
    return credit;
   }
  
  @Override
  public LocalDate getMoveinDate() {
    String str = moveinDate.getText();
    LocalDate movein = Format.strToDate(str);
    return movein;
   }
  
  @Override
  public int getTerm() {
    String str = income.getText();
    int term = Format.strToInt(str);
    return term;
   }
  
  @Override
  public String getUnitID() {
    return unit.getText();
  }
  
  
  @Override
  public void throwMessage(String str) {
    JOptionPane.showMessageDialog(null, str);
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
  
}
