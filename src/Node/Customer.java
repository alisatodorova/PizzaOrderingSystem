package Node;
import Controllers.*;
import Database.*;
import Node.*;
public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String telephone_number;
    private String street_address;
    private int postal_code;
    private int pizzas_ordered;
    private String user_name;
    private String password;

    public int getCustomer_id(){return this.customer_id;}

    public void setCustomer_id(int customer_id){this.customer_id = customer_id;}

    public String getFirst_name() {
        return this.first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return this.last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTelephone_number() {
        return this.telephone_number;
    }

    public void setTelephone_number(String telephone_number) {
        this.telephone_number = telephone_number;
    }

    public String getStreet_address() {
        return this.street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public int getPostal_code() {
        return this.postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public int getPizzas_ordered() {
        return this.pizzas_ordered;
    }

    public void setPizzas_ordered(int pizzas_ordered) {
        this.pizzas_ordered = pizzas_ordered;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
