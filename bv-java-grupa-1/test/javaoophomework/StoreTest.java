package javaoophomework;

import org.junit.Test;
import products.AnimalProduct;
import products.VegetalProduct;
import store.Item;
import store.Store;

import static org.junit.Assert.assertEquals;

public class StoreTest {

    @Test
    public void testSellProduct() {
        Store store = new Store();

        AnimalProduct meat = new AnimalProduct("Meat", 10, "2018-02-15",
                5, 0);
        VegetalProduct cabbage = new VegetalProduct("Cabbage", 1, "2018-05-25",
                0.2, "E, D, C");
        Item meatItem = new Item(8, meat);
        Item cabbageItem = new Item(24, cabbage);

        store.addProduct(meatItem);
        store.addProduct(cabbageItem);

        boolean test = store.sellProduct("Meat", 2);
        assertEquals(test, true);
    }

    @Test
    public void testSellProductWrongId() {
        Store store = new Store();

        AnimalProduct meat = new AnimalProduct("Meat", 10, "2018-02-15",
                5, 0);
        VegetalProduct cabbage = new VegetalProduct("Cabbage", 1, "2018-05-25",
                0.2, "E, D, C");
        Item meatItem = new Item(8, meat);
        Item cabbageItem = new Item(24, cabbage);

        store.addProduct(meatItem);
        store.addProduct(cabbageItem);

        boolean test = store.sellProduct("fish", 2);
        assertEquals(test, false);
    }

    @Test
    public void testSellProductWrongQuantity() {
        Store store = new Store();

        AnimalProduct meat = new AnimalProduct("Meat", 10, "2018-02-15",
                5, 0);
        VegetalProduct cabbage = new VegetalProduct("Cabbage", 1, "2018-05-25",
                0.2, "E, D, C");
        Item meatItem = new Item(8, meat);
        Item cabbageItem = new Item(24, cabbage);

        store.addProduct(meatItem);
        store.addProduct(cabbageItem);

        boolean test = store.sellProduct("Cabbage", 29);
        assertEquals(test, false);
    }

    @Test
    public void testSellProductEmptyProductsList() {
        Store store = new Store();

        boolean test = store.sellProduct("Cabbage", 20);
        assertEquals(test, false);
    }

    @Test
    public void testPrintProductsAnimalAndVegetable() {
        Store store = new Store();

        AnimalProduct meat = new AnimalProduct("Meat", 10, "2018-02-15",
                            5, 0);
        VegetalProduct cabbage = new VegetalProduct("Cabbage", 1, "2018-05-25",
                            0.2, "E, D, C");
        Item meatItem = new Item(8, meat);
        Item cabbageItem = new Item(24, cabbage);

        store.addProduct(meatItem);
        store.addProduct(cabbageItem);

        boolean test = store.printProducts();
        assertEquals(test, true);
    }

    @Test
    public void testPrintProductsEmptyList() {
        Store store = new Store();

        boolean test = store.printProducts();
        assertEquals(test, false);
    }

    @Test
    public void testPrintDailySalesReportEmpty() {
        Store store = new Store();

        boolean test = store.printDailySalesReport("2018-02-11");
        assertEquals(test, false);
    }
}
