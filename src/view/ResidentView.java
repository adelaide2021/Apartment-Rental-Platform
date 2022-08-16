package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import viewinterface.IResidentView;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;

public class ResidentView extends JFrame implements IResidentView {

  private JPanel contentPane;
  private JMenuItem payment;
  private JDesktopPane desktopPane;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          ResidentView frame = new ResidentView();
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
  public ResidentView() {
    setTitle("Resident");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);
    
    JMenu mnNewMenu = new JMenu("My bill");
    menuBar.add(mnNewMenu);
    
    payment = new JMenuItem("Make a payment");
    payment.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      }
    });
    mnNewMenu.add(payment);
    
    JMenu mnNewMenu_1 = new JMenu("New menu");
    menuBar.add(mnNewMenu_1);
    
    JMenu mnNewMenu_2 = new JMenu("New menu");
    menuBar.add(mnNewMenu_2);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(new BorderLayout(0, 0));
    setContentPane(contentPane);
    
    desktopPane = new JDesktopPane();
    contentPane.add(desktopPane, BorderLayout.CENTER);
  }
  
  @Override
  public void setListener(ActionListener listener) {
    payment.addActionListener(listener);
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
  public void addPayInterView(PayInterView payInterView) {
    desktopPane.add(payInterView);
  }

}
