import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ShoppingCartTableModel extends AbstractTableModel {
    private String[] columnNames = {"Product", "Quantity", "Price"};
    private List<Product> productList;

    public ShoppingCartTableModel(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = productList.get(rowIndex);
        Object tempory= null;

        if (columnIndex == 0) {
            tempory = "<html>" +
                    product.getId() + "<br/>" +
                    product.getName() + "<br/>";

            if (product instanceof Electronics) {
                tempory += ((Electronics) product).getBrand() + ", " + ((Electronics) product).getWarranty_period() + "</html>";
            } else if (product instanceof Clothing) {
                tempory += ((Clothing) product).getSize() + ", " + ((Clothing) product).getColour() + "</html>";
            }

        } else if (columnIndex == 1) {
            tempory = 1;
        } else if (columnIndex == 2) {
            tempory = product.getPrice();
        }

        return tempory;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}

