import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;

public class AccountSelection {
  // panel features
  private JFrame frame2 = new JFrame();
  private JLabel account = new JLabel("Choose Account");
  private JButton chequing = new JButton("Chequing");
  private JButton savings = new JButton("Savings");
  private JPanel panel2 = new JPanel();
  private static boolean chequingAccount;
  private static boolean savingsAccount;

  public AccountSelection() {

  }

  public void AccountSelecting() {

    // panel formating
    chequingAccount = false;
    savingsAccount = false;
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setSize(350, 200);
    frame2.add(panel2);
    panel2.setLayout(null);
    account.setBounds(110, 50, 250, 10);
    panel2.add(account);
    chequing.setBounds(10, 80, 120, 25);
    panel2.add(chequing);
    savings.setBounds(200, 80, 120, 25);
    panel2.add(savings);

    // button function
    chequing.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent f) {
        frame2.dispose();
        chequingAccount = true;
        // System.out.println(chequingAccount);
        Menu menu = new Menu();
      }
    });

    // button method
    savings.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent f) {
        frame2.dispose();
        savingsAccount = true;
        Menu menu = new Menu();
      }
    });

    frame2.setVisible(true);
  }

  // getters
  public boolean getChequing() {
    return chequingAccount;
  }

  public boolean getSavings() {
    return savingsAccount;
  }
}