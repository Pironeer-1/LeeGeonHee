package com.pironeer._th.global.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Pironeer Week4 API 명세서",
                description = "API 명세서",
                version = "v1",
                contact = @Contact(
                        name = "이건희",
                        email = "leegh1925@gmail.com"
                )
        ),
        security = @SecurityRequirement(name = "bearerAuth")
)

@SecurityScheme(
        name = "bearerAuth",      // 보안 스키마 이름
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",        // Bearer 토큰 방식 사용
        bearerFormat = "JWT"      // JWT 형식
)

@Configuration
public class OpenApiConfig {
}
