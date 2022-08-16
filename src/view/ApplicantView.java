package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewinterface.IApplicantView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

/**
 * This is a view of applicant
 */
public class ApplicantView extends JFrame implements IApplicantView{

  private JPanel contentPane;
  private JMenuItem status;
  private JMenuItem updateProfile;
  private JMenuItem review;
  private JDesktopPane desktopPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ApplicantView frame = new ApplicantView();
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
  public ApplicantView() {
    setTitle("Applicant");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("My application");
    menuBar.add(mnNewMenu);
    
    status = new JMenuItem("application status");
    status.setActionCommand("application status");
    
    status.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    mnNewMenu.add(status);
    
    JMenu mnNewMenu_2 = new JMenu("My profile");
    menuBar.add(mnNewMenu_2);
    
    updateProfile = new JMenuItem("update my profile");
    updateProfile.setActionCommand("update profile");
    
    updateProfile.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    mnNewMenu_2.add(updateProfile);
    
    review = new JMenuItem("review my profile");
    updateProfile.setActionCommand("review profile");
  
    review.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    mnNewMenu_2.add(review);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    desktopPane = new JDesktopPane();
    contentPane.add(desktopPane, BorderLayout.CENTER);
  }
  
  @Override
  public void setListener(ActionListener listener) {
    status.addActionListener(listener);
    updateProfile.addActionListener(listener);
    review.addActionListener(listener);
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
  public void addApplicantStatusView(ApplicationStatusInterView applicationStatusInterView) {
    desktopPane.add(applicationStatusInterView);
  }
  
  @Override
  public void addUpdateProfileInterView(UpdateProfileInterView updateProfileInterView) {
    desktopPane.add(updateProfileInterView);
  }
  
  @Override
  public void throwMessage(String str) {
    JOptionPane.showMessageDialog(null, str);
  }
}
