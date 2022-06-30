package projekt_bdbt.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/main_operator").access("hasRole('OPERATOR')")
                .antMatchers("/pracownicy/**").access("hasRole('OPERATOR')")
                .antMatchers("/pracownik/**").access("hasRole('OPERATOR')")
                .antMatchers("/newEmployee").access("hasRole('OPERATOR')")
                .antMatchers("/main_klient").access("hasRole('KLIENT')")
                .antMatchers("/main_pracownik").access("hasRole('PRACOWNIK')")
                .antMatchers("/main_manager").access("hasRole('MANAGER')")
                .antMatchers("/pracownicy/**").access("hasAnyRole('MANAGER', 'OPERATOR')")
                .antMatchers("/pracownik/**").access("hasRole('MANAGER')")
                .antMatchers("/umowy/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/umowa/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/klienci/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/klient/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/newEmployee/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/newEmployee/**").access("hasRole('MANAGER')")
                .antMatchers("/newContract/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/editContract/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/editEmployee/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/editClient/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .antMatchers("/newClient/**").access("hasAnyRole('PRACOWNIK','OPERATOR')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                //poniżej modyfikacja
                .and()
                .withUser("operator")
                .password("operator")
                .roles("OPERATOR");
               /* .and()
                .withUser("manager")
                .password("manager")
                .roles("MANAGER"); */

    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
}
