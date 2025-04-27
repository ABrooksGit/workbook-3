package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class Main {

    private static Console console = new Console();
    private static ArrayList<Product> inventory;

    public static void main(String[] args) {



        System.out.println("This is Our Inventory: ");



        inventory = getInventory();
        
        for(Product product: inventory){
            System.out.println(product.setFormat());
        }




//          First Version
//        for(int i = 0; i < inventory.size(); i++){
//            Product product  = inventory.get(i);
//                System.out.printf("id: %d| %s |Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());
//
            }










    private static ArrayList<Product> getInventory() {
            //First Version
//            products.add(new Product(2841, "Smartphone", 599.99f));
//            products.add(new Product(3114, "Tablet", 299.99f));
//            products.add(new Product(4245, "Smartwatch", 199.99f));
//            products.add(new Product(54563, "Headphones", 99.99f));

        try{

            FileReader inventory = new FileReader("inventory.txt");
            BufferedReader br = new BufferedReader(inventory);
            ArrayList<Product> products = new ArrayList<>();

            String nextString;

            while ((nextString = br.readLine()) != null){
                products.add(productEncoded(nextString));
            }
            return products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private static Product productEncoded(String encoded){

        String[] next = encoded.split(Pattern.quote("|"));

        int id = Integer.parseInt(next[0]);
        String name = next[1];
        float price = Float.parseFloat(next[2]);

        Product result = new Product(id, name, price);

        return  result;
    }




}

