package service;
import model.Order;
import repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderService {

    private static final Logger logger =
            LoggerFactory.getLogger(OrderService.class);
    private final OrderRepository repository;
    private final double minimumOrderAmount;

    public OrderService(OrderRepository repository, double minimumOrderAmount) {
        this.repository = repository;
        this.minimumOrderAmount = minimumOrderAmount;
    }

    public void createOrder(Order order) {
            logger.info("Начато оформление заказа");

            if (order.getTotalAmount() < minimumOrderAmount) {
                logger.warn("Заказ отклонен: сумма меньше минимальной");
                throw new IllegalArgumentException("Сумма заказа меньше минимальной");
            }

            try {
                logger.info("Заказ успешно оформлен");
            } catch (Exception e) {
                logger.error("Ошибка при оформлении заказа", e);
                throw e;
            }

        repository.save(order);
    }

    public Order findOrderById(int id) {
        return repository.findById(id);
    }
}
