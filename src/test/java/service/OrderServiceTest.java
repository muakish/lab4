
        package service;

import model.Customer;
import model.Dish;
import model.Order;
import org.junit.jupiter.api.Test;
import repository.InMemoryOrderRepository;
import repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void shouldCreateOrderWhenAmountIsEnough() {
        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository, 500);

        Customer customer = new Customer(1, "Иван");
        Dish pizza = new Dish(1, "Пицца", 600);

        Order order = new Order(1, customer);
        order.addDish(pizza);

        service.createOrder(order);

        assertNotNull(repository.findById(1));
    }

    @Test
    void shouldRejectOrderWhenAmountIsTooLow() {
        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository, 500);

        Customer customer = new Customer(1, "Иван");
        Dish fries = new Dish(1, "Картошка", 200);

        Order order = new Order(1, customer);
        order.addDish(fries);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createOrder(order)
        );

        assertNull(repository.findById(1));
    }

    @Test
    void shouldCreateOrderWhenAmountEqualsMinimum() {
        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository, 500);

        Customer customer = new Customer(1, "Иван");
        Dish burger = new Dish(1, "Бургер", 500);

        Order order = new Order(1, customer);
        order.addDish(burger);

        service.createOrder(order);

        assertNotNull(repository.findById(1));
    }

    @Test
    void shouldCreateOrderWithTwoDishes() {
        OrderRepository repository = new InMemoryOrderRepository();
        OrderService service = new OrderService(repository, 500);

        Customer customer = new Customer(2, "Анна");
        Dish pizza = new Dish(2, "Пицца", 300);
        Dish fries = new Dish(3, "Картошка", 300);

        Order order = new Order(2, customer);
        order.addDish(pizza);
        order.addDish(fries);

        service.createOrder(order);
        assertNotNull(repository.findById(2));
    }
}
