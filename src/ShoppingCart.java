import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList;

    public ShoppingCart(){
        this.productList=new ArrayList<>();

    }
    public void addProduct(Product product){
        productList.add(product);
    }
    public void removeProduct(Product product){
        productList.remove(product);
    }

    public double calculateRoughTotalCost() {
        double totalCost=0.0;
        for(Product product:productList){
            totalCost+=product.getPrice();
        }
        return totalCost;
    }

    public double calculateTotalCost(){
        double totalCost=calculateRoughTotalCost() - getFirstPurchaseDiscount() - getCategoryDiscount();
        return totalCost;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public int getQuantity(Product product) {
        return 0;
    }

    public double getCategoryDiscount() {
        int electronics = 0;
        int clothings = 0;

        for (Product product : productList) {
            if (product instanceof Electronics)
                electronics++;
            else
                clothings++;
        }

        if (electronics >= 3 || clothings >= 3)
            return this.calculateRoughTotalCost() * 0.20;
        else
            return 0.0;
    }

    public double getFirstPurchaseDiscount() {
        return calculateRoughTotalCost() * 0.10;
    }
}