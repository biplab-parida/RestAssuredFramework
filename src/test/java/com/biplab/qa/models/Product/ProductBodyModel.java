package com.biplab.qa.models.Product;

import java.util.List;

public class ProductBodyModel {
    private String title;
    private String description;
    private String category;
    private double price;
    private double discountPercentage;
    private double rating;
    private int stock;
    private List<String> tags;
    private String brand;
    private String sku;
    private int weight;
    private Dimensions dimensions;

    public ProductBodyModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public ProductBodyModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBodyModel setCategory(String category) {
        this.category = category;
        return this;
    }

    public ProductBodyModel setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBodyModel setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
        return this;
    }

    public ProductBodyModel setRating(double rating) {
        this.rating = rating;
        return this;
    }

    public ProductBodyModel setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public ProductBodyModel setTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ProductBodyModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductBodyModel setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public ProductBodyModel setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public ProductBodyModel setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
        return this;
    }


    public static class Dimensions {
        public Dimensions setWidth(double width) {
            this.width = width;
            return this;
        }

        public Dimensions setHeight(double height) {
            this.height = height;
            return this;
        }

        public Dimensions setDepth(double depth) {
            this.depth = depth;
            return this;
        }

        private double width;
        private double height;
        private double depth;


    }
}
