//package csc280.fantasyworldapi; /**
// * @author dmann
// * @createdOn 11/17/2023 at 7:26 PM
// * @projectName Fantasy World API
// * @packageName csc280.fantasyworldapi;
// */
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//
//import java.util.Arrays;
//
//import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user").password(passwordEncoder().encode("pass")).build());
//        return manager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(withDefaults())
//                .authorizeHttpRequests(authorize ->
//                    authorize
//                        .requestMatchers("/class").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//
//        http
//                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.NEVER))
//                .csrf(csrf -> csrf.disable());
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}