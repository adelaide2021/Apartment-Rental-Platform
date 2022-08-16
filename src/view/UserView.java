package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.UserService;
import viewinterface.IUserView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class UserView extends JFrame implements IUserView {

  private JPanel contentPane;
  private JDesktopPane desktopPane = null;//是否此处就需要实例化？
  private JMenuItem searchApt;
  private JMenuItem startApply;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          UserView frame = new UserView();
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
  public UserView() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("Find my next apartment");
    menuBar.add(mnNewMenu);
    
    searchApt = new JMenuItem("search available apartments");
    searchApt.setActionCommand("search apt");

    mnNewMenu.add(searchApt);
    
    startApply = new JMenuItem("start my application");
    startApply.setActionCommand("start apl");
    
    mnNewMenu.add(startApply);
    
    JMenu mnNewMenu_2 = new JMenu("My account");
    menuBar.add(mnNewMenu_2);
    
    JMenuItem mntmNewMenuItem_3 = new JMenuItem("update my account");
    mnNewMenu_2.add(mntmNewMenuItem_3);
    
    JMenu mnNewMenu_1 = new JMenu("About us");
    menuBar.add(mnNewMenu_1);
    
    JMenuItem mntmNewMenuItem_2 = new JMenuItem("our story");
    mnNewMenu_1.add(mntmNewMenuItem_2);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    desktopPane = new JDesktopPane();//此处是否需要删去？已经实例化desktopPane
    contentPane.add(desktopPane, BorderLayout.CENTER);
  }
  
  @Override
  public void setListener(ActionListener listener) {
    searchApt.addActionListener(listener);
    startApply.addActionListener(listener);
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
  public void openFindAptInterView() {
    //这里似乎有点问题，new了两次findaptinterview
    FindAptInterView findAptInterView = new FindAptInterView();
    findAptInterView.setVisible(true);
    desktopPane.add(findAptInterView);
  }
  
  @Override
  public void openStartApplicationView() {
    StartApplicationView startApplicationView = new StartApplicationView(); 
    startApplicationView.setVisible(true);
    desktopPane.add(startApplicationView);
  }
    
}
