package itsgosho.config;

import itsgosho.domain.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserServices userServices;

    @Autowired
    public SecurityConfiguration(UserServices userServices) {
        this.userServices = userServices;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                cors().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/register").anonymous()
                .antMatchers("/css/**", "/js/**").permitAll()
                .antMatchers("/users/isvalid", "/users/exists").permitAll()
                .antMatchers("/","/viruses/show").hasAuthority("USER")
                .antMatchers("/viruses/add","/viruses/edit/**","/viruses/delete/**").hasAuthority("MODERATOR")
                .antMatchers("/users/show").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .rememberMe()
                .userDetailsService(this.userServices)
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("_nf")
                .tokenValiditySeconds(20000)
                .and()
                .exceptionHandling().accessDeniedPage("/unauthorized");
    }
}
