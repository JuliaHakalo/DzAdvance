package ua;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ImportAutoConfiguration(classes=WebMvcAutoConfiguration.class)
public class DevJavaSpringBoot4Application extends WebMvcConfigurerAdapter{

//	public static void main(String[] args) {
//		ConfigurableApplicationContext run = SpringApplication.run(DevJavaSpringBoot4Application.class, args);
////		CafeRepository repository = run.getBean(CafeRepository.class);
//////		System.out.println(repository.findByName("Aasasas"));
//		
//	}
	public static void main(String[] args) {
		SpringApplication.run(DevJavaSpringBoot4Application.class, args);
	}
//	@Value("${user}")
//	String user;
	
//	@Autowired
//	UserHandleMethodArgumentResolver userResolver;
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setOneIndexedParameters(true);
		argumentResolvers.add(resolver);
//		argumentResolvers.add(userResolver);
		super.addArgumentResolvers(argumentResolvers);
	}
//	@Bean
//	String home() {
//		System.out.println(user);
//		return user;
//		}
	
}