package nissy.spring.tacos.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 * WebMvcConfigurer 인터페이스는 스프링 MVC를 구성하는 메서드를 정의하고 있다. 
 * 인터페이스임에도 불구하고, 정의된 모든 메서드의 기본적인 구현을 제공한다. 따라서 필요한 메서드만 선택해서 오버라이딩하면 된다.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // addViewControllers() 메서드는 하나 이상의 뷰 컨트롤러를 등록하기 위해 사용할 수 있는 ViewControllerRegistry를 인자로 받는다.
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 여기서는 뷰 컨트롤러가 GET 요청을 처리하는 경로인 "/"를 인자로 전달하여 addViewController()를 호출한다.
        // 이 메서드는 ViewControllerRegistration 객체를 반환한다. 
        // 그리고 "/" 경로의 요청이 전달되어야 하는 뷰로 home을 지정하기 위해 연달아 ViewControllerRegistration 객체의 setViewName()을 호출한다.
        registry.addViewController("/").setViewName("home");
    }
    
}
