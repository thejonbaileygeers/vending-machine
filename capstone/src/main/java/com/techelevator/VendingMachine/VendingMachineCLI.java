package com.techelevator.VendingMachine;

import java.math.BigDecimal;
import java.util.*;

public class VendingMachineCLI {
    // Main
    private final Scanner userSelection = new Scanner(System.in); // Initialized scanner to read from csv
    private Inventory stockInventory = new Inventory(); // Declared instance of Inventory
    private Inventory vendingItems = new Inventory(); // Declared instance of Inventory **NOT USED**
    private Money cashBox = new Money(); // Declared instance of money


    public static void main(String[] args) {
        VendingMachineCLI cli = new VendingMachineCLI();
        cli.run();
    }

    public void run() {  // Method used to run the application
        stockInventory.stockMachine(); // Called method from Inventory to stock vending machine
        String selectionOne = "1";
        String selectionTwo = "2";
        String selectionThree = "3";
        // Declared variables to be used within the first while loop

        while (true) { // Initialized a while loop that continues while statements remain true
        System.out.println("******************************************");
        System.out.println("******WELCOME TO OUR VENDING MACHINE******");
        System.out.println("******************************************");
        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        // Main menu display

            try { // Defines the following blocks of code
                String userInput = userSelection.nextLine(); // Instance of scanner that will define code entry into block
                if (userInput.equals(selectionOne)) {
                    System.out.println("******************************************");
                    System.out.println("********CURRENT PRODUCTS AVAILABLE********");
                    System.out.println("******************************************");
                    for (String displayedProduct : stockInventory.getVendingDisplay()) { // for each that loops through the getter of each item in list
                        System.out.printf("%s\n", displayedProduct);
                    }

                } else if (userInput.equals(selectionTwo)) { // calls the purchaseMenu method
                    purchaseMenu();

                } else if (userInput.equals(selectionThree)) { // Exits program
                    System.out.println("********THANK YOU FOR VISITING********");
                    break;

                }

            } catch (IllegalArgumentException e) {
                System.out.println("Selection not found.");

            }
        }
    }

