package nissy.spring.tacos.web;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import nissy.spring.tacos.Ingredient;
import nissy.spring.tacos.Order;
import nissy.spring.tacos.Ingredient.Type;
import nissy.spring.tacos.data.IngredientRepository;
import nissy.spring.tacos.data.TacoRepository;
import nissy.spring.tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private final IngredientRepository ingredientRepo;

    private TacoRepository tacoRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo, TacoRepository tacoRepo) {
        this.ingredientRepo = ingredientRepo;
        this.tacoRepo = tacoRepo;
    }

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(i -> ingredients.add(i));

        Type[] types = Ingredient.Type.values();
        for (Type type : types){
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }

        model.addAttribute("taco", new Taco());

        return "design";
    }

    private Object filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                    .stream()
                    .filter(x -> x.getType().equals(type))
                    .collect(Collectors.toList());
    }

    @ModelAttribute(name = "order")
    public Order order() {
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @PostMapping
    //@Valid 어노테이션은 제출된 Taco 객체의 유효성 검사를 수행하라고 스프링 MVC에 알려준다.
    //어떤 검사의 에러라도 있으면 에러 상세 내역이 Errors 객체에 저장되어 proceeDesign() 메소드에 전달된다. 
    public String processDesign(@Valid Taco design, Errors errors, @ModelAttribute Order order){
        //검사 에러가 있으면 Taco의 처리를 중지하고 "design" 뷰 이름을 반환하여 폼이 다시 보이게 처리
        if(errors.hasErrors()){
            return "design";
        }

        Taco saved = tacoRepo.save(design);
        order.addDesign(saved);
        return "redirect:/orders/current";
    }
}
