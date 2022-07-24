package com.company.model;

import com.company.entities.Product;
import com.company.entities.User;

import java.util.Iterator;
import java.util.LinkedList;

public class ShopImpl {

    private LinkedList<Product> listProducts;
    private LinkedList<User> listUsers;
    private Iterator<Product> iterProduct;
    private Iterator<User> iterUser;

    public ShopImpl() {
        listProducts = new LinkedList<>();
        listUsers = new LinkedList<>();
    }

    public LinkedList<Product> getListProducts() {
        return listProducts;
    }

    public LinkedList<User> getListUsers() {
        return listUsers;
    }

    public void addNewUser(String firstName, String lastName, int amountOfMoney) {
        User user = new User(firstName, lastName, amountOfMoney);
        if (listUsers.isEmpty())
            user.setId(1);
        else
            user.setId(listUsers.getLast().getId() + 1);
        listUsers.add(user);
    }

    public void addNewProduct(String name, int price) {
        Product product = new Product(name, price);
        if (listProducts.isEmpty())
            product.setId(1);
        else
            product.setId(listProducts.getLast().getId() + 1);
        listProducts.add(product);
    }

    public void buyProduct(int userId, int productId) throws Exception {
        User user = new User();
        Product product = new Product();
        iterProduct = listProducts.iterator();
        iterUser = listUsers.iterator();
        while (iterUser.hasNext()) {
            user = iterUser.next();
            if (user.getId() == userId)
                break;
        }
        if (user.getId() != userId) {
            throw new Exception("No user with such id!");
        }
        while (iterProduct.hasNext()) {
            product = iterProduct.next();
            if (product.getId() == productId) {
                break;
            }
        }
        if (product.getId() != productId) {
            throw new Exception("No product with such id!");
        }
        if (product.getPrice() > user.getAmountOfMoney()) {
            throw new Exception("Not enough money to buy this product!");
        } else {
            user.setProductId(product.getId());
            user.setAmountOfMoney(user.getAmountOfMoney() - product.getPrice());
            System.out.println("Hooray, the user has successfully bought the product!");
        }
    }

    public String PrintListOfUserProducts(int userId) {
        String result = "";
        User user = new User();
        iterUser = listUsers.iterator();
        while (iterUser.hasNext()) {
            user = iterUser.next();
            if (user.getId() == userId) {
                result = user.getProductId();
                break;
            }
        }
        return result;
    }

    public String PrintUsersByProductId(int prodId) {
        String result = "";
        User user = new User();
        iterUser = listUsers.iterator();
        while (iterUser.hasNext()) {
            user = iterUser.next();
            if (user.getProductId() == null)
                continue;
            else if (user.getProductId().equals(Integer.toString(prodId))) {
                if (result.length() == 0)
                    result = Integer.toString(user.getId());
                else
                    result += ", " + Integer.toString(user.getId());
            }
        }
        return result;
    }

    public void DeleteUser(int userId) throws Exception {
        int i = 0;
        User user = new User();
        iterUser = listUsers.iterator();
        while (iterUser.hasNext()) {
            user = iterUser.next();
            if (user.getId() == userId) {
                iterUser.remove();
            }
            i++;
        }
        if (userId > i || userId < 1) {
            throw new Exception("No user with such id!");
        }
    }

    public void DeleteProduct(int prodId) throws Exception {
        User user = new User();
        Product product = new Product();
        iterUser = listUsers.iterator();
        iterProduct = listProducts.iterator();
        String[] arr;
        String newProductId = "";
        int j = 0;

        while (iterUser.hasNext()) {
            user = iterUser.next();
            if (user.getProductId() == null) {
                continue;
            } else {
                arr = user.getProductId().split(" ");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].equals(Integer.toString(prodId)))
                        continue;
                    else if (newProductId.isEmpty())
                        newProductId = arr[i];
                    else
                        newProductId += " " + arr[i];
                }
            }
            user.setProductId(newProductId);
        }
        while (iterProduct.hasNext()) {
            product = iterProduct.next();
            if (product.getId() == prodId) {
                iterProduct.remove();
            }
            j++;
        }
        if (prodId > j || prodId < 1) {
            throw new Exception("No product with such id!");
        }
    }
}
