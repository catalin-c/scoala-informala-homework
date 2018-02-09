package main;

import interfaces.ProductInterface;
import products.AnimalProduct;
import products.VegetalProduct;
import store.Item;
import store.Store;
import utils.UserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        Store store = new Store();
        while (true) {
            UserInput user = new UserInput();
            System.out.println("-------------------------------------------------------------\n" +
                    "1. Create product and add it to stock\n" +
                    "2. Sell product\n" +
                    "3. Display daily sales report\n" +
                    "4. Exit\n" +
                    "\n" +
                    "Choose an option:\n" +
                    "-------------------------------------------------------------");

            int userMainChoice = 0;
            try {
                userMainChoice = user.getIntInput();
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid command!");
                continue;
            }

            if (userMainChoice == 1) {
                System.out.println("ProductInterface type (1 - animal; 2 - vegetable): ");
                int productType = 0;

                try {
                    productType = user.getIntInput();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a number!");
                    continue;
                }

                if (productType == 1) {
                    System.out.println("Enter product quantity: ");
                    int productQuantity = 0;
                    try {
                        productQuantity = user.getIntInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid quantity value!");
                        continue;
                    }

                    System.out.println("Enter product id:");
                    String productId = user.getStringInput();

                    System.out.println("Enter product price:");
                    double productPrice = 0;
                    try {
                        productPrice = user.getDoubleInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid price!");
                        continue;
                    }

                    System.out.println("Enter product validity date (year-month-day): ");
                    String productValidityDate = user.getStringInput();
//                    checkValidityDateFormat();

                    System.out.println("Enter product weight:");
                    double productWeight = 0;
                    try {
                        productWeight = user.getDoubleInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid weight!");
                        continue;
                    }

                    System.out.println("Enter product packaging storage temperature:");
                    double productPackagingStorageTemperature = 0;
                    try {
                        productPackagingStorageTemperature = user.getDoubleInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid weight!");
                        continue;
                    }

                    ProductInterface animalProduct = new AnimalProduct(productId, productPrice, productValidityDate,
                            productWeight, productPackagingStorageTemperature);
                    Item item = new Item(productQuantity, animalProduct);
                    store.addProduct(item);

                    System.out.println("Success!");

                } else if (productType == 2) {
                    System.out.println("Enter product quantity: ");
                    int productQuantity = 0;
                    try {
                        productQuantity = user.getIntInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid quantity value!");
                        continue;
                    }

                    System.out.println("Enter product id:");
                    String productId = user.getStringInput();

                    System.out.println("Enter product price:");
                    double productPrice = 0;
                    try {
                        productPrice = user.getDoubleInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid price!");
                        continue;
                    }

                    System.out.println("Enter product validity date (year-month-day): ");
                    String productValidityDate = user.getStringInput();
//                    checkValidityDateFormat();

                    System.out.println("Enter product weight:");
                    double productWeight = 0;
                    try {
                        productWeight = user.getDoubleInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid weight!");
                        continue;
                    }

                    System.out.println("Enter product list of vitamins (on the same line separated by commas):");
                    String productListOfVitamins = user.getStringInput();

                    ProductInterface animalProduct = new VegetalProduct(productId, productPrice, productValidityDate,
                            productWeight, productListOfVitamins);
                    Item item = new Item(productQuantity, animalProduct);
                    store.addProduct(item);

                    System.out.println("Success!");
                } else {
                    System.out.println("Please enter a valid number!");
                }
            } else if (userMainChoice == 2) {
                if (store.printProducts()) {
                    System.out.println("Enter the ID of the product you want to sell:");
                    String productId = user.getStringInput();

                    System.out.println("Enter quantity:");
                    int productQuantity = 0;
                    try {
                        productQuantity = user.getIntInput();
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid quantity!");
                        continue;
                    }

                    if (store.sellProduct(productId, productQuantity)) {
                        System.out.println("Success!");
                    } else {
                        System.out.println("You can't sell that much or the product doesn't exist!");
                    }
                } else {
                    System.out.println("There aren't any products added yet!");
                }
            } else if (userMainChoice == 3) {
                System.out.println("Enter the date:");
                String date = user.getStringInput();
                if (!store.printDailySalesReport(date)) {
                    System.out.println("Nobody bought anything in that day!");
                }
            } else if (userMainChoice == 4) {
                System.out.println("Have a great day! Bye!");
                break;
            }
        }
    }
}
