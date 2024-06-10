package nissy.spring.tacos.data;

import org.springframework.data.repository.CrudRepository;

import nissy.spring.tacos.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{
    // Order save(Order order);
}
