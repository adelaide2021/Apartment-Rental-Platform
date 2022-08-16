package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import viewinterface.IUpdateProfileInterView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProfileInterView extends JInternalFrame implements IUpdateProfileInterView {
  private JTextField income;
  private JTextField credit;
  private JTextField moveinDate;
  private JTextField term;
  private JButton update;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UpdateProfileInterView frame = new UpdateProfileInterView();
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
  public UpdateProfileInterView() {
    setTitle("Update my profile");
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("Annual income: ");
    
    JLabel lblNewLabel_1 = new JLabel("Credit score: ");
    
    JLabel lblNewLabel_2 = new JLabel("Move in date: ");
    
    JLabel lblNewLabel_3 = new JLabel("Term: ");
    
    income = new JTextField();
    income.setColumns(10);
    
    credit = new JTextField();
    credit.setColumns(10);
    
    moveinDate = new JTextField();
    moveinDate.setColumns(10);
    
    term = new JTextField();
    term.setColumns(10);
    
    update = new JButton("Update");
  
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(48)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(lblNewLabel)
            .addComponent(lblNewLabel_1)
            .addComponent(lblNewLabel_2)
            .addComponent(lblNewLabel_3))
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(update))
            .addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(income, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(17, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(39)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(income, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1)
            .addComponent(credit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(28)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(moveinDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_3)
            .addComponent(term, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(97, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(205, Short.MAX_VALUE)
          .addComponent(update)
          .addGap(20))
    );
    getContentPane().setLayout(groupLayout);

  }
  
  @Override
  public void setListener(ActionListener listener) {
    update.addActionListener(listener);
  }
  
  @Override
  public String getIncome() {
    return income.getText();
  }
  
  @Override
  public String getCredit() {
    return credit.getText();
  }
  
  @Override
  public String getMovein(){
   return moveinDate.getText();
  }
  
  @Override
  public String getTerm() {
    return term.getText();
  }
  
  @Override
  public void throwMessage(String str) {
    JOptionPane.showMessageDialog(null, str);
  }
 }
