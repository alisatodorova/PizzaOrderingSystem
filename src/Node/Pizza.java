package Node;
import Controllers.*;
import Database.*;
import Node.*;
import java.util.ArrayList;

public class Pizza {
    private int pizza_id;
    private String pizza_name;
    private double pizza_price;
    private final double[] PIZZA_COST = {6.75, 6.50, 6.75, 7, 7, 7.50, 7.50, 7.50, 8, 8.50};
    private final String[] PIZZA_OPTIONS = {"Margherita", "Bianca", "Funghi", "Caprese", "Quatro Formaggi", "Pepperoni", "Hawaii", "Prosciutto", "Tuna", "BBQ Chicken"};
    private ArrayList<String> chosenPizzas = new ArrayList<String>();
    private ArrayList<Integer> numberChosenPizza = new ArrayList<Integer>();

    public Pizza() {
        super();
    }
    

    public int getPizza_id(){return this.pizza_id;}

    public void setPizza_id(int number){this.pizza_id = number;}

    public String getPizza_name() {
        return this.pizza_name;
    }

    public void setPizza_name(int option) {
        this.pizza_name = PIZZA_OPTIONS[option];
    }

    public double getPizza_price() {
        return this.pizza_price;
    }

    public void setPizza_price(int option) {
        this.pizza_price = PIZZA_COST[option];
    }

    public String getPIZZA_OPTION(int a) {
        return PIZZA_OPTIONS[a];
    }

    public String[] getPIZZA_OPTION() {
        return PIZZA_OPTIONS;
    }

    // returns the whole array
    public ArrayList<String> getChosenPizzas() {
        return chosenPizzas;
    }

    // returns one pizza
    public String getChosenPizzas(int b) {
        return chosenPizzas.get(b);
    }

    public void setChosenPizzas(String pizzaNum) {
        chosenPizzas.add(pizzaNum);
    }

    public void setNumberChosenPizza(int pizzaNum) {
        numberChosenPizza.add(pizzaNum);
    }

    public ArrayList<Integer> getNumberChosenPizza() {
        return numberChosenPizza;
    }

    public int getNumberChosenPizza(int num) {
        return numberChosenPizza.get(num);
    }
}