package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewinterface.ILogin;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements ILogin {

  private JPanel contentPane;
  private JTextField emailLogin;
  private JPasswordField passwordLogin;
  private JButton loginButton;
  private JButton signupButton;
  private JButton managerButton;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Login frame = new Login();
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
  public Login() {
    setResizable(false);
    setTitle("Apartment Rental System");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    
    JLabel lblNewLabel = new JLabel("Welcome!");
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setFont(new Font("Helvetica", Font.PLAIN, 20));
    
    JLabel lblNewLabel_1 = new JLabel("Email: ");
    
    JLabel lblNewLabel_2 = new JLabel("Password: ");
    
    emailLogin = new JTextField();
    emailLogin.setColumns(10);
    
    passwordLogin = new JPasswordField();
    
    /*JButton*/ loginButton = new JButton("log in");
    loginButton.setActionCommand("login button");//新增
    //删去了原来的JButton, sing up按钮同
    /*
    btnNewButton.addActionListener(new ActionListener() {
      //此处是增加的事件！！！
      public void actionPerformed(ActionEvent e) {
        
      }
    });
    */
    JLabel lblNewLabel_3 = new JLabel("Don't have an account yet?");
    lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 10));
    
    signupButton = new JButton("sign up");//删去原来此处的JButton
    signupButton.setActionCommand("signup button");
    signupButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
    
    managerButton = new JButton("I'm a manager");
    managerButton.setActionCommand("manager button");
    //manager的页面尚未建立
  
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addContainerGap(81, Short.MAX_VALUE)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                      .addComponent(lblNewLabel_2)
                      .addComponent(lblNewLabel_1))
                    .addGap(19)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                      .addComponent(passwordLogin)
                      .addComponent(emailLogin, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                  .addGroup(gl_contentPane.createSequentialGroup()
                    .addGap(105)
                    .addComponent(loginButton))
                  .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_contentPane.createSequentialGroup()
                  .addComponent(lblNewLabel_3)
                  .addPreferredGap(ComponentPlacement.RELATED)
                  .addComponent(signupButton)))
              .addGap(30))
            .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
              .addComponent(managerButton)
              .addContainerGap())))
    );
    gl_contentPane.setVerticalGroup(
      gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
          .addComponent(managerButton)
          .addPreferredGap(ComponentPlacement.RELATED)
          .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
          .addGap(28)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_1)
            .addComponent(emailLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addGap(26)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_2)
            .addComponent(passwordLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
          .addPreferredGap(ComponentPlacement.UNRELATED)
          .addComponent(loginButton)
          .addGap(31)
          .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
            .addComponent(lblNewLabel_3)
            .addComponent(signupButton))
          .addContainerGap(10, Short.MAX_VALUE))
    );
    contentPane.setLayout(gl_contentPane);
  }
  
  @Override
  public void setListener(ActionListener listener) {
    //System.out.println("form login 157");
    loginButton.addActionListener(listener);
    signupButton.addActionListener(listener);
    managerButton.addActionListener(listener);
  }
  
  @Override
  public String getEmail() {
    return emailLogin.getText();
  }
  
  @Override
  public String getPassword() {
    return new String(passwordLogin.getPassword());
  }
 
  @Override
  public void throwException() {
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
}

