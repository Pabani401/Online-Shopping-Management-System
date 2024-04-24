import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ShoppingCartWindow extends JFrame {
    private JTable cartTable;
    private ShoppingCartTableModel cartModel;
    private ShoppingCart shoppingCart;

    public ShoppingCartWindow(ShoppingCart shoppingCart){
        this.shoppingCart=shoppingCart;

        initialize();

    }
    private void initialize(){
        setTitle("Shopping Cart");
        setSize(600,400);

        JPanel topPanel = new JPanel(new BorderLayout());
        cartModel = new ShoppingCartTableModel(shoppingCart.getProductList());
        cartTable=new JTable(cartModel);
        cartTable.setRowHeight(55);
        cartTable.setPreferredScrollableViewportSize(new Dimension(400, 200));
        JScrollPane scrollPane=new JScrollPane(cartTable);
        topPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel detailsPanel = new JPanel(new GridLayout(4,2));

        detailsPanel.add(new JLabel("Total"));
        detailsPanel.add(new JLabel(String.valueOf(shoppingCart.calculateRoughTotalCost())));
        detailsPanel.add(new JLabel("First Purchase Discount (10%)"));
        detailsPanel.add(new JLabel(String.valueOf(shoppingCart.getFirstPurchaseDiscount())));
        detailsPanel.add(new JLabel("Three items in same Category Discount (20%)"));
        detailsPanel.add(new JLabel(String.valueOf(shoppingCart.getCategoryDiscount())));
        detailsPanel.add(new JLabel("Final Total"));
        detailsPanel.add(new JLabel(String.valueOf(shoppingCart.calculateTotalCost())));

        add(topPanel, BorderLayout.NORTH);
        add(detailsPanel, BorderLayout.CENTER);
    }

    private String getProductInfo(Product product){
        if (product instanceof Clothing){
            return"product info";
        }

        return null;
    }
}
