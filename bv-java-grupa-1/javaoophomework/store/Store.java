package store;

import products.AnimalProduct;
import products.VegetalProduct;

import java.text.SimpleDateFormat;
import java.util.*;

public class Store {

    private List<Item> products = new ArrayList<>();
    private Map<String, String> orderHistory = new HashMap<>();

    public void addProduct(Item item) {
        products.add(item);
    }

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
