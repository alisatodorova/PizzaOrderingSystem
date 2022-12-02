package Node;

import Controllers.*;
import Database.*;
import Node.*;

import java.util.ArrayList;

public class Dessert {
    int dessert_id;
    String dessert_name;
    double dessert_price;
    private final double DESSERTS_COST = 3;
    private final String[] DESSERT_OPTIONS = { "Brownie", "Vanilla Ice Cream" };
    private ArrayList<String> chosenDesserts = new ArrayList<String>();

    public Dessert() {
    }

    public int getDessert_id() {
        return dessert_id;
    }

    public void setDessert_id(int dessert_id) {
        this.dessert_id = dessert_id;
    }

    public String getDessert_name() {
        return this.dessert_name;
    }

    public void setDessert_name(int option) {
        this.dessert_name = DESSERT_OPTIONS[option];
    }

    public double getDESSERTS_COST() {
        return this.DESSERTS_COST;
    }

    public String[] getDESSERT_OPTIONS() {
        return this.DESSERT_OPTIONS;
    }

    public ArrayList<String> getChosenDesserts() {
        return chosenDesserts;
    }

    public String getChosenDesserts(int d) {
        return chosenDesserts.get(d);
    }

    public void setChosenDesserts(String dessertsNum) {
        chosenDesserts.add(dessertsNum);
    }


}
