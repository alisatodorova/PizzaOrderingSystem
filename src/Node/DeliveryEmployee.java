package Node;

import Controllers.*;
import Database.*;
import Node.*;

public class DeliveryEmployee {
    private int delivery_employee_id;
    private int postal_code;
    private boolean isAvailable;
   private String employee_name;


    public DeliveryEmployee(int delivery_employee_id, int postal_code, boolean isAvailable, String employee_name) {
        this.delivery_employee_id = delivery_employee_id;
        this.postal_code = postal_code;
        this.isAvailable = isAvailable;
        this.employee_name = employee_name;
    }

    public int getDelivery_employee_id() {
        return this.delivery_employee_id;
    }

    public void setDelivery_employee_id(int delivery_employee_id) {
        this.delivery_employee_id = delivery_employee_id;
    }

    public int getPostal_code() {
        return this.postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public boolean isIsAvailable() {
        return this.isAvailable;
    }

    public boolean getIsAvailable() {
        return this.isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getEmployee_name() {
        return this.employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

}
