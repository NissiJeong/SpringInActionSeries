package nissy.spring.tacos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
//@Data 는 인자가 있는 생성자 자동 추가 @NoArgsConstructor가 지정되면 그런 생성자는 제거. 
//하지만 여기처럼 @RequiredArgsConstructor를 추가하면 private의 인자 없는 생성자와 더불어 인자가 있는 생성자를 여전히 가질 수 있음
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//JPA 에서는 개체가 인자 없는 생성자를 가져야 한다. 그 어노테이션이 @NoArgsConstructor.
//여기서는 인자 없는 생성자의 사용을 원치 않으므로 access 속성을 AccessLevel.PRIVATE 로 설정하여 클래스 외부에서 사용하지 못하도록 하였음.
//그리고 초기화가 필요한 final 속성들이 있으므로 force 속성을 true로 설정.
@Entity //JPA 객체로 선언. 
public class Ingredient {

    @Id //JPA 객체의 속성에는 반드시 @Id를 지정하여 이 속성이 데이터 베이스의 개체를 고유하게 식별한다는 것을 나타내야 한다.
    private final String id;
    private final String name;
    private final Type type;

    public static enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
