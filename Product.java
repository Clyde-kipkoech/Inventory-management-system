class Product {
    private String productID;
    private String name;
    private int quantity;
    private double price;

    
    public Product(String productID, String name, int quantity, double price) {
        this.productID = productID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // getters
    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // displaying the product details
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + name);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Price: ksh%.2f\n", price);
        System.out.println("*****************");
    }

    // Calculating total value for the product
    public double calculateTotalValue() {
        return quantity * price;
    }
}