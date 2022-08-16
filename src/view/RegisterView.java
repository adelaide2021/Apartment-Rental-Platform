package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import viewinterface.IRegisterView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterView extends JFrame implements IRegisterView {

  private JPanel contentPane;
  private JTextField firstname;
  private JTextField lastname;
  private JTextField email;
  private JPasswordField password;
  private JButton registerButton;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          RegisterView frame = new RegisterView();
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
  public RegisterView() {
    setTitle("Register");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblNewLabel = new JLabel("Please fill in the following information: ");
    
    JLabel lblNewLabel_1 = new JLabel("First Name: ");
    
    JLabel lblNewLabel_2 = new JLabel("Last Name: ");
    
    JLabel lblNewLabel_3 = new JLabel("Email: ");
    
    JLabel lblNewLabel_4 = new JLabel("Password: ");
    
    firstname = new JTextField();
    firstname.setColumns(10);
    
    lastname = new JTextField();
    lastname.setColumns(10);
    
    email = new JTextField();
    email.setColumns(10);
    
    password = new JPasswordField();
    
    registerButton = new JButton("register");
    registerButton.setActionCommand("register button");
    

    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
              .addContainerGap()
              .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
            .addGroup(gl_contentPane.createSequentialGroup()
              .addGap(40)
              .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblNewLabel_1)
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addComponent(firstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblNewLabel_4)
                  .addGap(18)
                  .addComponent(password))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(lblNewLabel_2)
                    .addComponent(lblNewLabel_3))
                  .addPreferredGap(ComponentPlacement.UNRELATED)
                  .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                    .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
          .addContainerGap(146, Short.MAX_VALUE))
        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
          .addContainerGap(291, Short.MAX_VALUE)
          .addComponent(registerButton)
          .addGap(32))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addGap(15)
          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1)
            .addComponent(firstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(lastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_3)
            .addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(18)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_4)
            .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(registerButton)
          .addContainerGap(18, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
  
  @Override
  public void setListener(ActionListener listener) {
    registerButton.addActionListener(listener);
  }
  
  @Override
  public String getEmail() {
    return email.getText();
  }
  
  @Override
  public String getFirstName() {
    return firstname.getText();
  }
  
  @Override
  public String getLastName() {
    return lastname.getText();
  }
  
  @Override
  public String getPassword() {
    return new String(password.getPassword());
  }
 
  @Override
  public void throwException(String string) {
    JOptionPane.showMessageDialog(null, string);
  }
  
  @Override
  public void display(boolean value) {
    setVisible(value);
  }
  
 
  
 
}
