package nissy.spring.tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import nissy.spring.tacos.Ingredient.Type;
import nissy.spring.tacos.data.IngredientRepository;
import nissy.spring.tacos.data.UserRepository;

@SpringBootApplication
@EnableScheduling //해당 부트 클래스에 추가하여 해당 프로젝트에서 스프링 스케줄러 사용 가능하도록 함.
public class TacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacosApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo, UserRepository userRepo){
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
				repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
				repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
				repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
				repo.save(new Ingredient("TMTO", "Diced Tomatos", Type.VEGGIES));
				repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
				repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
				repo.save(new Ingredient("JACK", "Monterrey", Type.CHEESE));
				repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
				repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

				userRepo.save(new User(1, "admin", "$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi", "admin", true));
			}
			
		};
	}
}
