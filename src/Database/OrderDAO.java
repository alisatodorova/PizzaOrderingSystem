package Database;

import Node.*;
import java.sql.*;
import java.util.ArrayList;

public class OrderDAO extends BaseQuery {
    PreparedStatement orderInfo;
    Pizza pizza = new Pizza();
    Orderline orderline = new Orderline();
    Customer customer = new Customer();
    Drink drink = new Drink();
    Dessert dessert = new Dessert();

    public boolean placeOrder(ArrayList<String> chosenPizzas, ArrayList<String> chosenDrinks, ArrayList<String> chosenDesserts) {

        int customer_id = customer.getCustomer_id();
        int pizza_id = pizza.getPizza_id();
        int drink_id = drink.getDrink_id();
        int dessert_id = dessert.getDessert_id();
        int pizza_amount = orderline.getPizza_amount();
        int drink_amount = orderline.getDrink_amount();
        int dessert_amount = orderline.getDessert_amount();
        double drink_price = drink.getDRINKS_COST();
        double dessert_price = dessert.getDESSERTS_COST();

        int j = 0;

        for(int i = 0; i < pizza.getNumberChosenPizza().size(); i++) {
            pizza_id = pizza.getNumberChosenPizza(i);

        }

                try {
                    orderInfo = conn.prepareStatement("INSERT INTO orderline (customer_id, pizza_id, drink_id, dessert_id, pizza_amount, drink_amount, dessert_amount) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)");
                    orderInfo.setInt(1, customer_id);
                    orderInfo.setInt(2, pizza_id);
                    orderInfo.setInt(3, drink_id);
                    orderInfo.setInt(4, dessert_id);
                    orderInfo.setInt(5, pizza_amount);
                    orderInfo.setInt(6, drink_amount);
                    orderInfo.setInt(7, dessert_amount);

                    j = orderInfo.executeUpdate();
                    j++;

                } catch (SQLException e) {
                    System.out.println("Error: \n" + e);
                } finally {
                    try {
                        orderInfo.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            if (j != 0) {
                return true;
            } else {
                return false;
            }
    }

    }
