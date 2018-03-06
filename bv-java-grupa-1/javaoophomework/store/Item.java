package store;

import interfaces.ProductInterface;

/**
 * Is used to keep the stock number of a product that is attached to it.
 */
public class Item {

    private int stockNumber;
    private ProductInterface product;

    public Item(int stockNumber, ProductInterface product) {
        this.stockNumber = stockNumber;
        this.product = product;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public ProductInterface getProduct() {
        return product;
    }

    public void setProduct(ProductInterface product) {
        this.product = product;
    }
}
