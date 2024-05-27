package nissy.spring.tacos.data;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import nissy.spring.tacos.Order;

@Slf4j
@Repository
public class JdbcOrderRepository2 implements OrderRepository{

    @Override
    public Order save(Order order) {
        log.info("JdbcOrderRepository2");
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}
