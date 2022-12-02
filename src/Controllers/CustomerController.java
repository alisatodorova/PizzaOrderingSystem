package Controllers;

import Database.*;
import Node.*;
import java.util.Scanner;

public class CustomerController {

    static Scanner input = new Scanner(System.in);
    static CustomerDAO customerDAO = new CustomerDAO();
    static Customer newCustomer = new Customer();
    static Customer existingCustomer = new Customer();

    public boolean logInContoller(Customer logInInfo)
    {
        boolean logIn=customerDAO.logInMatch(logInInfo);
        if(logIn==true)
        {
            System.out.println("Login was successful! We're happy to see you again!");
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean registerContoller(Customer registerInfo) {
        boolean register = customerDAO.checkRegistration(registerInfo);
        if (register == true) {
            System.out.println("Registration was successful! Welcome to our pizzeria family!");
            return true;
        } else {
            System.out.println("Registration was unsuccessful!");
            return false;
        }
    }

    public String logInInput() {
        System.out.println("Please enter your user name: ");
        String user_name = input.nextLine();
        existingCustomer.setUser_name(user_name);
        System.out.println("Please enter your password: ");
        String password = input.nextLine();
        existingCustomer.setPassword(password);
        boolean checkLogIn = logInContoller(existingCustomer);
        if (checkLogIn == true) {
            return "Success";
        } else {
            return "Fail";
        }
    }

    public String registerInput() {
        System.out.println("Enter your first name: ");
        String first_name = input.next();
        newCustomer.setFirst_name(first_name);
        System.out.println("Enter your last name: ");
        String last_name = input.next();
        newCustomer.setLast_name(last_name);
        System.out.println("Enter your telephone number: ");
        String telephone_number = input.next();
        newCustomer.setTelephone_number(telephone_number);
        System.out.println("Enter your street address: ");
        String street_address = input.next();
        newCustomer.setStreet_address(street_address);
        System.out.println("Enter your postal code: ");
        int postal_code = input.nextInt();
        newCustomer.setPostal_code(postal_code);
        System.out.println("Create a user name: ");
        String user_name = input.next();
        newCustomer.setUser_name(user_name);
        System.out.println("Create a password: ");
        String password = input.next();
        newCustomer.setPassword(password);
        boolean checkRegister = registerContoller(newCustomer);
        if (checkRegister == true) {
            return "Success";
        } else {
            return "Fail";
        }
    }
}
