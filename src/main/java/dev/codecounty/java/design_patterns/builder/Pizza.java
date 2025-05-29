package dev.codecounty.java.design_patterns.builder;

/**
 * This class demonstrates the Builder design pattern in Java.
 * The Builder pattern is used to construct a complex object step by step.
 * It separates the construction of a complex object from its representation,
 * so that the same construction process can create different representations.
 *
 * In this example, we're building a 'Pizza' object, which can have many
 * optional ingredients (crust, sauce, cheese, toppings).
 */
public class Pizza {

    // Required parameters
    private final String size; // e.g., "Medium", "Large"

    // Optional parameters
    private final String crust; // e.g., "Thin", "Thick", "Stuffed"
    private final String sauce; // e.g., "Tomato", "Pesto", "BBQ"
    private final boolean extraCheese; // true/false
    private final String[] toppings; // e.g., {"Pepperoni", "Mushrooms"}

    /**
     * Private constructor to enforce object creation through the Builder.
     *
     * @param builder The PizzaBuilder instance containing the desired parameters.
     */
    private Pizza(PizzaBuilder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.extraCheese = builder.extraCheese;
        this.toppings = builder.toppings;
    }

    // --- Getters for Pizza attributes ---
    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public boolean hasExtraCheese() {
        return extraCheese;
    }

    public String[] getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza Details:\n");
        sb.append("  Size: ").append(size).append("\n");
        sb.append("  Crust: ").append(crust != null ? crust : "Standard").append("\n");
        sb.append("  Sauce: ").append(sauce != null ? sauce : "Standard Tomato").append("\n");
        sb.append("  Extra Cheese: ").append(extraCheese ? "Yes" : "No").append("\n");
        sb.append("  Toppings: ");
        if (toppings != null && toppings.length > 0) {
            sb.append(String.join(", ", toppings));
        } else {
            sb.append("None");
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Static nested Builder class for constructing Pizza objects.
     */
    public static class PizzaBuilder {
        // Required parameter for the builder
        private final String size;

        // Optional parameters for the builder, initialized to default or null
        private String crust;
        private String sauce;
        private boolean extraCheese = false; // Default to no extra cheese
        private String[] toppings;

        /**
         * Constructor for the Builder, taking only the required parameters.
         *
         * @param size The size of the pizza (e.g., "Medium", "Large").
         */
        public PizzaBuilder(String size) {
            this.size = size;
        }

        // --- Setter methods for optional parameters, returning the builder itself ---

        /**
         * Sets the crust type for the pizza.
         * @param crust The crust type (e.g., "Thin", "Thick").
         * @return The current PizzaBuilder instance for chaining.
         */
        public PizzaBuilder withCrust(String crust) {
            this.crust = crust;
            return this;
        }

        /**
         * Sets the sauce type for the pizza.
         * @param sauce The sauce type (e.g., "Tomato", "Pesto").
         * @return The current PizzaBuilder instance for chaining.
         */
        public PizzaBuilder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        /**
         * Specifies whether to add extra cheese.
         * @param extraCheese True if extra cheese is desired, false otherwise.
         * @return The current PizzaBuilder instance for chaining.
         */
        public PizzaBuilder withExtraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        /**
         * Sets the toppings for the pizza.
         * @param toppings An array of topping strings.
         * @return The current PizzaBuilder instance for chaining.
         */
        public PizzaBuilder withToppings(String... toppings) {
            this.toppings = toppings;
            return this;
        }

        /**
         * Builds and returns a new Pizza object using the parameters set in the builder.
         * @return A new Pizza object.
         */
        public Pizza build() {
            return new Pizza(this);
        }
    }

    /**
     * Main method to demonstrate the usage of the PizzaBuilder.
     */
    public static void main(String[] args) {
        // Example 1: Building a simple medium pizza
        Pizza classicPizza = new Pizza.PizzaBuilder("Medium")
                .withCrust("Thin")
                .withSauce("Tomato")
                .withExtraCheese(true)
                .withToppings("Pepperoni", "Mushrooms")
                .build();
        System.out.println(classicPizza);

        // Example 2: Building a large vegetarian pizza
        Pizza veggiePizza = new Pizza.PizzaBuilder("Large")
                .withCrust("Thick")
                .withSauce("Pesto")
                .withToppings("Onions", "Bell Peppers", "Olives")
                .build(); // No extra cheese by default, as not explicitly set
        System.out.println(veggiePizza);

        // Example 3: Building a small custom pizza with minimal options
        Pizza smallCustomPizza = new Pizza.PizzaBuilder("Small")
                .withSauce("BBQ")
                .build(); // Crust, toppings, extra cheese are default/null
        System.out.println(smallCustomPizza);

        // Example 4: Building a pizza with no toppings
        Pizza cheesePizza = new Pizza.PizzaBuilder("Medium")
                .withCrust("Standard")
                .withSauce("Tomato")
                .withExtraCheese(true)
                .build(); // No .withToppings() called, so toppings will be null or empty
        System.out.println(cheesePizza);
    }
}
