package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import viewinterface.IApplicationStatusInterView;

public class ApplicationStatusInterView extends JInternalFrame implements IApplicationStatusInterView{
  private JTextField statusTxt;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ApplicationStatusInterView frame = new ApplicationStatusInterView();
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
  public ApplicationStatusInterView() {
    setBounds(100, 100, 450, 300);
    
    JLabel lblNewLabel = new JLabel("Application status: ");
    
    statusTxt = new JTextField();
    statusTxt.setColumns(10);
    GroupLayout groupLayout = new GroupLayout(getContentPane());
    groupLayout.setHorizontalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(55)
              .addComponent(lblNewLabel))
            .addGroup(groupLayout.createSequentialGroup()
              .addGap(144)
              .addComponent(statusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
          .addContainerGap(152, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
      groupLayout.createParallelGroup(Alignment.LEADING)
        .addGroup(groupLayout.createSequentialGroup()
          .addGap(43)
          .addComponent(lblNewLabel)
          .addGap(18)
          .addComponent(statusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
          .addContainerGap(151, Short.MAX_VALUE))
    );
    getContentPane().setLayout(groupLayout);

  }
  
  @Override
  public void setStatusTxt(String str) {
    statusTxt.setText(str);
  }
}
