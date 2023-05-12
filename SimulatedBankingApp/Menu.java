import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*; // For fonts
import java.awt.*;

public class Menu {

  // panel features
  private JFrame frame3 = new JFrame();
  private JPanel panel3 = new JPanel();
  private JLabel eBanking = new JLabel("EBanking");
  private JButton transHistory = new JButton("<html>" + "Transaction" + "<br>" + "History" + "</html>");
  private JButton eTransfer = new JButton("E-Transfer");
  private JButton deposit = new JButton("Deposit");
  private JButton accountInfo = new JButton("<html>" + "Account" + "<br>" + "Information" + "</html>");
  private JButton backMenu = new JButton("Back");
  private JButton logout = new JButton("Logout");

  public Menu() {

    // panel
    frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame3.setSize(350, 200);
    frame3.add(panel3);
    panel3.setLayout(null);

    // panel formating
    eBanking.setBounds(130, 50, 250, 20);
    panel3.add(eBanking);

    transHistory.setBounds(5, 80, 120, 35);
    panel3.add(transHistory);

    // button function
    transHistory.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent g) {

        frame3.dispose();
        TransactionHistory tHist = new TransactionHistory();

      }
    });

    // panel formating
    eTransfer.setBounds(205, 80, 120, 35);
    panel3.add(eTransfer);

    // button function
    eTransfer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent h) {

        frame3.dispose();
        ETransfer eTrans = new ETransfer();

      }
    });

    // panel formating
    deposit.setBounds(5, 120, 120, 35);
    panel3.add(deposit);

    // button function
    deposit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent i) {

        frame3.dispose();
        Deposit dep = new Deposit();

      }
    });

    // panel formating
    accountInfo.setBounds(205, 120, 120, 35);
    panel3.add(accountInfo);

    // button function
    accountInfo.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent j) {

        frame3.dispose();
        AccountDetails accDets = new AccountDetails();
        accDets.AccountDetailsProcess();

      }
    });

    // panel formating
    backMenu.setBounds(130, 120, 70, 30);
    panel3.add(backMenu);

    // button function
    backMenu.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent k) {

        frame3.dispose();
        AccountSelection accSelection = new AccountSelection();
        accSelection.AccountSelecting();

      }
    });

    // panel formating
    logout.setBounds(260, 10, 90, 15);
    panel3.add(logout);

    // button function
    logout.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent k) {

        frame3.dispose();
        LoginPage loginPage = new LoginPage();
        loginPage.LoginProcess();

      }
    });
    frame3.setVisible(true);

  }
}