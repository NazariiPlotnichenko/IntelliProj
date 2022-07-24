package com.company.entities;

public class Product {
    private int productId;
    private String name;
    private int price;

    public Product() {
        productId = 0;
        name = "";
        price = 0;
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return productId;
    }

    public void setId(int productId) {
        this.productId = productId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "Id=" + productId +
                ", Name='" + name + '\'' +
                ", Price=" + price +
                '}';
    }
}
