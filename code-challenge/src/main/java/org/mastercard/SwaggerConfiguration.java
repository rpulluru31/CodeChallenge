package org.mastercard;



import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket postsApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).groupName("RouteBetweenCities").apiInfo(apiInfo()).select().paths(PathSelectors.any()).build();
	}
	
	private ApiInfo apiInfo()
	{
		return new ApiInfo("CommuteService","All Crud Operatipons","1.0","company Policy Url",new Contact("Rajani","www.rp.com","rpulluru31@gmail.com"),"OpenSource","License Url", new ArrayList());
	}
}