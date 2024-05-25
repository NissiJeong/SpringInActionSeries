package nissy.spring.tacos.data;

import nissy.spring.tacos.Order;

public interface OrderRepository {
    Order save(Order order);
}
