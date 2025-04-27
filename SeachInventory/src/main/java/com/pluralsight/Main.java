package com.pluralsight;
import java.util.ArrayList;

public class Main {
    private static Console console = new Console();

    public static void main(String[] args) {


        ArrayList<Product> inventory = getInventory();
        System.out.println("This is Our Inventory: ");



        for(int i = 0; i < inventory.size(); i++){
            Product product  = inventory.get(i);
                System.out.printf("id: %d| %s |Price: $%.2f\n", product.getId(), product.getName(), product.getPrice());

            }
        }








    private static ArrayList<Product> getInventory() {
            ArrayList<Product> products = new ArrayList<>();
            products.add(new Product(2841, "Smartphone", 599.99f));
            products.add(new Product(3114, "Tablet", 299.99f));
            products.add(new Product(4245, "Smartwatch", 199.99f));
            products.add(new Product(54563, "Headphones", 99.99f));

        return products;
    }

}

