package nissy.spring.tacos;

import java.util.Date;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private Date placedAt;

    //name이 빈 값이면 안된다는 어노테이션과 메세지
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip code is required")
    private String zip;

    //속성의 값이 Luhn(룬) 알고리즘 검사에 합격한 유효한 신용 카드 번호이어야 한다는 것을 선언하는 어노테이션
    //실제로 존재하는 카드 번호인지 대금 지불이 가능한 카드인지 확인은 불가능
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;

    //정규식을 이용한 패턴을 정할 수 있는 어노테이션
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;

    //입력 값이 정확하게 3자리 숫자인지 확인할 수 있는 어노테이션
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
}
