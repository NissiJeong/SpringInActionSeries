package nissy.spring.tacos;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //id 속성에는 데이터베이스가 자동으로 생성해주는 ID값이 사용되므로 strategy 속성의 값이 GenerationType.AUTO로 설정된 @GeneratedValue 사용
    private Long id;
    private Date createdAt;
    
    @NotNull //타코의 이름은 NULL 일 수 없다는 어노테이션
    @Size(min = 5, message = "Name must be at least 5 characters long") //이름의 최소 사이즈는 5이고 그에 대한 오류 메세지
    private String name;

    @ManyToMany(targetEntity = Ingredient.class)
    //하나의 Taco 객체는 많은 Ingredient 객체를 가질 수 있고, 하나의 Ingredient는 여러 Taco 객체에 포함될 수 있는 관계를 나타낸 어노테이션
    @Size(min = 1, message = "You must choose at least 1 ingredient") //재료는 최소 1개 이상 선택해야 하고 그에 대한 오류 메세지
    private List<Ingredient> ingredients;

    @PrePersist
    //Taco 객체가 저장되기 전에 createdAt 속성을 현재 일자와 시간으로 설정하는 역할
    void createdAt(){
        this.createdAt = new Date();
    }
}
