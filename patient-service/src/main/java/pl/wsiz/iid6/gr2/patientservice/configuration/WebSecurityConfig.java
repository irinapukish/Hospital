package pl.wsiz.iid6.gr2.patientservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/medicine/**").hasRole("ADMIN")
                .antMatchers("/medicineWeb/**").permitAll()
                .antMatchers("/patientWeb/**").permitAll()
                .antMatchers("/patient/**").hasRole("ADMIN")
                .antMatchers("/api/patient/**").hasRole("ADMIN")
                .antMatchers("/api/medicine/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout");
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();
        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build();
        UserDetails lekarz =
                User.withDefaultPasswordEncoder()
                        .username("doktor")
                        .password("qwer1234")
                        .roles("LEKARZ")
                        .build();
        UserDetails administ =
                User.withDefaultPasswordEncoder()
                        .username("ekspert")
                        .password("qwer1234")
                        .roles("ADMINISTRACJA")
                        .build();
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails zm = User.withUsername("zm")
                .password(encoder.encode("zm"))
                .roles("ADMIN").build();


        return new InMemoryUserDetailsManager(user,admin,zm,lekarz,administ);
    }
}