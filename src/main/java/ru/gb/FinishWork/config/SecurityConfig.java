package ru.gb.FinishWork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean //возвращаем кастомный MyUserDetailsService, который напишем далее
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth.requestMatchers("/login").permitAll() //вход без авторизации
                        .requestMatchers("/main/**").authenticated()
                        .requestMatchers("admin").hasAuthority("admin")
                        .requestMatchers("admin/**").hasAuthority("admin")
                        .anyRequest().authenticated()) //с авторизацией и аутентификацией
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .loginProcessingUrl("/login")
////                                .defaultSuccessUrl("/welcome")
//                                .permitAll()
//                )
                .build();
    }
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http, UserSecurity userSecurity) throws Exception {
//        http.authorizeHttpRequests(
//                auth -> {
//                    auth
//                            .requestMatchers("/users/{userId}/**").access(userSecurity);
//                }
//        );
//        return http.build();
//    }

    @Bean //Ставим степень кодировки, с которой кодировали пароль в базе
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(5);
    }
}