package csc280.fantasyworldapi;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

import javax.sql.DataSource;
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/fantasy?allowPublicKeyRetrieval=true&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("pass");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return dataSource;
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        userDetailsManager.setUsersByUsernameQuery(
                "SELECT username, password, true as enabled FROM user WHERE username = ?");
        userDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT username, role FROM user WHERE username = ?");

        userDetailsManager.setRolePrefix("ROLE_");
        userDetailsManager.setEnableAuthorities(true);

        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorize -> authorize
                        .requestMatchers("/user/checkUser").permitAll()
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/class/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/class/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/class/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/class/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/race/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/race/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/race/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/race/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.GET, "/spell/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/spell/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/spell/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/spell/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/character/add").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(withDefaults());

        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.csrf(csrf -> csrf.disable());

        http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:8080"));
            corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
            corsConfiguration.setAllowCredentials(true);
            return corsConfiguration;
        }));

        //System.out.println(BCrypt.hashpw("pass", BCrypt.gensalt()));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

