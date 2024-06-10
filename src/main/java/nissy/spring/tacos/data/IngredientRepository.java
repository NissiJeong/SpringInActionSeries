package nissy.spring.tacos.data;

import org.springframework.data.repository.CrudRepository;

import nissy.spring.tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
/*
 * CrudRepository 인터페이스에는 데이터베이스의 CRUD 연산을 위한 많은 메서드가 선언되어 있다.
 * CrudRepository는 매개변수화 타입. 첫 번째 매개변수는 리퍼지터리에 저장되는 개체 타입, 두 번째 매개변수는 개체 ID 속성의 타입.
 */

    // Iterable<Ingredient> findAll();
    // Ingredient findById(String id);
    // Ingredient save(Ingredient ingredient);
}
