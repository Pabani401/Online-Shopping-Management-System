import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Collections;


public class WestminsterShoppingManager implements ShoppingManager {


    private ArrayList<Product> productList;
    private final int numProducts;


    public static void main(String[] args) {
        WestminsterShoppingManager ShoppingManager = new WestminsterShoppingManager();
        ShoppingManager.runMenu();
    }


    public WestminsterShoppingManager() {
        productList = new ArrayList<Product>();
        this.numProducts = 50;
    }


    public boolean runMenu() {
        while (true) {
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 to add products:");
            System.out.println("Enter 2 to delete products:");
            System.out.println("Enter 3 to print lists of products:");
            System.out.println("Enter 4 to save products that have added to the list:");
            System.out.println("Enter 5 to exit the programme:");
            System.out.println("Enter 6 to show the GUI:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addProductMain();
                    break;
                case "2":
                    deleteProduct();
                    break;
                case "3":
                    printList();
                    break;
                case "4":
                    saveFile();
                    break;
                case "5":
                    System.out.println("Exit from the program");
                    return false;
                case "6":
                    showGUI();
                    break;
                case"7":
                    loadFile();
                default:
                    System.out.println("Enter a valid option");


            }


        }
    }

//adding products to the productList
    public void addProductMain() {
        if (productList.size() < numProducts) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 to add electronics ,2 to add Clothing:");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 1) {
                System.out.println("Enter name of the product:");
                String name = scanner.nextLine();
                System.out.println("Enter product id ");
                String Id = scanner.nextLine();
                System.out.println("Enter no of available items:");
                int no_of_available_items = scanner.nextInt();
                System.out.println("Enter Price");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter brand for electronics:");
                String brand = scanner.nextLine();
                System.out.println("Enter warranty period for electronics:");
                int warranty_period = scanner.nextInt();
                Electronics newObj = new Electronics(Id, name, no_of_available_items, price, brand, warranty_period);
                productList.add(newObj);
                System.out.println("Electronics product" + Id + "Added to the list");

            } else if (option == 2) {
                System.out.println("Enter name of the product:");
                String name = scanner.nextLine();
                System.out.println("Enter product id ");
                String Id = scanner.nextLine();
                System.out.println("Enter no of available items:");
                int no_of_available_items = scanner.nextInt();
                System.out.println("Enter Price");
                int price = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter size for clothing:");
                String size = scanner.nextLine();
                System.out.println("Enter color for clothing:");
                String colour = scanner.nextLine();
                System.out.println();
                Clothing newObj2 = new Clothing(Id, name, no_of_available_items, price, size, colour);
                productList.add(newObj2);
                System.out.println("Clothing product" + Id + "Added to the list");
            } else {
                System.out.println("no more space in the list");

            }

        }
    }
//deleting the products in the list
    public void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product Id to Delete:");
        String productId = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(productId)) {
                System.out.println(productList.get(i));
                System.out.println();
                System.out.println("Do you want to delete the products");
                String option2 = scanner.nextLine();
                if (option2.equals("Yes")) {
                    System.out.println(productList.get(i) + "Removed");
                    productList.remove(i);
                    System.out.println(productList.size() + "Left in the system");
                } else {
                    System.out.println("Product deletion canceled");
                }
                break; //to exist the loop after removing the product
            }
        }
    }

//printing the list
    public void printList() {
        if (productList.isEmpty()) {
            System.out.println("No products in the system");
            return;
        }
        //sort the productList alphabetically by product ID
        Collections.sort(productList, (p1, p2) -> p1.getId().compareTo(p2.getId()));
        System.out.println("List of Products in the System");

        for (Product product : productList) {
            if (product instanceof Electronics) {
                System.out.println("Electronics product:");
                System.out.println("ID:" + product.getId());
                System.out.println("Name:" + product.getName());
                System.out.println("Available Items:" + product.getNo_of_available_items());
                System.out.println("Price" + product.getPrice());
                System.out.println("Brand:" + ((Electronics) product).getBrand());
                System.out.println("Warranty Period:" + ((Electronics) product).getWarranty_period());
            } else if (product instanceof Clothing) {
                System.out.println("Clothing product:");
                System.out.println("ID:" + product.getId());
                System.out.println("Name:" + product.getName());
                System.out.println("Available Items:" + product.getNo_of_available_items());
                System.out.println("Price" + product.getPrice());
                System.out.println("Size:" + ((Clothing) product).getSize());
                System.out.println("Colour:" + ((Clothing) product).getColour());

            }
            System.out.println("-------------------------------------------------------------");
        }
    }
    //GUI
    public void showGUI(){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CustomerGUI window = new CustomerGUI(productList);
                    window.getFrame().setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    //saving the file
    public void saveFile() {
        try (PrintWriter writer = new PrintWriter("productList.txt")) {
            for (Product product : productList) {
                writer.println(product.toString());
            }
            System.out.println("Product list saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error saving product list: " + e.getMessage());
        }
    }
    //loading the details from the file
    public void loadFile() {
        try (Scanner scanner = new Scanner(new File("productList.txt"))) {
            while (scanner.hasNextLine()) {
                String productData = scanner.nextLine();
                // Assuming your Product class has a constructor that takes a String for initialization
                Product product = Product.createProductFromString();
                productList.add(product);
            }
            System.out.println("Product list loaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading product list: " + e.getMessage());
        }
    }


}





