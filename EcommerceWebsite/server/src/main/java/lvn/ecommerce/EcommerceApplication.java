package lvn.ecommerce;

import lvn.ecommerce.others.propertyResource.DBConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EcommerceApplication.class, args);
		DBConnection connection = context.getBean(DBConnection.class);
		System.out.println();
		System.out.println(connection.getAppName() + " is running");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
}

// @BaseAPI: http://localhost:8080/