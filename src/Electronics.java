public class Electronics extends Product{
       private String brand;
       private int warranty_period;

       public Electronics(String Id, String name, int no_of_available_items, int  price,String brand,int warranty_period){
              super(Id,name,no_of_available_items,price);
              this.brand=brand;
              this.warranty_period=warranty_period;

       }

       public Electronics() {

       }

       public Electronics(String brand, int warranty_period) {
       }

       public Electronics(String brand, int warrantyPeriod, String name, int noOfAvailableItems, int price) {
       }

       public Electronics(String Id, String brand, int warrantyPeriod, String name, int noOfAvailableItems, int price) {
       }


       public String getBrand(){
              return brand;
       }

       public void setBrand(){
              this.brand=brand;
       }

       public int getWarranty_period(){
              return warranty_period;
       }

       public void setWarranty_period(){
              this.warranty_period=warranty_period;
       }

       @Override
       public String toString() {
              return "Electronics{" +
                      "brand='" + brand + '\'' +
                      ", warranty_period=" + warranty_period +
                      '}';
       }
}
