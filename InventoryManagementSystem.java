import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    private ArrayList<Product> inventory;
    private Scanner scanner;

    
    public InventoryManagementSystem() {
        inventory = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Adding  a new product to the inventory
    public void addProduct() {
        System.out.print("\nEnter Product ID: ");
        String productID = scanner.nextLine();
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Product product = new Product(productID, name, quantity, price);
        inventory.add(product);
        System.out.println("Product added successfully!");
    }

    // Updating  the quantity of an existing product
    public void updateQuantity() {
        System.out.print("\nEnter Product ID: ");
        String productID = scanner.nextLine();
        Product product = findProductByID(productID);

        if (product != null) {
            System.out.print("Enter New Quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); 
            product.setQuantity(newQuantity);
            System.out.println("Quantity updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Viewing  details of a product
    public void viewProductDetails() {
        System.out.print("\nEnter Product ID or Name: ");
        String searchKey = scanner.nextLine();
        Product product = findProductByID(searchKey);

        if (product == null) {
            product = findProductByName(searchKey);
        }

        if (product != null) {
            product.displayDetails();
        } else {
            System.out.println("Product not found!");
        }
    }

    // Calculating and displaying total inventory value
    public void calculateTotalInventoryValue() {
        double totalValue = 0.0;
        for (Product product : inventory) {
            totalValue += product.calculateTotalValue();
        }
        System.out.printf("\nTotal Inventory Value: $%.2f\n", totalValue);
    }

    // finding product by ID
    private Product findProductByID(String productID) {
        for (Product product : inventory) {
            if (product.getProductID().equalsIgnoreCase(productID)) {
                return product;
            }
        }
        return null;
    }

    
    private Product findProductByName(String name) {
        for (Product product : inventory) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    
    public void displayMenu() {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. View Product Details");
            System.out.println("4. Calculate Total Inventory Value");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    viewProductDetails();
                    break;
                case 4:
                    calculateTotalInventoryValue();
                    break;
                case 5:
                    System.out.println("Exiting the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();
        system.displayMenu();
    }
}
