package fr.eni.encheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration {

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
        jdbc.setUsersByUsernameQuery("select pseudo, password, actif from utilisateur where pseudo = ?");
        jdbc.setAuthoritiesByUsernameQuery("select pseudo, role from roles where pseudo = ?");
        return jdbc;
    };

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers(HttpMethod.GET, "/mes-encheres").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/mes-ventes").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/mon-compte").hasRole("USER")
                    .requestMatchers(HttpMethod.GET, "/vendre").hasRole("USER")
                    .requestMatchers("/*").permitAll()
                    .requestMatchers("/css/*").permitAll()
//                    .requestMatchers("/image/*").permitAll()
                    .anyRequest().denyAll();
        });


        http.formLogin( form -> {
                    form.loginPage("/connexion").permitAll();
                    form.defaultSuccessUrl("/", true);
                }
        );

        http.logout( logout -> {
            logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/");
        });

        return http.build();

    };

}
