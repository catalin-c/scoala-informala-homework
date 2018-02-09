package products;

import interfaces.VegetalProductInterface;

public class VegetalProduct implements VegetalProductInterface {

    private String id;
    private double price;
    private String validityDate;
    private double weight;
    private String listOfVitamins;

    public VegetalProduct(String id, double price, String validityDate, double weight,
                          String listOfVitamins) {
        this.id = id;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.listOfVitamins = listOfVitamins;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override

    public String getValidityDate() {
        return validityDate;
    }

    @Override
    public void setValidityDate(String validityDate) {
        this.validityDate = validityDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getListOfVitamins() {
        return listOfVitamins;
    }

    public void setListOfVitamins(String listOfVitamins) {
        this.listOfVitamins = listOfVitamins;
    }
}
