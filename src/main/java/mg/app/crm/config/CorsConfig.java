package mg.app.crm.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .csrf(csrf -> csrf.disable()) // Désactive CSRF si tu n'utilises pas les cookies/sessions
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/**").permitAll() // Autoriser ces endpoints
                                .requestMatchers(org.springframework.http.HttpMethod.OPTIONS, "/**").permitAll() // Autoriser les requêtes OPTIONS
                                .requestMatchers(request -> "localhost:5173".equals(request.getHeader("Origin"))).permitAll() // Autoriser les requêtes provenant de localhost:5173
                                .anyRequest().authenticated()
                )
                .formLogin(login -> login.disable()); // Désactive la page de login par défaut

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:5173"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
