package net.likelion.bebc25.spring.componentscan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

// 스프링 컨테이너에 알려주는 앱 설정 클래스
@Configuration
@EnableAspectJAutoProxy // 스프링 컨테이너에 @Aspect 어노테이션이 붙은 빈들을 찾아서 프록시 처리를 하도록 지시
@ComponentScan  // Bean으로 등록될 클래스에게 @Component를 붙여주면 @ComponentScan 으로 @Component 붙은 클래스들을 Bean으로 인식해서 사용함
// Bean은 고유성을 가지기 때문에 동일한 타입의 Bean이 여러개 있을때 NoUniqueBeanDefinitionException 에러가 발생하게 되는데,
// 이때 @Primary라는 어노테이션을 사용하게 되면 같은 타입의 Bean 중에서도 해당 어노테이션을 우선으로 사용할 수 있음.
public class AppConfig {

}
