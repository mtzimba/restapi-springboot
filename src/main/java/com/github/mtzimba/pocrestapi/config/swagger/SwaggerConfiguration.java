package com.github.mtzimba.pocrestapi.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.mtzimba.pocrestapi.model.Usuario;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.github.mtzimba.pocrestapi"))
				.paths(PathSelectors.ant("/**")).build()
				.ignoredParameterTypes(Usuario.class)
				.globalOperationParameters(Arrays.asList(new ParameterBuilder()
						.name("Authorization")
						.description("Header para Token JWT")
						.modelRef(new ModelRef("string"))
						.parameterType("header")
						.required(false)
						.build()));
	}
}
