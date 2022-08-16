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

import viewinterface.IReviewApplicationInterView;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewApplicationInterView extends JInternalFrame implements IReviewApplicationInterView{
  private JTextField applicantEmail;
  private JTextField applicantInformation;
  private JButton refuseButton;
  private JButton approveButton;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ReviewApplicationInterView frame = new ReviewApplicationInterView();
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
  public ReviewApplicationInterView() {
    setTitle("Review application");
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("Applicant email: ");
    
    applicantEmail = new JTextField();
    applicantEmail.setColumns(10);
    
    applicantInformation = new JTextField();
    applicantInformation.setColumns(10);
    
    JButton refuseButton = new JButton("refuse");
  
    
    JButton approveButton = new JButton("approve");
   
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(26)
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addComponent(applicantInformation, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
            .addGroup(groupLayout.createSequentialGroup()
              .addComponent(lblNewLabel)
              .addPreferredGap(ComponentPlacement.RELATED)
              .addComponent(applicantEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(31, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
          .addContainerGap(112, Short.MAX_VALUE)
          .addComponent(refuseButton)
          .addGap(50)
          .addComponent(approveButton)
          .addGap(87))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(20)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel)
            .addComponent(applicantEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(applicantInformation, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            .addComponent(refuseButton)
            .addComponent(approveButton))
          .addContainerGap(62, Short.MAX_VALUE))
    );
    getContentPane().setLayout(groupLayout);

  }
  
  @Override
  public void setListener(ActionListener listener) {
    refuseButton.addActionListener(listener);
    approveButton.addActionListener(listener);
  }
  
  @Override
  public String getEmail() {
    return applicantEmail.getText();
  }
  
  @Override
  public void setInformation(String str) {
    applicantInformation.setText(str);
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
