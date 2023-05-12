import javax.swing.*; // The package where the components are, this is the "extra" part of our project beyond what we learned in class, it is used in creating GUIs
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;

public class LoginPage {

  // panel features
  private static JLabel userLabel;
  private static JTextField userText;
  private static JLabel passwordLabel;
  private static JPasswordField passwordText;
  private static JButton button;
  private static JLabel success;

  private static String user;
  private static String password;

  public LoginPage() {

  }

  public static void LoginProcess() {

    // panel
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(panel);

    panel.setLayout(null);

    // panel formating
    userLabel = new JLabel("User");
    userLabel.setBounds(10, 20, 80, 25);
    panel.add(userLabel);

    userText = new JTextField(20);
    userText.setBounds(100, 20, 165, 25);
    panel.add(userText);

    passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(10, 50, 80, 25);
    panel.add(passwordLabel);

    passwordText = new JPasswordField();
    passwordText.setBounds(100, 50, 165, 25);
    panel.add(passwordText);

    button = new JButton("Login");
    button.setBounds(10, 80, 80, 25);

    // button function
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        user = userText.getText();
        password = passwordText.getText();

        // user identifer
        if (user.equals("Bernard_Ray") && password.equals("Password123")) {
          success.setText("Login Successful!");
          frame.dispose();
          AccountSelection accountSelection = new AccountSelection();
          accountSelection.AccountSelecting();
        } else if (user.equals("James_Smith") && password.equals("Banking123")) {
          success.setText("Login Successful!");
          frame.dispose();
          AccountSelection accountSelection = new AccountSelection();
          accountSelection.AccountSelecting();
        } else {
          success.setText("Login unsuccessful, please try again.");
        }

      }
    });

    // button function
    panel.add(button);

    success = new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);

    frame.setVisible(true);

  }

  // to get username
  public String getUser() {
    return user;
  }

  // to get password
  public String getPassword() {
    return password;
  }

}