package app.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                cors().disable().
                csrf().disable().
                authorizeRequests()
                 .antMatchers("/","/register","/login").anonymous()
                .antMatchers("/user/**","all/test").hasAnyAuthority("User","Admin")
                .antMatchers("/admin/**").hasAuthority("Admin")
                .antMatchers("/css/**", "/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                 .formLogin()
                 .loginPage("/login")
                 .usernameParameter("username")
                 .passwordParameter("password")
                 .defaultSuccessUrl("/user/home")
                .and()
                .logout().logoutSuccessUrl("/login?logout").permitAll()
                .and()
                 .rememberMe()
                 .rememberMeParameter("rememberMe")
                 .userDetailsService(this.userDetailsService())
                 .rememberMeCookieName("user-cookie")
                 .tokenValiditySeconds(200)
                .and()
                 .exceptionHandling().accessDeniedPage("/unauthorized");

    }
}
