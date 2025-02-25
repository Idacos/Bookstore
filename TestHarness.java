 package dacostailtonproject1;

import java.util.Scanner;

/**
* This program is made to emulate a book store's online system
* of managing the inventory and their members. It will allow users to
* make purchases, register as a premium member to the store, check the
* inventory of the store's products, and check the information of each
* existing member in the store's database.
*
* @author Ilton da Costa
* @since  2023-09-26
*/
public class TestHarness {

   public static void main(String args[]) {
       //variables for do while loops
       int whileCheck = 0;
       int whileCheck2 = 0;

       //scanner object
       Scanner myObj = new Scanner(System.in);

       //purchase class
       Purchase purchase = new Purchase();


       do {
           //Main menu to select function
           System.out.println("Welcome to the automated BookStore System!");
           System.out.println("Select from one of the following options: ");
           System.out.println("\t1. Make a purchase");
           System.out.println("\t2. Register a new Premium Member");
           System.out.println("\t3. Check inventory of products");
           System.out.println("\t4. Check Member status");
           System.out.println("\t5. Exit");
           int menuChoice = myObj.nextInt();

           //Switch for main menu options
           switch (menuChoice) {
               //Make purchase
               case 1:
                   boolean premiumMember = false;
                   boolean paidMemberShip = false;
                   double addNewPrice = 0.0;
                   int paymentMethod = 0;

                   do {
                       //Purchase menu and confirmation
                       System.out.println("Which of the following would you like to purchase?");
                       System.out.println("\t1. To Kill A Mockingbird by Harper Lee - $9.99 (Book)");
                       System.out.println("\t2. Charlotte's Web by E.B. White - $7.99 (Book)");
                       System.out.println("\t3. Cus I Love You by Lizzo - $7.99 (CD)");
                       System.out.println("\t4. How To Train Your Dragon - $15.99 (DVD)");
                       int purchaseChoice = myObj.nextInt();
                       purchase.makePurchase(purchaseChoice);

                       if (purchaseChoice > 0 && purchaseChoice < 5) {
                           System.out.println("You have " + purchase.purchaseTally() + " items in your cart. Are you done shopping?");
                           System.out.println("\t1. Yes");
                           System.out.println("\t2. No");
                           int continueShopping = myObj.nextInt();

                           if (continueShopping == 1) {
                               whileCheck = 1;
                               System.out.println("Your total comes to $" + purchase.totalPrice() + ".");
                               System.out.println("Please select which member is making this purchase.");
                               purchase.printMember();
                               int chooseMember = myObj.nextInt();

                               if (purchase.checkNewMember(chooseMember) == false) {
                                   purchase.addPurchaseToMember(chooseMember - 1);
                                   System.out.println("Your purchase total was: $" + purchase.totalPrice());
                                   System.out.println("Congrats on your purchase " + purchase.getMembersArray().get(chooseMember - 1).getMembersName() + "!");
                                   purchase.getPurchasesArray().removeAll(purchase.getPurchasesArray());
                               } else if (purchase.checkNewMember(chooseMember) == true) {
                                   System.out.println("Let's get you registered as a new Member!");
                                   System.out.println("Would you like to register as a free-tier or premium member?");
                                   System.out.println("\t1. Free-tier");
                                   System.out.println("\t2. Premium");
                                   int menuMemberChoice = myObj.nextInt();

                                   if (menuMemberChoice == 1) {
                                       premiumMember = false;
                                   } else if (menuMemberChoice == 2) {
                                       System.out.println("We will charge an extra $9.99 monthly for the membership, is that alright?");
                                       System.out.println("\t1. Yes");
                                       System.out.println("\t2. No");
                                       int confirmPremium = myObj.nextInt();

                                       //Confirm premium member selection
                                       if (confirmPremium == 1) {
                                           System.out.println("What payment method would you like to use?");
                                           System.out.println("\t1. Cash");
                                           System.out.println("\t2. Debit Card");
                                           System.out.println("\t3. Credit Card");
                                           System.out.println("\t4. Check");
                                           int chosenPaymentMethod = myObj.nextInt();

                                           if (chosenPaymentMethod > 0 && chosenPaymentMethod < 5) {
                                               //add membership values
                                               premiumMember = true;
                                               paidMemberShip = true;
                                               addNewPrice = 9.99;
                                           } else {
                                               System.out.println("This is not a menu choice.");
                                               System.exit(0);
                                           }
                                       } else if (confirmPremium == 2) {
                                           System.out.println("You will be a Free-tier Member.");
                                           addNewPrice = 0.0;
                                           paymentMethod = 0;

                                       } else {
                                           System.out.println("This is not a menu choice.");
                                           System.exit(0);
                                       }
                                   } else {
                                       System.out.println("This is not a menu choice.");
                                       System.exit(0);
                                   }

                                   //Enter name and add our member
                                   myObj.nextLine(); //Consume newline leftover
                                   System.out.println("Please enter your name: ");
                                   String newName = myObj.nextLine();
                                   addNewPrice = addNewPrice + purchase.totalPrice();

                                   purchase.addMember(newName, addNewPrice, premiumMember, paidMemberShip, paymentMethod);
                                   System.out.println("Your purchase total was: $" + addNewPrice);
                                   System.out.println("Congrats on your purchase " + purchase.getMembersArray().get(chooseMember - 1).getMembersName() + "!");
                                   purchase.getPurchasesArray().removeAll(purchase.getPurchasesArray());
                               }
                           } else if (continueShopping == 2) {
                               whileCheck = 0;
                           } else {
                               System.out.println("That is not a menu choice.");
                               System.exit(0);
                           }
                       }
                   } while (whileCheck == 0);
                   break;
               //Purchase premium membership
               case 2:
                   String premiumName = null;

                   System.out.println("Please choose a member: ");
                   purchase.printMember();
                   int chooseMember = myObj.nextInt();

                   //checks if user is already premium or not
                   if (purchase.checkNewMember(chooseMember) == false) {
                       premiumName = purchase.getMembersArray().get(chooseMember - 1).getMembersName();
                       System.out.println("Hello " + premiumName + "!");
                       if (purchase.getMembersArray().get(chooseMember - 1).isMembership()) {
                           System.out.println("You are already a Premium Member!");
                           System.exit(0);
                       }
                   } else if (purchase.checkNewMember(chooseMember) == true) {
                       myObj.nextLine(); //Consume newline leftover
                       System.out.println("Please enter your name: ");
                       String newName = myObj.nextLine();
                       premiumName = newName;
                   } else {
                       System.out.println("That is not a menu choice.");
                       System.exit(0);
                   }

                   //user determines payment method
                   System.out.println("Please pick which payment method you will pay with: ");
                   System.out.println("\t1. Cash");
                   System.out.println("\t2. Debit Card");
                   System.out.println("\t3. Credit Card");
                   System.out.println("\t4. Check");
                   int paymentMethodInput = myObj.nextInt();

                   if (paymentMethodInput > 0 && paymentMethodInput < 5) {
                       System.out.println("It will cost $9.99 monthly to be a Premium Member, is that okay?");
                       System.out.println("\t1. Yes");
                       System.out.println("\t2. No");
                       int confirmPayment = myObj.nextInt();

                       if (confirmPayment == 1) {
                           System.out.println("Congratulations! You are now a Premium Member!");
                           purchase.addPremiumMembership(chooseMember, premiumName, paymentMethodInput);
                       } else if (confirmPayment == 2) {
                           System.out.println("Premium Membership purchase cancelled.");
                           System.exit(0);
                       } else {
                           System.out.println("That is not a menu choice.");
                           System.exit(0);
                       }
                   }
                   break;
               //Case used to check the current inventory of our products
               case 3:
                   System.out.println("This is the current inventory of our products: \n");
                   purchase.viewShopInventory();
                   break;
               //Case used to check the information of our existing members
               case 4:
                   System.out.println("Pick which Member you wish to check the status of: ");
                   int j = 1;
                   for (int i = 0; i < purchase.getMembersArray().size(); i++) {
                       System.out.println(j + ". " + purchase.getMembersArray().get(i).getMembersName());
                       j++;
                   }
                   int chooseMemberStats = myObj.nextInt();

                   purchase.displayMemberStats(chooseMemberStats - 1);
                   break;
               //Case to exit the program
               case 5:
                   System.out.println("Exiting...");
                   System.exit(0);
                   break;
               default:
                   System.out.println("That is not a menu option.");
                   whileCheck2 = 1;
                   System.exit(0);
           }
       } while(whileCheck2 == 0);
   }
}




