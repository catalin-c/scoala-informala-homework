package products;

import interfaces.AnimalProductInterface;

public class AnimalProduct implements AnimalProductInterface {

    private String id;
    private double price;
    private String validityDate;
    private double weight;
    private double packagingStorageTemperature;

    public AnimalProduct(String id, double price, String validityDate, double weight,
                         double packagingStorageTemperature) {
        this.id = id;
        this.price = price;
        this.validityDate = validityDate;
        this.weight = weight;
        this.packagingStorageTemperature = packagingStorageTemperature;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
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

    public double getPackagingStorageTemperature() {
        return packagingStorageTemperature;
    }

    public void setPackagingStorageTemperature(double packagingStorageTemperature) {
        this.packagingStorageTemperature = packagingStorageTemperature;
    }

}
