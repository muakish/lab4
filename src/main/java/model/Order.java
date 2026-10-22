package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final Customer customer;
    private final List<Dish> dishes;

    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.dishes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public double getTotalAmount() {
        double total = 0;

        for (Dish dish : dishes) {
            total += dish.getPrice();
        }

        return total;
    }
}