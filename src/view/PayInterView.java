package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import tool.Format;
import viewinterface.IPayInterView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PayInterView extends JInternalFrame implements IPayInterView {
  private JTextField currBalance;
  private JTextField amount;
  private JTextField aftBalance;
  private JButton confirm;
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          PayInterView frame = new PayInterView();
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
  public PayInterView() {
    setTitle("Make a payment");
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("Current balance: ");
    
    currBalance = new JTextField();
    currBalance.setColumns(10);
    
    JLabel lblNewLabel_1 = new JLabel("Payment amount: ");
    
    amount = new JTextField();
    amount.setColumns(10);
    
    confirm = new JButton("Confirm");
    confirm.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    
    JLabel lblNewLabel_2 = new JLabel("Balance after payment: ");
    
    aftBalance = new JTextField();
    aftBalance.setColumns(10);
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(41)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(lblNewLabel)
                .addComponent(lblNewLabel_1)
                .addComponent(lblNewLabel_2))
              .addPreferredGap(ComponentPlacement.RELATED)
              .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                .addComponent(amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(currBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(aftBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(154)
              .addComponent(confirm)))
          .addContainerGap(103, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(33)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(currBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1)
            .addComponent(amount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(confirm)
          .addGap(24)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(aftBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addContainerGap(70, Short.MAX_VALUE))
    );
    getContentPane().setLayout(groupLayout);

  }
  
  @Override
  public void setListener(ActionListener listener) {
    confirm.addActionListener(listener);
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
  public void setCurrBalance(double curr) {
    currBalance.setText(String.valueOf(curr));
  }
  
  @Override
  public double getAmount() {
    String amountString = amount.getText();
    double amount = Format.strToDouble(amountString); 
    return amount;
  }
  
  @Override 
  public void setAftBalance(double aft) {
    aftBalance.setText(String.valueOf(aft));
  }
}
