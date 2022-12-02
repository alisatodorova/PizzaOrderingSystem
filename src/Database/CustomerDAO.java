package Database;

import Node.*;
import java.sql.*;

public class CustomerDAO extends BaseQuery {

    PreparedStatement customerInfo;

public boolean logInMatch(Customer logInInfo){
    String user_name = logInInfo.getUser_name();
    String password = logInInfo.getPassword();
    String passwordFromDatabase = "";

    try {
        Connection connect = conn;
        customerInfo=connect.prepareStatement("SELECT password FROM customer WHERE user_name = ?");
        customerInfo.setString(1, user_name);
        ResultSet results=customerInfo.executeQuery();

        while (results.next()) {
           passwordFromDatabase = results.getString(1);
        }
    }
    catch (SQLException e) {
        System.out.println("Error: \n" + e);
    } finally {
        try {
            customerInfo.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if(password.equals(passwordFromDatabase)){
        return true;
    }
    else{
        return false;
    }
}

public boolean checkRegistration(Customer registerInfo) {
    String first_name = registerInfo.getFirst_name();
    String last_name = registerInfo.getLast_name();
    String telephone_number = registerInfo.getTelephone_number();
    String street_address = registerInfo.getStreet_address();
    int postal_code = registerInfo.getPostal_code();
    Orderline orderline = new Orderline();
    int pizzas_ordered = orderline.getPizza_amount();
    String user_name = registerInfo.getUser_name();
    String password = registerInfo.getPassword();

    try {
        Connection connect = conn;
        customerInfo = conn.prepareStatement("INSERT INTO customer (first_name, last_name, telephone_number, street_address, postal_code, pizzas_ordered, user_name, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        customerInfo.setString(1, first_name);
        customerInfo.setString(2, last_name);
        customerInfo.setString(3, telephone_number);
        customerInfo.setString(4, street_address);
        customerInfo.setInt(5, postal_code);
        customerInfo.setInt(6,pizzas_ordered);
        customerInfo.setString(7, user_name);
        customerInfo.setString(8, password);

        int i = customerInfo.executeUpdate();
        if(i == 1){return true;}
    } catch (SQLException e) {
        System.out.println("Error: \n" + e);
    } finally {
        try {
            customerInfo.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return false;
}
}

