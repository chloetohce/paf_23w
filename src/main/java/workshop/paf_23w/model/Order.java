package workshop.paf_23w.model;

import java.util.Date;

public class Order {
    private int id;
    private Date orderDate;
    private int customerId;
    private double total;
    private double cost;
    
    public Order() {
    }

    public Order(int id, Date orderDate, int customerId, double total, double cost) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.total = total;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    
    
}
