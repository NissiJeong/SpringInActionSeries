package nissy.spring.tacos.data;

import org.springframework.data.repository.CrudRepository;

import nissy.spring.tacos.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long>{
    // Taco save(Taco design);
}
