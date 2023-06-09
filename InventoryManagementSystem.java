package practiceProblems;

import java.util.ArrayList;
import java.util.List;

abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void displayDetails();
}

class Electronics extends Product {
    private String brand;

    public Electronics(String name, double price, int quantity, String brand) {
        super(name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Brand: " + getBrand());
        System.out.println("-----------------------------");
    }
}

class Grocery extends Product {
    private String expiryDate;

    public Grocery(String name, double price, int quantity, String expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void displayDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Price: " + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Expiry Date: " + getExpiryDate());
        System.out.println("-----------------------------");
    }
}

class Inventory {
    private List<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateQuantity(String name, int quantity) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                product.setQuantity(quantity);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void displayProducts() {
        for (Product product : products) {
            product.displayDetails();
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Electronics electronics = new Electronics("Laptop", 999.99, 5, "Brand X");
        Grocery grocery = new Grocery("Apples", 1.99, 10, "2023-06-30");

        inventory.addProduct(electronics);
        inventory.addProduct(grocery);

        inventory.updateQuantity("Laptop", 3);
        inventory.updateQuantity("Invalid Product", 5);

        inventory.displayProducts();
    }
}
