package cn.ufan0.blog_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BlogTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogTestApplication.class, args);
    }

    /**
     * 跨域访问
     * https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-cors
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("GET")
                        .allowCredentials(true).maxAge(3600);
            }
        };
    }

}
