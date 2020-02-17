package co.com.virgin.lmd.version.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author eyder.ascuntar
 * @email eyder.ascuntar@virginmobilecolombia.com
 * @category Configuration
 * @version 1.0
 * 
 */

@SpringBootApplication
@EnableSwagger2
public class ConfigApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return new RestTemplate();
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("co.com.virgin.lmd.version.apps.controllers"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		Contact contact = new Contact("Eyder Ascuntar Rosales", "https://www.virginmobile.co",
				"eyder.ascuntar@virginmobilecolombia.com");
		return new ApiInfoBuilder().title("API RESTful versionamiento de las Apps de Virgin Mobile").description(
				"Esta api describe la funcionalidad para los servicios tipo Rest expuestos para Operaciones de la logica de negocio para las versiones de las Apps de VMCO.")
				.version("1.0.0").license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.contact(contact).build();
	}
}