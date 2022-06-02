package dev.brianmviana.hexaarch.configs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.any())
            .paths(PathSelectors.any())
            .build()
    }

    private fun getApiInfo(): ApiInfo {
        val contact = Contact("Brian M. Viana", "http://brianmviana.dev", "brianmviana@gmail.com")
        return ApiInfoBuilder()
            .title("Netflix Hexagonal Architecture")
            .description("Netflix Hexagonal Architecture with Kotlin")
            .version("1.0.0")
            .license("MIT")
            .licenseUrl("https://github.com/brianmviana/netflix-hexagonal-architecture/blob/master/LICENSE")
            .contact(contact)
            .build()
    }

}