/*****************************************************
 *    Title: BicycleFrame4.java
 *    Author: John Walsh
 *    Site owner/sponsor: https://mydocs.ittralee.ie
 *    Date: 2017
 *    Code version: edited Jan 10 '13 at 17:42
 *    Availability: https://mydocs.ittralee.ie/xythoswfs/webview/fileManager.action?x=y&XY_performTicketSessionBypass=true&cookieConsentSet=on&shareLogin=false&stk=00938CC0736D2E9 (Accessed 22/11/2017)
 *    Modified:  chnaged value to do with bike to book for my project
 *****************************************************/

//https://alvinalexander.com/java/joptionpane-showinputdialog-examples
package OOP2_Project_MyShop;

import javax.swing.*;

public class ComboxBoxShowInputDialogExample
{
    public static final String[] pizzas = { "Cheese", "Pepperoni", "Sausage", "Veggie" };

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Input Dialog Example 3");
        String favoritePizza = (String) JOptionPane.showInputDialog(frame,
                "What is your favorite pizza?",
                "Favorite Pizza",
                JOptionPane.QUESTION_MESSAGE,
                null,
                pizzas,
                pizzas[0]);

        // favoritePizza will be null if the user clicks Cancel
        System.out.printf("Favorite pizza is %s.\n", favoritePizza);
        System.exit(0);
    }

}