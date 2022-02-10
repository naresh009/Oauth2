package com.slokam.oauth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableGlobalMethodSecurity
@SpringBootApplication
@EnableResourceServer
@ComponentScan(basePackages={"com.slokam.oauth"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

@SuppressWarnings("deprecation")
@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    
    CorsConfiguration configAutenticacao = new CorsConfiguration();
    configAutenticacao.setAllowCredentials(true);
    //configAutenticacao.addAllowedOrigin("http://localhost:4200");
    configAutenticacao.addAllowedOrigin("*");
    configAutenticacao.addAllowedHeader("Authorization");
    configAutenticacao.addAllowedHeader("Content-Type");
    configAutenticacao.addAllowedHeader("Accept");
    configAutenticacao.addAllowedMethod("POST");
    configAutenticacao.addAllowedMethod("GET");
    configAutenticacao.addAllowedMethod("DELETE");
    configAutenticacao.addAllowedMethod("PUT");
    configAutenticacao.addAllowedMethod("OPTIONS");
    configAutenticacao.setMaxAge(3600L);
    //source.registerCorsConfiguration("/oauth/token", configAutenticacao);
    source.registerCorsConfiguration("/**", configAutenticacao); 
    // Global for all paths
    
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return bean;
}}
/*@Configuration
 class Config {
 
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
 
}
*/