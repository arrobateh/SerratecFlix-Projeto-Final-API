package org.serratec.SerratecFlix.config;

import org.serratec.SerratecFlix.security.JwtAuthenticationFilter;
import org.serratec.SerratecFlix.security.JwtAuthorizationFilter;
import org.serratec.SerratecFlix.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class ConfigSeguranca {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CorsConfigurationSource corsConfigurationSource) throws Exception {
        AuthenticationManager authManager = authenticationConfiguration.getAuthenticationManager();

        http
                .csrf(csfr -> csfr.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authorizeHttpRequests(auth -> auth
                        // Rotas públicas
                        .requestMatchers("/", "/index.html", "/favicon.ico").permitAll()
                        .requestMatchers(HttpMethod.GET, "/series/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/series/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/filmes/").permitAll()
                        .requestMatchers(HttpMethod.GET, "/filmes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/usuarios/**").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()

                        // Rotas protegidas
                        .requestMatchers(HttpMethod.POST, "/series/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/filmes/**").authenticated()
                        .requestMatchers("/avaliacao-serie/**").authenticated()

                        .anyRequest().authenticated()
                );
        http.addFilter(new JwtAuthenticationFilter(authManager, jwtUtil));
        http.addFilter(new JwtAuthorizationFilter(authManager, jwtUtil, userDetailsService));

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*", "*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
