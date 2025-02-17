package coid.bcaf.bebootcamp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Disable CSRF protection for simplicity
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/auth/register", "/api/auth/login", "api/auth/user/{id}","api/auth/user/{username}").permitAll() // Allow register/login to be public
                                .requestMatchers("/api/listbox/**", "/api/customers/**").permitAll() // Allow public access to these APIs
                                .anyRequest().authenticated() // All other requests require authentication
                )
                .formLogin().disable()  // Disable default form login
                .httpBasic().disable(); // Disable HTTP Basic Authentication

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // CORS configuration
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200", "https://a128-103-165-222-114.ngrok-free.app", "http://10.0.2.2:4200", "http://10.10.13.37:4200", "http://192.168.50.107:4200", "http://10.10.13.42") // Add ngrok URL here for Android WebView and localhost
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}