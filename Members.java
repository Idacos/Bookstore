package dacostailtonproject1;

//Class to store member's information
public class Members {
   private String membersName;
   private double moneySpent;
   private boolean membership;
   private boolean monthlyFeePaid;
   private int paymentMethod;

   /**
    * Constructor for members ArrayList
    * @param name
    * @param moneySpent
    * @param membership
    * @param paidMonthlyFee
    * @param paymentMethod
    */
   public Members(String name, double moneySpent, boolean membership, boolean paidMonthlyFee, int paymentMethod)
   {
       setMembersName(name);
       setMoneySpent(moneySpent);
       setMembership(membership);
       setMonthlyFeePaid(paidMonthlyFee);
       setPaymentMethod(paymentMethod);
   }

   /**
    *Membership getter
    * @return boolean Returns membership
    */
   public boolean isMembership() {
       return membership;
   }

   /**
    * Membership setter
    * @param membership
    */
   public void setMembership(boolean membership) {
       this.membership = membership;
   }

   /**
    * MonthlyFee getter
    * @return boolean returns monthlyFeePaid
    */
   public boolean isMonthlyFeePaid() {
       return monthlyFeePaid;
   }

   /**
    * MonthlyFee setter
    * @param monthlyFeePaid
    */
   public void setMonthlyFeePaid(boolean monthlyFeePaid) {
       this.monthlyFeePaid = monthlyFeePaid;
   }

   /**
    * Getter for the member's name
    * @return String returns membersName
    */
   public String getMembersName() {
       return membersName;
   }

   /**
    * setter for the member's name
    * @param membersName
    */
   public void setMembersName(String membersName) {
       this.membersName = membersName;
   }

   /**
    * getter for the money spent
    * @return double returns moneySpent
    */
   public double getMoneySpent() {
       return moneySpent;
   }

   /**
    * setter for money spent
    * @param moneySpent
    */
   public void setMoneySpent(double moneySpent) {
       this.moneySpent = moneySpent;
   }

   /**
    * getter for payment method
    * @return int returns paymentMethod
    */
   public int getPaymentMethod() {
       return paymentMethod;
   }

   /**
    * setter for payment method
    * @param paymentMethod
    */
   public void setPaymentMethod(int paymentMethod) {
       this.paymentMethod = paymentMethod;
   }

}



