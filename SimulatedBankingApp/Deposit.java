import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

//arrayList of strings is used here to store data
public class Deposit {
  // panel components
  private JFrame frame6 = new JFrame();
  private JPanel panel6 = new JPanel();
  private JLabel depositLabel = new JLabel("Deposit Funds");
  private JLabel chequingBal = new JLabel("");
  private JLabel savingsBal = new JLabel("");
  private JButton deposit = new JButton("Deposit");
  private JTextField amount = new JTextField("Enter $");
  private JButton backD = new JButton("Back");

  private ArrayList<String> balance = new ArrayList<>();
  AccountDetails object = new AccountDetails();

  private double depAmount = 0;
  private String depAmountStr;
  private JLabel newBal = new JLabel("");
  private double ogAmount;
  private double newBalDbl;

  public Deposit() {
    // panel
    frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame6.setSize(350, 350);
    frame6.add(panel6);
    panel6.setLayout(null);

    // user identifer
    LoginPage obj = new LoginPage();
    if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
      ReadAccFileUser1();
    } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
      ReadAccFileUser2();
    }

    // panel formating
    depositLabel.setBounds(100, 20, 300, 20);
    panel6.add(depositLabel);

    chequingBal.setBounds(15, 50, 300, 20);
    panel6.add(chequingBal);
    chequingBal.setText("Chequing Balance: " + balance.get(6));

    savingsBal.setBounds(15, 80, 300, 20);
    panel6.add(savingsBal);
    savingsBal.setText("Savings Balance: " + balance.get(7));

    amount.setBounds(15, 110, 150, 20);
    panel6.add(amount);

    deposit.setBounds(15, 140, 150, 20);
    panel6.add(deposit);

    backD.setBounds(15, 170, 150, 20);
    panel6.add(backD);

    newBal.setBounds(15, 200, 170, 20);
    panel6.add(newBal);

    // button function
    AccountSelection obj2 = new AccountSelection();
    deposit.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {

        depAmountStr = amount.getText();
        depAmount = Double.parseDouble(depAmountStr);
        if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
          if (obj2.getChequing() == true) {
            ogAmount = Double.parseDouble(balance.get(6));
            newBalDbl = ogAmount + depAmount;
            balance.set(6, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(6)));
          } else if (obj2.getSavings() == true) {
            ogAmount = Double.parseDouble(balance.get(7));
            newBalDbl = ogAmount + depAmount;
            balance.set(7, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(7)));
          }
        } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
          if (obj2.getChequing() == true) {
            ogAmount = Double.parseDouble(balance.get(6));
            newBalDbl = ogAmount + depAmount;
            balance.set(6, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(6)));
          } else if (obj2.getSavings() == true) {
            ogAmount = Double.parseDouble(balance.get(7));
            newBalDbl = ogAmount + depAmount;
            balance.set(7, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(7)));
          }
        }
      }
    });

    frame6.setVisible(true);

    // back button function
    backD.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame6.dispose();
        Menu object = new Menu();
      }
    });

  }

  // import data file
  public void ReadAccFileUser1() {

    try {
      File myObj = new File("AccInfoUser.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        balance.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

  // import data file
  public void ReadAccFileUser2() {

    try {
      File myObj = new File("AccInfoUser2.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        balance.add(data);

      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

}