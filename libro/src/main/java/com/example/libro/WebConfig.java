package com.example.libro;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")  // Asegúrate de que el frontend está en esta URL
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Los métodos permitidos
                .allowedHeaders("*")  // Permitir cualquier encabezado
                .allowCredentials(true);  // Permitir credenciales si es necesario
    }
}
