package com.company.controller;

import com.company.entities.Product;
import com.company.entities.User;
import com.company.model.ShopImpl;
import com.company.view.ConsoleView;

import java.util.Locale;
import java.util.Scanner;

public class Controller {
    static private Scanner input;
    static private ConsoleView consoleView;
    static private ShopImpl shop;

    static {
        input = new Scanner(System.in);
        consoleView = new ConsoleView();
        shop = new ShopImpl();
    }

    public void start() throws Exception {
        String keyMenu;
        String firstName;
        String lastName;
        int user;
        int product;
        do {
            consoleView.outputMenu();
            keyMenu = input.nextLine().toUpperCase(Locale.ROOT);
            consoleView.output(keyMenu);
            try {
                switch (keyMenu) {
                    case "1":
                        firstName = input.nextLine();
                        lastName = input.nextLine();
                        user = input.nextInt();
                        shop.addNewUser(firstName, lastName, user);
                        break;
                    case "2":
                        firstName = input.nextLine();
                        user = input.nextInt();
                        shop.addNewProduct(firstName, user);
                        break;
                    case "3":
                        for (User us : shop.getListUsers()) {
                            System.out.println(us);
                        }
                        break;
                    case "4":
                        for (Product prod : shop.getListProducts()) {
                            System.out.println(prod);
                        }
                        break;
                    case "5":
                        user = input.nextInt();
                        product = input.nextInt();
                        shop.buyProduct(user, product);
                        break;
                    case "6":
                        user = input.nextInt();
                        System.out.println(shop.PrintListOfUserProducts(user));
                        break;
                    case "7":
                        product = input.nextInt();
                        System.out.println(shop.PrintUsersByProductId(product));
                        break;
                    case "8":
                        user = input.nextInt();
                        shop.DeleteUser(user);
                        break;
                    case "9":
                        product = input.nextInt();
                        shop.DeleteProduct(product);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Something went wrong, try again!");
            }
        }
        while (!keyMenu.equals("Q"));
    }

}
