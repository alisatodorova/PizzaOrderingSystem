package Node;
import Controllers.*;
import Database.*;
import Node.*;
import java.time.LocalDateTime;

public class Order {
    private double total_price;
    private String discount_code;
    private String status;
    private LocalDateTime estimated_delivery_time; 
    private LocalDateTime delivery_placed_time;

    public Order() {
        super();
    }

    public double getTotal_price() {
        return this.total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public String getDiscount_code() {
        return this.discount_code;
    }

    public void setDiscount_code(String discount_code) {
        this.discount_code = discount_code;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getEstimated_delivery_time() {
        return this.estimated_delivery_time;
    }

    public void setEstimated_delivery_time(LocalDateTime estimated_delivery_time) {
        this.estimated_delivery_time = estimated_delivery_time;
    }

    public LocalDateTime getDelivery_placed_time() {
        return this.delivery_placed_time;
    }

    public void setDelivery_placed_time(LocalDateTime delivery_placed_time) {
        this.delivery_placed_time = delivery_placed_time;
    }

}