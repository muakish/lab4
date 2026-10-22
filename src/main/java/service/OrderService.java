package service;
import model.Order;
import repository.OrderRepository;

public class OrderService {

    private final OrderRepository repository;
    private final double minimumOrderAmount;

    public OrderService(OrderRepository repository, double minimumOrderAmount) {
        this.repository = repository;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public void createOrder(Order order) {
        if (order.getTotalAmount() < minimumOrderAmount) {
            throw new IllegalArgumentException(
                    "Минимальная сумма заказа: " + minimumOrderAmount
            );
        }

        repository.save(order);
    }

    public Order findOrderById(int id) {
        return repository.findById(id);
    }
}