
import Controllers.CustomerController;
import Controllers.OrderController;
import Database.BaseQuery;

import java.util.*;

public class Main {
    static CustomerController customerController = new CustomerController();
    static OrderController orderController = new OrderController();
    static BaseQuery baseQuery = new BaseQuery();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        baseQuery.getConnection();

        printMenu();

        orderController.createOrder();

        System.out.println("We need your delivery details to proceed with the order. " +
                "\nDo you already have an account? Type Y/N:");
        String answer1 = input.nextLine();
        if (answer1.equalsIgnoreCase("Y")) {
            customerController.logInInput();
        } else {
            System.out.println("You have to make an account to proceed.");
            customerController.registerInput();
        }

        System.out.println("Do you wish to proceed with ordering? Type Y/N:");
        String answer2 = input.nextLine();
        if (answer2.equalsIgnoreCase("Y")) {
            orderController.viewOrder();
            System.out.println("Your order will be out for delivery in 5 minutes!");
            } else {
                System.out.println("We're sorry to see you go! Goodbye!");
            }
            input.close();
        }

    public static void printMenu() {
        System.out.println("_____________________________________________________________________________________");
        System.out.println("Welcome to our pizzeria!");
        System.out.println("This is our menu: \n");
        System.out.println("PIZZAS");
        System.out.println(
                "Our pizza prices are built from: \n - Node.Pizza Dough: €5 \n - Sauce: €0.50 \n - Cheese: €0.50 \n - Meat/Fish toppings: €1 \n - Veggie/Fruit topping: €0.50 \n - Herbs: €0.25 \n");
        System.out.println("1. Margherita (V) €6.75: Node.Pizza sauce, Mozzarella, Tomatoes, Basil");
        System.out.println("2. Bianca (V) €6.50: Ricotta, Mozzarella, Garlic");
        System.out.println("3. Funghi (V) €6.75: Node.Pizza Sauce, Mozzarella, Mushrooms, Oregano");
        System.out.println("4. Caprese (V) €7: Node.Pizza Sauce, Mozzarella, Tomatoes, Pesto");
        System.out.println("5. Quatro Formaggio (V) €7: Mozzarella, Parmesan, Provolone, Blue Cheese");
        System.out.println("6. Pepperoni €7.50: Node.Pizza Sauce, Mozzarella, Tomatoes, Pepperoni");
        System.out.println("7. Hawaii €7.50: Node.Pizza sauce, Mozzarella, Ham, Pineapple");
        System.out.println("8. Prosciutto €7.50: Node.Pizza Sauce, Mozzarella, Prosciutto, Rocket Salad");
        System.out.println("9. Tuna €8: Node.Pizza Sauce, Mozzarella, Tuna, Red Onion, Black Olives");
        System.out.println("10. BBQ Chicken €8.50: BBQ Sauce, Mozzarella, Chicken, Red Onion, Bell Pepper, Corn");
        System.out.println(" * (V) = vegetarian pizza");
        System.out.println("_____________________________________________________________________________________");
        System.out.println("DESSERTS (€3): \n 1. Brownie \n 2. Vanilla Ice Cream");
        System.out.println("_____________________________________________________________________________________");
        System.out.println("DRINKS (€2.50): \n 1. Water \n 2. Lemonade \n 3. Coca Cola \n 4. Fanta");
        System.out.println("_____________________________________________________________________________________");
    }
}