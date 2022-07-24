package com.company.entities;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private String productId;
    private int amountOfMoney;

    public User() {
        userId = 0;
        firstName = "";
        lastName = "";
        amountOfMoney = 0;
        productId = "";
    }

    public User(String firstName, String lastName, int amountOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public int getId() {
        return userId;
    }

    public void setId(int id) {
        this.userId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(int prodId) {
        if (productId == null)
            productId = Integer.toString(prodId);
        else
            productId += " " + Integer.toString(prodId);
    }

    public void setProductId(String prodId) {
            productId = prodId;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "id=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }
}
