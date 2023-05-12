import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.*;

//arrayList of strings is used here to store data
public class ETransfer {
  // panel features
  private JFrame frame7 = new JFrame();
  private JPanel panel7 = new JPanel();
  private JLabel EtransferLabel = new JLabel("Transfer Funds");
  private JLabel chequingBal = new JLabel("");
  private JLabel savingsBal = new JLabel("");
  private JButton send = new JButton("Send");
  private JTextField amount = new JTextField("Enter $");
  private JTextField recipient = new JTextField("Recipent");
  private JButton backET = new JButton("Back");
  private JLabel newBal = new JLabel("");

  private ArrayList<String> balance = new ArrayList<>();
  AccountDetails object = new AccountDetails();

  private double etAmount = 0;
  private String etAmountStr;

  private double ogAmount;
  private double newBalDbl;

  public ETransfer() {
    // panel
    frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame7.setSize(350, 350);
    frame7.add(panel7);
    panel7.setLayout(null);

    // user identifer
    LoginPage obj = new LoginPage();
    if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
      ReadAccFileUser1();
    } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
      ReadAccFileUser2();
    }

    // panel formating
    EtransferLabel.setBounds(100, 20, 300, 20);
    panel7.add(EtransferLabel);

    chequingBal.setBounds(15, 50, 300, 20);
    panel7.add(chequingBal);
    chequingBal.setText("Chequing Balance: " + balance.get(6));

    savingsBal.setBounds(15, 80, 300, 20);
    panel7.add(savingsBal);
    savingsBal.setText("Savings Balance: " + balance.get(7));

    backET.setBounds(15, 110, 150, 20);
    panel7.add(backET);

    amount.setBounds(15, 140, 150, 20);
    panel7.add(amount);

    recipient.setBounds(15, 170, 150, 20);
    panel7.add(recipient);

    send.setBounds(15, 200, 150, 20);
    panel7.add(send);

    newBal.setBounds(15, 230, 300, 20);
    panel7.add(newBal);

    AccountSelection obj2 = new AccountSelection();
    // button functions
    send.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        etAmountStr = amount.getText();
        etAmount = Double.parseDouble(etAmountStr);
        if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
          if (obj2.getChequing() == true) {
            ogAmount = Double.parseDouble(balance.get(6));
            newBalDbl = ogAmount - etAmount;
            balance.set(6, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(6)));
          } else if (obj2.getSavings() == true) {
            ogAmount = Double.parseDouble(balance.get(7));
            newBalDbl = ogAmount - etAmount;
            balance.set(7, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(7)));
          }
        } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
          if (obj2.getChequing() == true) {
            ogAmount = Double.parseDouble(balance.get(6));
            newBalDbl = ogAmount - etAmount;
            balance.set(6, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(6)));
          } else if (obj2.getSavings() == true) {
            ogAmount = Double.parseDouble(balance.get(7));
            newBalDbl = ogAmount - etAmount;
            balance.set(7, Double.toString(newBalDbl));
            object.setUserData(balance);
            newBal.setText("New Balance: " + (balance.get(7)));
          }
        }
      }
    });

    // back button functions
    backET.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame7.dispose();
        Menu object = new Menu();
      }
    });

    frame7.setVisible(true);

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