public abstract class Product {
    private String Id;
    private String name;
    private int no_of_available_items;
    private int price;

    public Product(String Id, String name, int no_of_available_items, int price) {
        this.Id = Id;
        this.name =name ;
        this.no_of_available_items=no_of_available_items;
        this.price = price;
    }

    public Product() {

    }

    public static Product createProductFromString() {
        return null;
    }

    public String getId() {

        return Id;
    }

    public void setId() {
        this.Id = Id;

    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name=name;
    }

    public int getNo_of_available_items(){
        return no_of_available_items;
    }

    public void setNo_of_available_items(){
        this.no_of_available_items=no_of_available_items;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price=price;
    }



    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", no_of_available_items=" + no_of_available_items +
                ", price=" + price +
                '}';
    }


    public boolean size() {
        return false;
    }

    public Object getProduct() {
        return null;
    }

    public String getCategoryLabel(Product product) {
        if(this instanceof Electronics){
            return "Electronics";
        }else if(this instanceof Clothing){
            return "Clothing";
        }else{
            return "Unknown";
        }
    }

    public interface ShoppingManager{
        String getId();
    }
}


