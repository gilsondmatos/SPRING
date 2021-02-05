package org.blogpessoal.blogpessoal.seguranca.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	
	@Bean
	public Docket blogPessoalApi () {
			return new Docket (DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("org.blogpessoal.blogpessoal.controller"))
					.paths(PathSelectors.ant("/**"))
					.build()
					.apiInfo(apiInfo());
	}
		private ApiInfo apiInfo(){
			return new ApiInfoBuilder()
			.title("Blog Pessoal")
			.description("API do Projeto de blog pessoal")
			.version("1.0")
			.contact(contact())
			.build();
}
		private Contact contact(){
			return new Contact("Gilson Amorim",
			"https://github.com/gilsondmatos",
			"Desenvolvedor Java Junior");
			}
}

