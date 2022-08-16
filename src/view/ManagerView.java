package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewinterface.IManagerView;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class ManagerView extends JFrame implements IManagerView{

  private JPanel contentPane;
  private JMenuItem reviewApplication;
  private JDesktopPane desktopPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ManagerView frame = new ManagerView();
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
  public ManagerView() {
    setTitle("Manager");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("New menu");
    menuBar.add(mnNewMenu);
    
    JMenuItem reviewApplication = new JMenuItem("review application");
    reviewApplication.setActionCommand("review application");
    
    reviewApplication.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
    mnNewMenu.add(reviewApplication);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(new BorderLayout(0, 0));
    
    desktopPane = new JDesktopPane();
    contentPane.add(desktopPane);
  }
  
  @Override
  public void addReviewApplicationInterView(ReviewApplicationInterView reviewApplicationInterView) {
    desktopPane.add(reviewApplicationInterView);
  }
}