    public void purchaseMenu() { // PurchaseMenu method **SHOULD BE IN PURCHASABLES CLASS**

            String feedMoneyOp = "1";
            String productSelect = "2";
            String finishTrxSelect = "3";
            String selectedItem = "Empty";
            // Declared and Initialized variables for users input

        while (true) { // Initialized while loop for purchaseMenu method
            System.out.println("********PLEASE MAKE A SELECTION********");
            System.out.println("Current balance: $" + cashBox.getBalance());
            System.out.println("Current selected item: " + selectedItem);
            System.out.println("(1) Feed Money");
            System.out.println("(2) Select product");
            System.out.println("(3) Finish Transaction");
            String secondUserInput = userSelection.nextLine(); // Declared variable for UserInput
            if (secondUserInput.equals(feedMoneyOp)) { // User selection string value of 1 **SHOULD BE WITHIN A TRY-CATCH**
                System.out.println("Please insert money.");
                String insertedMoney = userSelection.nextLine();
                BigDecimal enteredMoney = new BigDecimal(insertedMoney);
                cashBox.insertCash(enteredMoney);

            } else if (secondUserInput.equals(productSelect)) { // User selection string value of 2
                System.out.println("*********SELECT A PRODUCT**********");
                for (String displayedProduct : stockInventory.getVendingDisplay()) {
                    System.out.printf("%s\n", displayedProduct); // loops through stocked inventory list **ITTERATE THROUGH LIST ASSIGNING PURCHASABLES AS THE VALUE AND LOCATION AS KEY**
                }
                System.out.println("Type key format and location: ");


                Map<String, String> productsDisplayed = new TreeMap<>(); // TreeMap for ordered item display with location as key
                productsDisplayed.put("A1", "A1|Potato Crisps|3.05|Chip");
                productsDisplayed.put("A2", "A2|Stackers|1.45|Chip");
                productsDisplayed.put("A3", "A3|Grain Waves|2.75|Chip");
                productsDisplayed.put("A4", "A3|Grain Waves|2.75|Chip");
                productsDisplayed.put("B1", "B1|Moonpie|1.80|Candy");
                productsDisplayed.put("B2", "B2|Cowtales|1.50|Candy");
                productsDisplayed.put("B3", "B3|Wonka Bar|1.50|Candy");
                productsDisplayed.put("B4", "B4|Crunchie|1.75|Candy");
                productsDisplayed.put("C1", "C1|Cola|1.25|Drink");
                productsDisplayed.put("C2", "C2|Dr. Salt|1.50|Drink");
                productsDisplayed.put("C3", "C3|Mountain Melter|1.50|Drink");
                productsDisplayed.put("C4", "C4|Heavy|1.50|Drink");
                productsDisplayed.put("D1", "D1|U-Chews|0.85|Gum");
                productsDisplayed.put("D2", "D2|Little League Chew|0.95|Gum");
                productsDisplayed.put("D3", "D3|Chiclets|0.75|Gum");
                productsDisplayed.put("D4", "D4|Triplemint|0.75|Gum");

                String keyedLocation = userSelection.nextLine();
                selectedItem = productsDisplayed.get(keyedLocation);  // returning value from key location


            } else if (secondUserInput.equals(finishTrxSelect)) { // User
                String[] itemDetails = selectedItem.split("\\|");
                BigDecimal selectedItemCost =  new BigDecimal(itemDetails[2]);
                final String dispenseItem = itemDetails[3];

                final String dispenseChip = "Chip";
                final String dispenseCandy = "Candy";
                final String dispenseDrink = "Drink";
                final String dispenseGum = "Gum";

                if (dispenseItem.equals(dispenseChip)) {
                    cashBox.equals("0.00");
                    System.out.println("Crunch, Crunch, Yum!");
                } else if (dispenseItem.equals(dispenseCandy)) {
                    cashBox.equals("0.00");
                    System.out.println("Munch, Munch, Yum!");
                } else if (dispenseItem.equals(dispenseDrink)) {
                    cashBox.equals("0.00");
                    System.out.println("Glug, Glug, Yum!");
                } else if (dispenseItem.equals(dispenseGum)) {
                    cashBox.equals("0.00");
                    System.out.println("Chew, Chew, Yum!");
                }


                BigDecimal quarter = new BigDecimal("0.25");
                BigDecimal dime = new BigDecimal("0.10");
                BigDecimal nickel = new BigDecimal("0.05");

                BigDecimal customerChange = new BigDecimal(String.valueOf(selectedItemCost));
                System.out.println("Your change is $" + customerChange);


//                BigDecimal theDivision = customerChange.divide(quarter);
//                BigDecimal theResult = customerChange.remainder(quarter);

                BigDecimal[] cashboxRemainder = customerChange.divideAndRemainder(quarter);
                BigDecimal numberOfQuarters = cashboxRemainder[0];

                System.out.println(numberOfQuarters + " quarter(s)");

                BigDecimal anythingButQuarters = cashboxRemainder[1];
                BigDecimal[] numberOfDimes = anythingButQuarters.divideAndRemainder(dime);
                BigDecimal numberOfDimesToReturn = numberOfDimes[0];
                System.out.println(numberOfDimesToReturn + " dime(s)");

                BigDecimal anythingButDimes = numberOfDimes[1];
                BigDecimal[] numberOfNickels = anythingButDimes.divideAndRemainder(nickel);
                BigDecimal numberOfNickelsToReturn = numberOfNickels[0];
                System.out.println(numberOfNickelsToReturn + " nickel(s)");

                break;

            } else {
                System.out.println("Invalid Entry");
                break;
            }
        }

    }

}


//    public void selectProducts() {
//
//    }
//
//
//    public void displayEnterMoneyMessage() {
//
//    }
//
//
//    public void displayChangeMessage() {
//
//    }


//	String userEnteredMoney = scanner.nextLine();
//	int[] enteredMoney = {};