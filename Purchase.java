package dacostailtonproject1;

import java.util.ArrayList;

//Class to handle purchasing items in the bookstore and handling the information involved with that
public class Purchase {
   private ArrayList<Double> purchasesArray = new ArrayList<Double>();
   private static int nextPurchasesArray = 0;
   private ArrayList<Members> membersArray = new ArrayList<Members>();
   private ArrayList<Inventory> shopInventory = new ArrayList<Inventory>();

   //Constructor to hold and set existing members and products
   public Purchase()
   {
       Members member1 = new Members("Steve", 17.98, true, true, 2);
       Members member2 = new Members("Jessica", 25.98, true, true, 1);
       Members member3 = new Members("Jake", 0, false, false, 0);
       membersArray.add(member1);
       membersArray.add(member2);
       membersArray.add(member3);

       Inventory product1 = new Inventory("To Kill A Mockingbird by Harper Lee",30, "Book");
       Inventory product2 = new Inventory("Charlotte's Web by E.B. White", 25, "Book");
       Inventory product3 = new Inventory("Cus I Love You by Lizzo", 20, "CD");
       Inventory product4 = new Inventory("How To Train Your Dragon", 32, "DVD");
       shopInventory.add(product1);
       shopInventory.add(product2);
       shopInventory.add(product3);
       shopInventory.add(product4);
   }

   /**
    * Method to update amount of purchases
    */
   private static void updatePurchasesArray()
   {
       nextPurchasesArray++;
   }

   /**
    * Getter for the shop inventory ArrayList
    * @return ArrayList<Inventory> returns shopInventory
    */
   public ArrayList<Inventory> getShopInventory() {
       return shopInventory;
   }

   /**
    * Getter for the purchases ArrayList
    * @return ArrayList<Double> returns purchasesArray
    */
   public ArrayList<Double> getPurchasesArray() {
       return purchasesArray;
   }

   /**
    * Getter for the members ArrayList
    * @return ArrayList<Members> returns membersArray
    */
   public ArrayList<Members> getMembersArray() {
       return membersArray;
   }

   /**
    * This method sets the price and determines
    * which product the user will get based
    * on their input while removing the item
    * from the store's inventory.
    * @param purchaseChoice
    */
   public void makePurchase(int purchaseChoice)
   {
       //product prices
       double mockingbird = 9.99;
       double charlotte = 7.99;
       double lizzo = 7.99;
       double trainDragon = 15.99;
       int productInv = 0;

       //adds book prices to array
       switch (purchaseChoice) {
           case 1:
               purchasesArray.add(mockingbird);
               updatePurchasesArray();
               productInv = shopInventory.get(0).getProductAmount() - 1;
               shopInventory.get(0).setProductAmount(productInv);
               break;
           case 2:
               purchasesArray.add(charlotte);
               updatePurchasesArray();
               productInv = shopInventory.get(1).getProductAmount() - 1;
               shopInventory.get(1).setProductAmount(productInv);
               break;
           case 3:
               purchasesArray.add(lizzo);
               updatePurchasesArray();
               productInv = shopInventory.get(2).getProductAmount() - 1;
               shopInventory.get(2).setProductAmount(productInv);
               break;
           case 4:
               purchasesArray.add(trainDragon);
               updatePurchasesArray();
               productInv = shopInventory.get(3).getProductAmount() - 1;
               shopInventory.get(3).setProductAmount(productInv);
               break;
           default:
               System.out.println("That is not a menu choice.");
               System.exit(0);
       }
   }

   /**
    * Tally to keep track of store purchases
    * @return int returns tally
    */
   public int purchaseTally()
   {
       int tally = 0;

       for (int i = 0; i < purchasesArray.size(); i++)
       {
           tally++;
       }
       return tally;
   }

   /**
    * Takes each value added in the purchases
    * ArrayList and adds them all together to
    * get a total price for the user.
    * @return
    */
   public double totalPrice()
   {
       double total = 0;
       for(int i = 0; i < purchasesArray.size(); i++)
       {
            total = total + purchasesArray.get(i);
       }
       return total;
   }

