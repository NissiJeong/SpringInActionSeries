package nissy.spring.tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import nissy.spring.tacos.Ingredient;
import nissy.spring.tacos.Ingredient.Type;
import nissy.spring.tacos.Taco;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tottilla", Type.WRAP),
            new Ingredient("COTO", "Corn Tottilla", Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Type.CHEESE),
            new Ingredient("SRCR", "Sour Cream", Type.SAUCE)
        );

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

    @PostMapping
    public String processDesign(Taco design){
        log.info("Processing design: " + design);
        return "redirect:/orders/current";
    }
}
