package com.company.view;

import java.util.ArrayList;

public class ConsoleView {
    private static ArrayList<String> menu;

    static {
        menu = new ArrayList<>();
    }

    public ConsoleView() {
        menu.add("1 - Add user");
        menu.add("2 - Add product");
        menu.add("3 - Print list of all users");
        menu.add("4 - Print list of all products");
        menu.add("5 - Buy a product");
        menu.add("6 - Display a list of user products by a user's id");
        menu.add("7 - Display a list of users that have bought a product by a product id");
        menu.add("8 - Delete a user");
        menu.add("9 - Delete a product");
        menu.add("Q - exit");
    }

    public void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu) {
            System.out.println(str);
        }
        System.out.println("Please, select menu point: ");
    }

    public void output(String str) {
        switch (str){
            case "1":
                System.out.println("Enter first name, last name and amount of money: ");
                break;
            case "2":
                System.out.println("Enter the product name and the price: ");
                break;
            case "5":
                System.out.println("Enter the user id and the product id: ");
                break;
            case "6":
            case "8":
                System.out.println("Enter the user's id: ");
                break;
            case "7":
            case "9":
                System.out.println("Enter the product id: ");
                break;
        }
    }
}
