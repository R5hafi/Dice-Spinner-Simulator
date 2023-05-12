import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

//arrayList of objects TransactionInfo is done here, and file IO is also used here
//merge sort is our searching and sorting part of the project, it also makes use of recursion
public class TransactionHistory {

  // panel components
  private JLabel tHistory = new JLabel("Transaction History");
  private JButton backTH = new JButton("Back");
  private JButton sortByAmount = new JButton("Sort By Amount");
  private JTextArea allTrans = new JTextArea("");
  private ArrayList<TransactionInfo> records = new ArrayList<TransactionInfo>();

  // panel formating
  public TransactionHistory() {
    JFrame frame4 = new JFrame();
    JPanel panel4 = new JPanel();
    frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame4.setSize(450, 450);
    frame4.add(panel4);
    panel4.setLayout(null);

    tHistory.setBounds(130, 50, 250, 20);
    panel4.add(tHistory);

    backTH.setBounds(10, 80, 120, 35);
    panel4.add(backTH);

    allTrans.setBounds(10, 160, 400, 300);
    panel4.add(allTrans);
    allTrans.setEditable(false);

    // user identifier
    LoginPage obj = new LoginPage();
    AccountSelection obj2 = new AccountSelection();
    MergeSort ms = new MergeSort(records);
    if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
      FileToList("TransUser.txt");
      if (obj2.getChequing() == true) {
        allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");
        for (TransactionInfo i : ms.getSortedArray()) {
          if ((i.toString()).contains("chequing") == true) {
            allTrans.append(i.toString() + "\n");
          }
        }
      } else if (obj2.getSavings() == true) {
        allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");
        for (TransactionInfo i : ms.getSortedArray()) {
          if ((i.toString()).contains("savings") == true) {
            allTrans.append(i.toString() + "\n");
          }
        }
      }
    } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
      FileToList("TransUser2.txt");
      if (obj2.getChequing() == true) {
        allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");
        for (TransactionInfo i : ms.getSortedArray()) {
          if ((i.toString()).contains("chequing") == true) {
            allTrans.append(i.toString() + "\n");
          }
        }
      } else if (obj2.getSavings() == true) {
        allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");
        for (TransactionInfo i : ms.getSortedArray()) {
          if ((i.toString()).contains("savings") == true) {
            allTrans.append(i.toString() + "\n");
          }
        }
      }
    }

    // back button functionality
    backTH.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        allTrans.setText("");
        frame4.dispose();
        Menu object = new Menu();

      }
    });

    sortByAmount.setBounds(10, 120, 150, 35);
    panel4.add(sortByAmount);

    sortByAmount.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        // Print out the sorted list

        ms.sortGivenArray();

        allTrans.setText(" ");
        allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");

        if (obj.getUser().equals("Bernard_Ray") && obj.getPassword().equals("Password123")) {
          if (obj2.getChequing() == true) {
            for (TransactionInfo i : ms.getSortedArray()) {
              if ((i.toString()).contains("chequing") == true) {
                allTrans.append(i.toString() + "\n");
              }
            }
          } else if (obj2.getSavings() == true) {
            for (TransactionInfo i : ms.getSortedArray()) {
              if ((i.toString()).contains("savings") == true) {
                allTrans.append(i.toString() + "\n");
              }
            }
          }
        } else if (obj.getUser().equals("James_Smith") && obj.getPassword().equals("Banking123")) {
          if (obj2.getChequing() == true) {
            for (TransactionInfo i : ms.getSortedArray()) {
              if ((i.toString()).contains("chequing") == true) {
                allTrans.append(i.toString() + "\n");
              }
            }
          } else if (obj2.getSavings() == true) {
            for (TransactionInfo i : ms.getSortedArray()) {
              if ((i.toString()).contains("savings") == true) {
                allTrans.append(i.toString() + "\n");
              }
            }
          }
        }

      }
    });

    frame4.setVisible(true);
  }

  public void ReadFileUserChequing1() {

    // import user data file
    try {
      File myObj = new File("TransUser.txt");
      Scanner myReader = new Scanner(myObj);
      allTrans.append("Date(d/m/y)    Time(24hr)  Transaction  Amount  Account\n\n");
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if (data.contains("chequing") == true) {
          allTrans.append(data + "\n");
        }
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

  }

  // file reader
  public void FileToList(String nameOfFile) {
    String fileName = nameOfFile;
    try {
      File myFile = new File(fileName);
      Scanner myFileReader = new Scanner(myFile);

      if (myFileReader.hasNext() == true) {
        System.out.println("\n\nFile name: " + myFile.getName() + " is now open.");
        System.out.println("File size in bytes " + myFile.length());
        System.out.println("There is data to read in this file\n");
      }

      // sort
      while (myFileReader.hasNextLine()) {
        String line = myFileReader.nextLine();
        String[] data = line.split("!", 5);
        if (data.length == 5) {
          String transDate = data[0];
          String transTime = data[1];
          String transType = data[2];
          String amount = data[3];
          String accountType = data[4];

          TransactionInfo object = new TransactionInfo(transDate, transTime, transType, amount, accountType);
          // this object is automatically added to the list
          records.add(object);
        }

      }

      myFileReader.close();

    } catch (FileNotFoundException e) {

      System.out.println("ERROR:");
      System.out.println("Your file: " + fileName + " does not exist.");
      e.printStackTrace();

    }
  }

}
