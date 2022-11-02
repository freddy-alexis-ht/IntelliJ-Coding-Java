package refactoring;

import java.util.Objects;

public class Pizza {

    private boolean cheese;
    private boolean pepperoni;
    private boolean tomato;
    private boolean basil;
    private boolean ham;
    private boolean onions;
    private int diameter;
    private String name;
    private double price;

    public Pizza(boolean cheese, boolean pepperoni, boolean pineapple, boolean ham, boolean onions, int diameter, String name, double price) {
        this.name = Objects.requireNonNull(name);
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.ham = ham;
        this.onions = onions;
        this.diameter = diameter;
        this.price = price;

        if(pineapple) {
            throw new IllegalToppingException("Please try another ingredient.");
        }
    }

    /**
     * Creates a Margherita pizza with tomato, cheese and basil
     * @param diameter
     * @param name
     * @param price
     */
    public Pizza(int diameter, String name, double price) {
        this.name = Objects.requireNonNull(name);
        this.diameter = diameter;
        this.price = price;
        this.cheese = true;
        this.basil = true;
        this.tomato = true;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }


    public boolean hasHam() {
        return ham;
    }

    public boolean hasOnions() {
        return onions;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasTomato() {
        return tomato;
    }

    public boolean hasBasil() {
        return basil;
    }

    private static class IllegalToppingException extends IllegalArgumentException {
        public IllegalToppingException(String s) {
            super(s);
        }
    }
}
