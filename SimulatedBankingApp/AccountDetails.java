import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException;

//arrayList of strings is used here to store data
public class AccountDetails {

  // panel components
  private JFrame frame5 = new JFrame();
  private JPanel panel5 = new JPanel();
  private JLabel details = new JLabel("Account Details");
  private JLabel name = new JLabel("");
  private JLabel birthday = new JLabel("");
  private JLabel address = new JLabel("");
  private JLabel securityNum = new JLabel("");
  private JLabel accountDate = new JLabel("");
  private JLabel chequingBal = new JLabel("");
  private JLabel savingsBal = new JLabel("");
  private JButton backAD = new JButton("Back");
  public static ArrayList<String> userData = new ArrayList<>();

  public AccountDetails(ArrayList<String> userData) {
    this.userData = userData;
  }

  public AccountDetails() {

  }

  public void AccountDetailsProcess() {
    // panel
    frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame5.setSize(350, 300);
    frame5.add(panel5);
    panel5.setLayout(null);

    // user identifer
    LoginPage obj = new LoginPage();
    if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
      ReadAccFileUser1();
    } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
      ReadAccFileUser2();
    }

    // panel formating
    details.setBounds(20, 10, 250, 25);
    panel5.add(details);

    name.setBounds(20, 30, 250, 25);
    panel5.add(name);
    name.setText("Name: " + userData.get(0));

    birthday.setBounds(20, 50, 250, 25);
    panel5.add(birthday);
    birthday.setText("Birthday: " + userData.get(2));

    address.setBounds(20, 70, 250, 25);
    panel5.add(address);
    address.setText("Address: " + userData.get(3));

    securityNum.setBounds(20, 90, 250, 25);
    panel5.add(securityNum);
    securityNum.setText("Security Number: " + userData.get(4));

    accountDate.setBounds(20, 110, 250, 25);
    panel5.add(accountDate);
    accountDate.setText("Account Creation Date: " + userData.get(5));

    chequingBal.setBounds(20, 130, 250, 25);
    panel5.add(chequingBal);
    chequingBal.setText("Chequing Balance: " + userData.get(6));

    savingsBal.setBounds(20, 150, 250, 25);
    panel5.add(savingsBal);
    savingsBal.setText("Savings Balance: " + userData.get(7));

    backAD.setBounds(20, 190, 120, 25);
    panel5.add(backAD);

    // back button function
    backAD.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        frame5.dispose();
        Menu object = new Menu();
      }
    });

    frame5.setVisible(true);
  }

  // getters
  public ArrayList<String> getUserData() {
    return this.userData;
  }

  public void setUserData(ArrayList<String> userData) {
    this.userData = userData;
  }

  // import data file
  public void ReadAccFileUser1() {

    try {
      File myObj = new File("AccInfoUser.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        userData.add(data);
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
        userData.add(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

}