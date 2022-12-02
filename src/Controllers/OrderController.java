package Controllers;

import Database.*;
import Node.*;
import java.util.Scanner;

public class OrderController {

    Scanner input = new Scanner(System.in);
    Order order = new Order();
    OrderDAO orderDAO = new OrderDAO();
    Orderline orderline = new Orderline();
    Pizza pizza = new Pizza();
    Drink drink = new Drink();
    Dessert dessert = new Dessert();
    static double totalPizzaPrice = 0;
    static double totalDrinksPrice = 0;
    static double totalDessertsPrice = 0;
    static double totalOrderPrice;


    public void displayOrderedPizzas() {
        System.out.println("The pizza(s) you have ordered are: \n");
        System.out.println(pizza.getChosenPizzas());
    }

    public void displayOrderedDrinks() {
        System.out.println("The drink(s) you have ordered are: \n");
        System.out.println(drink.getChosenDrinks());
    }

    public void displayOrderedDesserts() {
        System.out.println("The dessert(s) you have ordered are: \n");
        System.out.println(dessert.getChosenDesserts());
    }

//    public void placeOrder() {
//
//        System.out.println("Do you have a discount code? Type Y/N:");
//        String answer1 = input.nextLine();
//        if (answer1.equalsIgnoreCase("Y")) {
//            //apply discount code
//        }
//    }

    public void createOrder(){
        System.out.println("\n Let's start your order!");
        System.out.println("\n How many pizza's do you want?");
        int numPizzas = input.nextInt();
        if (numPizzas == 0) {
            throw new IllegalArgumentException("Order at least one pizza.");
        } else {
            orderline.setPizza_amount(numPizzas);
            int i = 1;
            while (i <= numPizzas) {
                i++;
                System.out.println("Which pizza do you want? Type the number from the menu:");
                int currentPizza = input.nextInt() - 1;
                pizza.setPizza_id(currentPizza);
                pizza.setPizza_name(currentPizza); // takes the input integer, and it sets the pizza name in the (String) variable pizza_name in Node.Pizza class
                pizza.setChosenPizzas(pizza.getPizza_name()); // saves pizza name in the arraylist
                pizza.setNumberChosenPizza(currentPizza - 1);
                pizza.setPizza_price(currentPizza);

                if (currentPizza >= 0 && currentPizza < 11) {
                    totalPizzaPrice = totalPizzaPrice + pizza.getPizza_price();
                } else {
                    throw new IllegalArgumentException("Not an option from the menu");
                }

            }
        }

        System.out.println("How many drinks do you want?");
        int drinks = input.nextInt();
        orderline.setDrink_amount(drinks);
        int k = 0;

        if (drinks == 0) {
            System.out.println("No drinks ordered.");
        } else {
            while (k < drinks) {
                System.out.println("Which drink(s) do you want? Type the number from the menu. You can choose " + (drinks - k) + " drink(s) now");
                int currentDrink = input.nextInt() - 1;
                drink.setDrink_id(currentDrink);
                drink.setDrink_name(currentDrink);
                drink.setChosenDrinks(drink.getDrink_name());
                drink.setDrink_name(currentDrink);
                if (currentDrink < 0 && currentDrink > 4) {
                    throw new IllegalArgumentException("Not an option from the menu");
                }
                k++;
            }
        }

        System.out.println("How many desserts do you want?");
        int desserts = input.nextInt();
        orderline.setDessert_amount(desserts);
        int l = 0;
        if (desserts == 0) {
            System.out.println("No desserts ordered.");
        } else {
            while (l < desserts) {
                System.out.println("Which dessert(s) do you want? Type the number from the menu. You can choose " + (desserts - l) + " dessert(s) now");
                int currentDessert = input.nextInt() - 1;
                dessert.setDessert_id(currentDessert);
                dessert.setDessert_name(currentDessert);
                dessert.setChosenDesserts(dessert.getDessert_name());
                dessert.setDessert_name(currentDessert);
                if (currentDessert < 0 && currentDessert > 2) {
                    throw new IllegalArgumentException("Not an option from the menu");
                }
                l++;
            }
        }

        totalDrinksPrice = drinks * drink.getDRINKS_COST();
        totalDessertsPrice = desserts * dessert.getDESSERTS_COST();
        totalOrderPrice = totalPizzaPrice + totalDrinksPrice + totalDessertsPrice;
        order.setTotal_price(totalOrderPrice);

        boolean checkOrder = orderDAO.placeOrder(pizza.getChosenPizzas(), drink.getChosenDrinks(), dessert.getChosenDesserts());
        if(checkOrder==true)
            System.out.println("Order is successfully placed!");
        else
            System.out.println("Error! Order is not placed!");
    }

    public void viewOrder(){
        System.out.println("You have chosen " + orderline.getPizza_amount() + " pizza(s). This costs: €" + totalPizzaPrice);
        displayOrderedPizzas();
        System.out.println("You have chosen " + orderline.getDrink_amount() + " drink(s). This costs: €" + totalDrinksPrice);
        displayOrderedDrinks();
        System.out.println("You have chosen " + orderline.getDessert_amount() + " dessert(s). This costs: €" + totalDessertsPrice);
        displayOrderedDesserts();
        System.out.println("Your total price will be: €" + order.getTotal_price());
        System.out.println("Your total price + 9% VAT will be: €" + order.getTotal_price() * 1.09); // including 9% VAT
    }
}
