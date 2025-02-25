package dacostailtonproject1;

//Class that stores the information regarding the inventory of the bookstore
public class Inventory {
   private String productName;
   private int productAmount;
   private String productType;

   /**
    *
    * @param productName
    * @param productAmount
    * @param productType
    */
   public Inventory(String productName, int productAmount, String productType)
   {
       setProductName(productName);
       setProductAmount(productAmount);
       setProductType(productType);
   }

   /**
    * Product Name getter
    * @return productName
    */
   public String getProductName() {
       return productName;
   }

   /**
    * Product Name getter
    * @param productName
    */
   public void setProductName(String productName) {
       this.productName = productName;
   }

   /**
    * Product Name getter
    * @return int returns productAmount
    */
   public int getProductAmount() {
       return productAmount;
   }

   /**
    * Product Amount setter
    * @param productAmount
    */
   public void setProductAmount(int productAmount) {
       this.productAmount = productAmount;
   }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
   
   
}


