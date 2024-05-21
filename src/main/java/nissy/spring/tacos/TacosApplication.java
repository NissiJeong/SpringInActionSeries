package nissy.spring.tacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //해당 부트 클래스에 추가하여 해당 프로젝트에서 스프링 스케줄러 사용 가능하도록 함.
public class TacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacosApplication.class, args);
	}

}