   /**
    * A method to add a new member and all
    * needed information to make them a member.
    * @param name
    * @param moneySpent
    * @param membership
    * @param membershipPaid
    * @param paymentMethod
    */
   public void addMember(String name, double moneySpent, boolean membership, boolean membershipPaid, int paymentMethod)
   {
       Members theMember = new Members(name, moneySpent, membership, membershipPaid, paymentMethod);
       membersArray.add(theMember);
       updatePurchasesArray();
   }

   /**
    * Method for adding the money the member
    * has already spent while adding on their
    * current purchase.
    * @param memberChoice
    */
   public void addPurchaseToMember(int memberChoice)
   {
       double moneyAlreadySpent;
       moneyAlreadySpent = membersArray.get(memberChoice).getMoneySpent();
       double totalMoneySpent = moneyAlreadySpent + totalPrice();
       membersArray.get(memberChoice).setMoneySpent(totalMoneySpent);
   }

   //This method is used to print the members based on how many exist
   public void printMember()
   {
       int j = 1;
       for (int i = 0; i < membersArray.size(); i++)
       {
           System.out.println(j + ". " + membersArray.get(i).getMembersName());
           j++;
           if (i + 1 == membersArray.size())
           {
               System.out.println(j + ". Register a new Member");
           }
       }
   }

   /**
    * This method is used to check if the
    * member chosen is new or existing.
    * @param memberChoice
    * @return boolean returns true or false depending on if the member exists or not
    */
   public boolean checkNewMember(int memberChoice)
   {
       if (memberChoice - 1 < membersArray.size())
       {
           return false;
       }
       return true;
   }

   /**
    * Method to add the proper information for the user
    * who is becoming a new premium membership.
    * @param chosenMember
    * @param name
    * @param paymentMethod
    */
   public void addPremiumMembership(int chosenMember, String name, int paymentMethod)
   {
       boolean containsName = false;
       
       for (int i = 0; i < membersArray.size(); i++)
       {
           if(membersArray.get(i).getMembersName().equals(name))
           {
               containsName = true;
           }
       }
       if (containsName = true)
       {
           double amountSpent = membersArray.get(chosenMember - 1).getMoneySpent();
           amountSpent = amountSpent + 9.99;

           membersArray.get(chosenMember - 1).setMoneySpent(amountSpent);
           membersArray.get(chosenMember - 1).setMembership(true);
           membersArray.get(chosenMember - 1).setMonthlyFeePaid(true);
           membersArray.get(chosenMember - 1).setPaymentMethod(paymentMethod);
       }
       else
       {
           addMember(name, 9.99, true, true, paymentMethod);
       }
   }

   //method to print out the shop's current inventory
   public void viewShopInventory()
   {
       for (int i = 0; i < shopInventory.size(); i++)
       {
           System.out.println("Name: " + shopInventory.get(i).getProductName());
           System.out.println("Item Type: " + shopInventory.get(i).getProductType());
           System.out.println("Amount: " + shopInventory.get(i).getProductAmount());
           System.out.println();
       }
   }

   /**
    *Method to convert the chosen payment
    * method into the proper string and print
    * out the member's information.
    * @param memberNumber
    */
   public void displayMemberStats(int memberNumber)
   {
       String paymentString = null;
       switch (membersArray.get(memberNumber).getPaymentMethod())
       {
           case 1:
               paymentString = "Cash";
               break;
           case 2:
               paymentString = "Debit Card";
               break;
           case 3:
               paymentString = "Credit Card";
               break;
           case 4:
               paymentString = "Check";
               break;
           default:
               paymentString = "Not a Premium Member";
       }

       System.out.println("Member Stats: ");
       System.out.println("\tName: " + membersArray.get(memberNumber).getMembersName());
       System.out.println("\tMoney Spent: $" + membersArray.get(memberNumber).getMoneySpent());
       System.out.println("\tIs Premium Member: " + membersArray.get(memberNumber).isMembership());
       System.out.println("\tIs Monthly Fee Paid: " + membersArray.get(memberNumber).isMonthlyFeePaid());
       System.out.println("\tPayment Method: " + paymentString);
   }
}


