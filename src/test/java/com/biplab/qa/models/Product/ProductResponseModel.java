package com.biplab.qa.models.Product;

public class ProductResponseModel {
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    int id;
    String title;
    double price;
    double discountPercentage;
    double rating;
    String description;
    String brand;
    String category;

}
