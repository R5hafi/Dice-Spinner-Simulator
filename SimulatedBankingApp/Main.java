/*Name: Lucas Pinto/Ryan Shafi

Program Name: Culminating Project

Program Description: Simple online banking system, including a login, transaction history and functionality to deposit and transfer funds.

Creation Date: 5 December 2022

Ethics Declaration: “This code is my own work”*/

import java.util.*;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;

//many classes were done in addition to main

public class Main {

  public static void main(String[] args) {

    // call on login class
    LoginPage loginPage = new LoginPage();
    loginPage.LoginProcess();

  }

}
