package store;

import products.AnimalProduct;
import products.VegetalProduct;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Deals with all the actions a user can do (create a product, sell it or display the daily sales report).
 */
public class Store {

    // Stores all the items added by the user.
    private List<Item> products = new ArrayList<>();
    private Map<String, String> orderHistory = new HashMap<>();

    /**
     * @param item is the item that will be added to the products list.
     */
    public void addProduct(Item item) {
        products.add(item);
    }

    /**
     * Checks the products list in order to be sure that it isn't empty.
     * It takes every item from the products list with a for each loop and checks if the product's id
     * (the product attached to the item) is the same as the productId parameter
     * and if the quantity that needs to be sold isn't bigger than the stock number of the item.
     * If the product meets these requirements, then the item's stock is reduced by the quantity given as a parameter
     * and the sell is added to a HashMap in order to keep track of the sale.
     *
     * @param productId is the id of the product that needs to be sold.
     * @param quantity is the quantity of the product that needs to be sold.
     * @return true if the operation succeeded and false otherwise.
     */
    public boolean sellProduct(String productId, int quantity) {
        if (!products.isEmpty()) {
            for (Item item : products) {
                if (item.getProduct().getId().equals(productId) && item.getStockNumber() - quantity >= 0) {
                    item.setStockNumber(item.getStockNumber() - quantity);

                    Date date = new Date();
                    String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
                    String productInfo = productId + " - " + quantity;
                    System.out.println(modifiedDate);
                    orderHistory.put(modifiedDate, productInfo);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the products list in order to be sure that it isn't empty.
     * It takes every item from the products list with a for each loop. Depending on the type of product
     * (animal or vegetal product) it prints it's attributes (like quantity left, price, weight and so on).
     *
     * @return true if there are any products to be displayed and false otherwise.
     */
    public boolean printProducts() {
        if (!products.isEmpty()) {
            for (Item item : products) {
                if(item.getProduct() instanceof AnimalProduct) {
                    System.out.println(item.getProduct().getId() + " - " + "Quantity: " + item.getStockNumber() +
                            " , Price: " + item.getProduct().getPrice() + " , Validity Date: " +
                            item.getProduct().getValidityDate() + " , Weight: " + item.getProduct().getWeight() +
                            " , Storage Temperature: " + ((AnimalProduct) item.getProduct()).getPackagingStorageTemperature());
                } else if (item.getProduct() instanceof VegetalProduct) {
                    System.out.println(item.getProduct().getId() + " - " + "Quantity: " + item.getStockNumber() +
                            " , Price: " + item.getProduct().getPrice() + " , Validity Date: " +
                            item.getProduct().getValidityDate() + " , Weight: " + item.getProduct().getWeight() +
                            " , List of Vitamins: " + (((VegetalProduct) item.getProduct()).getListOfVitamins()));
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Checks if there are any sales records to be displayed.
     * If there are, it displays the ones corresponding to the date given as a parameter.
     *
     * @return true if there are any sales records to be displayed and otherwise false.
     */
    public boolean printDailySalesReport(String date) {
        if(!orderHistory.isEmpty()) {
            System.out.println("Products sold: ");
            for (String purchaseDay : orderHistory.keySet()) {
                if(purchaseDay.equals(date)) {
                    System.out.println(orderHistory.get(purchaseDay));
                }
            }
            return true;
        }
        return false;
    }
}
