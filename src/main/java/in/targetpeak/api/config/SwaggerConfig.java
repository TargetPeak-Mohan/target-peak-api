package in.targetpeak.api.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//	@Bean
//	  public Docket api() {
//	    return new Docket(DocumentationType.SWAGGER_2)//
//	        .select()//
//	        .apis(RequestHandlerSelectors.any())//
//	        .paths(Predicates.not(PathSelectors.regex("/error")))//
//	        .build()//
//	        .apiInfo(metadata())//
//	        .useDefaultResponseMessages(false)//
//	        .securitySchemes(Collections.singletonList(apiKey()))
//	        .securityContexts(Collections.singletonList(securityContext()))
//	        .tags(new Tag("users", "Operations about users"))//
//	        .genericModelSubstitutes(Optional.class);
//
//	  }

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(Boolean.TRUE).select()
				.apis(RequestHandlerSelectors.basePackage("in.targetpeak.api.controller")).paths(PathSelectors.any())
				// .paths(Predicates.not(PathSelectors.regex("/logout.*")))
				.build().apiInfo(metadata());
	}

	private ApiInfo metadata() {
		return new ApiInfoBuilder()//
				.title("Target Peak APIs")//
				.description("APIs full documentation")//
				.version("1.0.0")//
				.license("MIT License").licenseUrl("http://opensource.org/licenses/MIT")//
				.contact(new Contact(null, null, "mohanappdevelopment@gmail.com"))//
				.build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Authorization", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
	}

//	  private ApiInfo apiInfo() {
//			return new ApiInfoBuilder().title("TARGET PEAK API")
//					.description("Target PEAK API reference for developers")
//					.termsOfServiceUrl("http://targetpeak.in")
//					.contact("mohanappdeveloper@gmail.com").build();
//					//.license("JavaInUse License")
//					//.licenseUrl("javainuse@gmail.com").version("1.0").build();
//		}
}
