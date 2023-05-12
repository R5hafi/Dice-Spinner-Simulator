There are no known bugs, everything works as intended except that eTransfer and deposit were not coded to add a transaction in transactions history or send money between the two dummy accounts. Otherwise, everything else works and the balance still updates in account details when the user deposits or etransfers.

Most of the classes were designed with runnable code put in the constructor so that when an instantiation of that object occurs a new window pops up, if needed otherwise a void method was put for those classes that need to transfer data to other classes (like for the LoginPage class where username and password need to be transferred, a LoginProcess void method was made).

Instructions to use our program: When run is hit, the program boots up a login portal to different banking accounts shown below

Username: Bernard_Ray
Password: Password123

Username: James_Smith
Password: Banking123

Please type the above info in the login portal in order to login.

After that a window will popup making the user choose which account type to open up, chequing or savings.

When an account type is selected the user is directed to a menu page with the options to: logout, go back to selecting there account type, check transactions history, deposit money, etransfer money, and check account details.

Logout: Directs the user back to the login portal

Back: Directs the user back to the page before.

Menu: A window with the following options; transaction history, deposit, etransfer, account details, back, and logout.

Transactions History: Directs the user to a window that shows the accounts transaction history, the user has the option to go back to the menu or sort their transactions by amount.

Deposit: Directs the user to a window where money can be deposited to the account type they selected, enter the money as a pure integer or double with no "$" signs. Once deposit is hit it will update in account details. 

Etransfer: Directs the user to a window where money can be etransferred, once again enter in money as an integer or double with no "$" character. Users balance is decremented accordingly. Etransfer was done in the place of a withdraw screen.

AccountDetails: Shows account info.

CHECKLIST: 
 - In the classes ETransfer.java and Deposit.java an arraylist of strings was used 
 - Many classes were used 
 - File IO was involved in the classes TransactionHistory.java and the 2 classes mentioned in the first point, in addition to the AccountDetails.java class
 - ArrayList of TransactionInfo objects was used in TransactionHistory.java 
 - Merge sort was used in the class TransactionHistory.java by implementing the MergeSort.java class with an arraylist of objects
 - Recursion occurs in the merge sort algorithm when it constantly divides
 - Searching occurs in merge sort
 - One cool thing we did was make use of the swing library in java to create a GUI

References were used below:
https://www.codewithc.com/online-bank-management-system-project-java/
https://replit.com/talk/learn/Java-Swing-Tutorial-Day-1-LEARN-HOW-TO-CREATE-A-GUI/46008
https://replit.com/talk/learn/Java-Swing-Tutorial-Day-2-LEARN-HOW-TO-MAKE-A-GUI/46109
https://replit.com/talk/learn/HOW-TO-MAKE-A-GUI-DAY-3-or-JAVA-SWING-or-CROSS-PLATFORM/46985
https://www.youtube.com/watch?v=iE8tZ0hn2Ws&list=WL&index=50&t=181s&ab_channel=AlexLee
https://www.youtube.com/watch?v=HgkBvwgciB4&ab_channel=BroCode
http://www.java2s.com/Tutorial/Java/0240__Swing/CreatingaMultilineLabelforaJButtonComponent.htm
https://examples.javacodegeeks.com/desktop-java/swing/jtextfield/create-read-only-non-editable-jtextfield/
https://www.geeksforgeeks.org/merge-sort/ 
//https://wisdomoverflow.com/2018/11/01/sorting-the-date-in-ascending-order-in-java/ 
https://www.withexample.com/merge-sort-using-arraylist-java-example/

