import model.Customer;
import model.Dish;
import model.Order;
import repository.InMemoryOrderRepository;
import repository.OrderRepository;
import service.OrderService;

public class Main {

    public static void main(String[] args) {

        OrderRepository repository =
                new InMemoryOrderRepository();

        OrderService orderService =
                new OrderService(repository, 500);

        Customer customer =
                new Customer(1, "Иван");

        Dish pizza =
                new Dish(1, "Пицца", 600);

        Dish burger =
                new Dish(2, "Бургер", 350);

        Dish fries =
                new Dish(3, "Картошка", 200);

        Order order =
                new Order(1, customer);

        order.addDish(pizza);
        order.addDish(fries);

        System.out.println(
                "Клиент: " + customer.getName()
        );

        System.out.println(
                "Сумма заказа: " + order.getTotalAmount()
        );

        orderService.createOrder(order);

        System.out.println(
                "Заказ успешно оформлен!"
        );
    }
}