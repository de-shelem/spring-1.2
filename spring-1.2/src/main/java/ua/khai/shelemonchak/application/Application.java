package ua.khai.shelemonchak.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ua.khai.shelemonchak.application.configuration.TestingConfig;
import ua.khai.shelemonchak.application.services.TestingImpl;
@Configuration
public class Application {
@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
	return new PropertySourcesPlaceholderConfigurer();
}
	public static void	main (String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(TestingConfig.class);
		context.refresh();
		TestingImpl test = context.getBean(TestingImpl.class);
		test.run();
	}

}




