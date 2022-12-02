package Node;

import Controllers.*;
import Database.*;
import Node.*;

import java.time.LocalDateTime;

public class Delivery {
    private int delivery_id;
    private DeliveryEmployee delivery_employee_id;
    private Order order_id; 
    private LocalDateTime time;

    public enum statusOfOrder {
        cancelled, inProcess, outForDeliver;
    }


    public Delivery() {
        super();
    }

    public int getDelivery_id() {
        return this.delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public DeliveryEmployee getDelivery_employee_id() {
        return this.delivery_employee_id;
    }

    public void setDelivery_employee_id(DeliveryEmployee delivery_employee_id) {
        this.delivery_employee_id = delivery_employee_id;
    }

    public Order getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(Order order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
}
