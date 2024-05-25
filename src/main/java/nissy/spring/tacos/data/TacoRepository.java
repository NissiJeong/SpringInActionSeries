package nissy.spring.tacos.data;

import nissy.spring.tacos.Taco;

public interface TacoRepository {
    Taco save(Taco design);
}
