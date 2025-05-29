package dev.codecounty.java.design_patterns.builder;

// Product.java - The class we want to build with fluent setters
public class LaptopProduct {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private boolean available;

    // Default constructor (or a constructor for mandatory fields)
    public LaptopProduct(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        this.name = name;
        // Set default values for optional fields
        this.description = "No description provided";
        this.price = 0.0;
        this.quantity = 0;
        this.available = true;
    }

    // Fluent setter methods that return the Product instance for chaining
    public LaptopProduct withDescription(String description) {
        this.description = description;
        return this; // Return 'this' to allow method chaining
    }

    public LaptopProduct withPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
        return this;
    }

    public LaptopProduct withQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        this.quantity = quantity;
        return this;
    }

    public LaptopProduct setAvailable(boolean available) {
        this.available = available;
        return this;
    }

    // Getters for Product properties
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               ", available=" + available +
               '}';
    }

    // Main method to demonstrate the Fluent Setter pattern usage
    public static void main(String[] args) {
        // Example 1: Building a product with all fields specified using chaining
        LaptopProduct laptop = new LaptopProduct("Gaming Laptop")
                                    .withDescription("High-performance laptop for gaming and productivity")
                                    .withPrice(1500.00)
                                    .withQuantity(10)
                                    .setAvailable(true); // No .build() method needed
        System.out.println("Built Product 1: " + laptop);

        System.out.println("\n----------------------------------\n");

        // Example 2: Building a product with only mandatory and some optional fields
        LaptopProduct keyboard = new LaptopProduct("Mechanical Keyboard")
                                      .withPrice(99.99)
                                      .withQuantity(50); // Uses default description and available status
        System.out.println("Built Product 2: " + keyboard);

        System.out.println("\n----------------------------------\n");

        // Example 3: Building a product with minimal fields (only mandatory)
        LaptopProduct mousePad = new LaptopProduct("Large Mouse Pad");
        System.out.println("Built Product 3: " + mousePad);

        System.out.println("\n----------------------------------\n");

        // Example 4: Demonstrating validation (uncomment to test)
        try {
            new LaptopProduct("Invalid Product").withPrice(-10.0);
        } catch (IllegalArgumentException e) {
            System.err.println("Error setting product price: " + e.getMessage());
        }

        try {
            new LaptopProduct(null); // This will throw an exception directly in the constructor
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating product: " + e.getMessage());
        }
    }
}
