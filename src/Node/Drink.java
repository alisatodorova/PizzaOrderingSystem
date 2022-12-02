package Node;

import java.util.ArrayList;

public class Drink {
    int drink_id;
    String drink_name;
    double drink_price;
    private final double DRINKS_COST = 2.50;
    private final String[] DRINKS_OPTIONS = { "Water", "Lemonade", "Coca Cola",  "Fanta" };
    private ArrayList<String> chosenDrinks = new ArrayList<String>();

    public Drink() {
    }

    public int getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(int drink_id) {
        this.drink_id = drink_id;
    }


    public double getDrink_price() {
        return drink_price;
    }

    public void setDrink_price(double drink_price) {
        this.drink_price = drink_price;
    }

    public void setChosenDrinks(ArrayList<String> chosenDrinks) {
        this.chosenDrinks = chosenDrinks;
    }

    public String getDrink_name() {
        return this.drink_name;
    }

    public void setDrink_name(int option) {
        this.drink_name = DRINKS_OPTIONS[option];
    }
    public double getDRINKS_COST() {
        return this.DRINKS_COST;
    }

    public String[] getDRINKS_OPTIONS() {
        return this.DRINKS_OPTIONS;
    }

    public ArrayList<String> getChosenDrinks() {
        return chosenDrinks;
    }

    public String getChosenDrinks(int c) {
        return chosenDrinks.get(c);
    }

    public void setChosenDrinks(String drinksNum) {
        chosenDrinks.add(drinksNum);
    }
}
