import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class TransactionInfo {

  private String transDate;
  private String transTime;
  private String transType;
  private String amount;
  private String accountType;

  public TransactionInfo(String transDate, String transTime, String transType, String amount, String accountType) {
    this.transDate = transDate;
    this.transTime = transTime;
    this.transType = transType;
    this.amount = amount;
    this.accountType = accountType;
  }

  public TransactionInfo() {

  }

  // getters
  public String getTransDate() {
    return this.transDate;
  }

  public String getTransTime() {
    return this.transTime;
  }

  public String getTransType() {
    return this.transType;
  }

  public String getAmount() {
    return this.amount;
  }

  public String getAccountType() {
    return this.accountType;
  }

  public static ArrayList<TransactionInfo> list = new ArrayList<TransactionInfo>();

  public static ArrayList<TransactionInfo> getData() {
    return list;
  }

  // setters
  public void setTransDate(String transDate) {
    this.transDate = transDate;
  }

  public void setTransTime(String transTime) {
    this.transTime = transTime;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  // helpers

  public double getAmountDouble() {
    String[] parts = (this.amount).split("\\$", 2);
    double amountDouble = Double.parseDouble(parts[1]);
    return amountDouble;
  }

  // toString
  public String toString() {
    return this.transDate + this.transTime + this.transType + this.amount + this.accountType;
  }

}
