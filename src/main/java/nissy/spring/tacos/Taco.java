package nissy.spring.tacos;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {

    private Long id;
    private Date createdAt;
    
    @NotNull //타코의 이름은 NULL 일 수 없다는 어노테이션
    @Size(min = 5, message = "Name must be at least 5 characters long") //이름의 최소 사이즈는 5이고 그에 대한 오류 메세지
    private String name;

    @Size(min = 1, message = "You must choose at least 1 ingredient") //재료는 최소 1개 이상 선택해야 하고 그에 대한 오류 메세지
    private List<Ingredient> ingredients;
}
