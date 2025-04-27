package com.pluralsight;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Pattern;


import static java.lang.Float.parseFloat;

public class Main {
    private static Console console = new Console();
    static HashMap<String, Product> inventory = new HashMap<String, Product>();
    private static ArrayList<Product> productList;

    public static void main(String[] args) {


        productList = getInventory();
        allMaps();


    }

    private static void allMaps() {


        for (Product product : productList) {
            inventory.put(product.getName(), product);
        }


        String inventoryItem = console.promptForString("Which inventory item do you want to see?: ");

        Product product = inventory.get(inventoryItem);
        if (product != null) {
            System.out.println("product found: " + product.format());

            String cont ="Do you want to search again (yes or no): ";
            String nextPrompt;
            do {
                nextPrompt = console.promptForString(cont);
               if (nextPrompt.equalsIgnoreCase("yes")) {
                   inventoryItem = console.promptForString("Which inventory item do you want to see?: ");
                   product = inventory.get(inventoryItem);
                   if (product != null) {
                       System.out.println("product found: " + product.format());
                   } else {
                       System.out.println("Product NOT FOUND");
                   }
               }

           } while(!nextPrompt.equalsIgnoreCase("no"));



        } else {
            System.out.println("Product NOT FOUND");
            return;
        }

    }


    private static ArrayList<Product> getInventory() {

        try {
            FileReader inventoryList = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(inventoryList);
            ArrayList<Product> productList = new ArrayList<>();

            String inputString;

            while ((inputString = br.readLine()) != null) {

                productList.add(inventoryStringEncoded(inputString));
            }

            return productList;


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static Product inventoryStringEncoded(String encodedFiles) {

        String[] parts = encodedFiles.split(Pattern.quote("|"));

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        float price = parseFloat(parts[2]);

        Product result = new Product(id, name, price);

        return result;
    }


}