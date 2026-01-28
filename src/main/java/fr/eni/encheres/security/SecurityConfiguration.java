package fr.eni.encheres.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    /**
     * Service personnalisé pour la gestion des utilisateurs.
     */
    CustomUserDetailsService customUserDetailsService;

    public SecurityConfiguration(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    /**
     * Fournit un encodeur de mots de passe compatible avec plusieurs algorithmes.
     *
     * @return un {@link PasswordEncoder} délégué
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


//    @Bean
//    CommandLineRunner printHashes(PasswordEncoder encoder) {
//        return args -> {
//            System.out.println("admin => " + encoder.encode("admin"));
//            System.out.println("adrien => " + encoder.encode("adrien"));
//            System.out.println("maud => " + encoder.encode("maud"));
//            System.out.println("adrienlc => " + encoder.encode("adrienlc"));
//            System.out.println("desac => " + encoder.encode("desac"));
//        };
//    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.userDetailsService(customUserDetailsService);
//        http.authorizeHttpRequests(auth -> {
//            auth.requestMatchers(HttpMethod.GET, "/mes-encheres").hasRole("USER")
//                    .requestMatchers(HttpMethod.GET, "/mes-ventes").hasRole("USER")
//                    .requestMatchers(HttpMethod.GET, "/mon-compte").hasRole("USER")
//                    .requestMatchers(HttpMethod.GET, "/vendre").hasRole("USER")
//                    .requestMatchers("/*").permitAll()
//                    .requestMatchers("/css/*").permitAll()
//                   .requestMatchers("/image/*").permitAll()
//                    .anyRequest().denyAll();
        http.authorizeHttpRequests(auth -> auth.anyRequest().denyAll()
//        }
        );

        http.formLogin(form -> form
                // URL de la page de connexion personnalisée
                .loginPage("/connexion")
                // URL appelée lors de la soumission du formulaire de login
                .loginProcessingUrl("/connexion")
                // Nom du champ du formulaire pour l'identifiant (username / email / pseudo)
                .usernameParameter("identify")
                // Nom du champ du formulaire pour le mot de passe
                .passwordParameter("password")
                // Page de redirection après une connexion réussie
                // Le 'true' force la redirection même si l'utilisateur voulait accéder à une autre page
                .defaultSuccessUrl("/", true)
                // Page appelée si la connexion échoue
                .failureUrl("/connexion?error=true")
                // Autorise tout le monde à accéder à la page de connexion
                .permitAll()
        );

        http.logout(logout -> logout
                // URL déclenchant la déconnexion
                .logoutUrl("/logout")
                // Page de redirection après une déconnexion réussie
                .logoutSuccessUrl("/")
                // Autorise tout le monde à se déconnecter
                .permitAll()
        );


        return http.build();

    }

    ;

}
